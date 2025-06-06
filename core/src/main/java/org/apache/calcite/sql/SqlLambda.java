/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.calcite.sql;

import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.parser.SqlParserPos;
import org.apache.calcite.sql.validate.SqlLambdaScope;
import org.apache.calcite.sql.validate.SqlValidator;
import org.apache.calcite.sql.validate.SqlValidatorScope;
import org.apache.calcite.util.UnmodifiableArrayList;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * A <code>SqlLambda</code> is a node of a parse tree which
 * represents a lambda expression.
 */
public class SqlLambda extends SqlCall {

  public static final SqlOperator OPERATOR = new SqlLambdaOperator();

  SqlNodeList parameters;
  SqlNode expression;

  public SqlLambda(SqlParserPos pos, SqlNodeList parameters,
                   SqlNode expression) {
    super(pos);
    this.parameters = parameters;
    this.expression = expression;
  }

  //~ Methods ----------------------------------------------------------------

  @Override
  public SqlKind getKind() {
    return SqlKind.LAMBDA;
  }

  @Override
  public SqlOperator getOperator() {
    return OPERATOR;
  }

  @Override
  public List<SqlNode> getOperandList() {
    return UnmodifiableArrayList.of(parameters, expression);
  }

  @Override
  public void setOperand(int i, @Nullable SqlNode operand) {
    switch (i) {
    case 0:
      parameters = requireNonNull((SqlNodeList) operand, "parameters");
      break;
    case 1:
      expression = requireNonNull(operand, "operand");
      break;
    default:
      throw new AssertionError(i);
    }
  }

  @Override
  public void unparse(SqlWriter writer, int leftPrec, int rightPrec) {
    if (parameters.size() != 1) {
      // writer.list(SqlWriter.FrameTypeEnum.PARENTHESES, SqlWriter.COMMA, stripList(parameters));
      writer.print("(");
      boolean first = true;
      for (SqlNode param : stripList(parameters)) {
        if (!first) {
          writer.print(", ");
        }
        param.unparse(writer, leftPrec, rightPrec);
        first = false;
      }
      writer.print(")");
    } else {
      parameters.unparse(writer, leftPrec, rightPrec);
    }
    writer.keyword(OPERATOR.getName());
    expression.unparse(writer, leftPrec, rightPrec);
  }

  private SqlNodeList stripList(SqlNodeList list) {
    // 创建新的空节点列表，保留原位置信息
    SqlNodeList result = new SqlNodeList(list.pos);

    // 遍历原始列表的每个元素
    for (SqlNode node : list) {
      // 对每个节点执行strip操作
      SqlNode strippedNode = strip(node);

      // 将处理后的节点添加到结果列表
      result.add(strippedNode);
    }

    return result;
  }

  /** Converts a single-element SqlNodeList to its constituent node.
   * For example, "(1)" becomes "1";
   * "(2) as a" becomes "2 as a";
   * "(3, 4)" remains "(3, 4)";
   * "(5, 6) as b" remains "(5, 6) as b". */
  private SqlNode strip(SqlNode e) {
    switch (e.getKind()) {
      case AS:
        final SqlCall call = (SqlCall) e;
        final List<SqlNode> operands = call.getOperandList();
        return SqlStdOperatorTable.AS.createCall(e.pos,
                strip(operands.get(0)), operands.get(1));
      default:
        if (e instanceof SqlNodeList && ((SqlNodeList) e).size() == 1) {
          return ((SqlNodeList) e).get(0);
        }
        return e;
    }
  }

  public SqlNodeList getParameters() {
    return parameters;
  }

  public SqlNode getExpression() {
    return expression;
  }

  /**
   * The {@code SqlLambdaOperator} represents a lambda expression.
   * The syntax :
   * {@code IDENTIFIER -> EXPRESSION} or {@code (IDENTIFIER, IDENTIFIER, ...) -> EXPRESSION}.
   */
  private static class SqlLambdaOperator extends SqlSpecialOperator {

    SqlLambdaOperator() {
      super("->", SqlKind.LAMBDA);
    }

    @Override
    public RelDataType deriveType(
        SqlValidator validator, SqlValidatorScope scope, SqlCall call) {
      final SqlLambda lambdaExpr = (SqlLambda) call;
      final SqlLambdaScope lambdaScope = (SqlLambdaScope) scope;

      final List<String> paramNames = new ArrayList<>();
      for (SqlNode parameter : lambdaExpr.getParameters()) {
        paramNames.add(parameter.toString());
      }

      final List<RelDataType> paramTypes = lambdaScope.getParameterTypes().values()
          .stream()
          .collect(Collectors.toList());
      final RelDataType paramRowType =
          validator.getTypeFactory().createStructType(paramTypes, paramNames);
      final RelDataType returnType = validator.getValidatedNodeType(lambdaExpr.getExpression());
      return validator.getTypeFactory().createFunctionSqlType(paramRowType, returnType);
    }
  }
}
