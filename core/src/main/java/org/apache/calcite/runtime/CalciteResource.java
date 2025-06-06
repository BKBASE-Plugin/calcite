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
package org.apache.calcite.runtime;

import java.util.Locale;
import org.apache.calcite.sql.validate.SqlValidatorException;

import static org.apache.calcite.runtime.Resources.BaseMessage;
import static org.apache.calcite.runtime.Resources.ExInst;
import static org.apache.calcite.runtime.Resources.ExInstWithCause;
import static org.apache.calcite.runtime.Resources.Inst;
import static org.apache.calcite.runtime.Resources.Property;

/**
 * Compiler-checked resources for the Calcite project.
 */
public interface CalciteResource {
  @BaseMessage("line {0,number,#}, column {1,number,#}")
  Inst parserContext(int a0, int a1, Locale locale);

  @BaseMessage("Bang equal ''!='' is not allowed under the current SQL conformance level")
  ExInst<CalciteException> bangEqualNotAllowed(Locale locale);

  @BaseMessage("Percent remainder ''%'' is not allowed under the current SQL conformance level")
  ExInst<CalciteException> percentRemainderNotAllowed(Locale locale);

  @BaseMessage("''LIMIT start, count'' is not allowed under the current SQL conformance level")
  ExInst<CalciteException> limitStartCountNotAllowed(Locale locale);

  @BaseMessage("APPLY operator is not allowed under the current SQL conformance level")
  ExInst<CalciteException> applyNotAllowed(Locale locale);

  @BaseMessage("JSON path expression must be specified after the JSON value expression")
  ExInst<CalciteException> jsonPathMustBeSpecified(Locale locale);

  @BaseMessage("Illegal {0} literal {1}: {2}")
  ExInst<CalciteException> illegalLiteral(String a0, String a1, String a2, Locale locale);

  @BaseMessage("Length of identifier ''{0}'' must be less than or equal to {1,number,#} characters")
  ExInst<CalciteException> identifierTooLong(String a0, int a1, Locale locale);

  @BaseMessage("not in format ''{0}''")
  Inst badFormat(String a0, Locale locale);

  @BaseMessage("BETWEEN operator has no terminating AND")
  ExInst<SqlValidatorException> betweenWithoutAnd(Locale locale);

  @BaseMessage("Geo-spatial extensions and the GEOMETRY data type are not enabled")
  ExInst<SqlValidatorException> geometryDisabled(Locale locale);

  @BaseMessage("Illegal INTERVAL literal {0}; at {1}")
  @Property(name = "SQLSTATE", value = "42000")
  ExInst<CalciteException> illegalIntervalLiteral(String a0, String a1, Locale locale);

  @BaseMessage("Illegal expression. Was expecting \"(DATETIME - DATETIME) INTERVALQUALIFIER\"")
  ExInst<CalciteException> illegalMinusDate(Locale locale);

  @BaseMessage("Illegal overlaps expression. Was expecting expression on the form \"(DATETIME, EXPRESSION) OVERLAPS (DATETIME, EXPRESSION)\"")
  ExInst<CalciteException> illegalOverlaps(Locale locale);

  @BaseMessage("Non-query expression encountered in illegal context")
  ExInst<CalciteException> illegalNonQueryExpression(Locale locale);

  @BaseMessage("Query expression encountered in illegal context")
  ExInst<CalciteException> illegalQueryExpression(Locale locale);

  @BaseMessage("CURSOR expression encountered in illegal context")
  ExInst<CalciteException> illegalCursorExpression(Locale locale);

  @BaseMessage("ORDER BY unexpected")
  ExInst<CalciteException> illegalOrderBy(Locale locale);

  @BaseMessage("Illegal binary string {0}")
  ExInst<CalciteException> illegalBinaryString(String a0, Locale locale);

  @BaseMessage("''FROM'' without operands preceding it is illegal")
  ExInst<CalciteException> illegalFromEmpty(Locale locale);

  @BaseMessage("ROW expression encountered in illegal context")
  ExInst<CalciteException> illegalRowExpression(Locale locale);

  @BaseMessage("Illegal identifier '':''. Was expecting ''VALUE''")
  ExInst<CalciteException> illegalColon(Locale locale);

  @BaseMessage("TABLESAMPLE percentage must be between 0 and 100, inclusive")
  @Property(name = "SQLSTATE", value = "2202H")
  ExInst<CalciteException> invalidSampleSize(Locale locale);

  @BaseMessage("Literal ''{0}'' can not be parsed to type ''{1}''")
  ExInst<CalciteException> invalidLiteral(String a0, String a1, Locale locale);

  @BaseMessage("Unknown character set ''{0}''")
  ExInst<CalciteException> unknownCharacterSet(String a0, Locale locale);

  @BaseMessage("Failed to encode ''{0}'' in character set ''{1}''")
  ExInst<CalciteException> charsetEncoding(String a0, String a1, Locale locale);

  @BaseMessage("UESCAPE ''{0}'' must be exactly one character")
  ExInst<CalciteException> unicodeEscapeCharLength(String a0, Locale locale);

  @BaseMessage("UESCAPE ''{0}'' may not be hex digit, whitespace, plus sign, or double quote")
  ExInst<CalciteException> unicodeEscapeCharIllegal(String a0, Locale locale);

  @BaseMessage("UESCAPE cannot be specified without Unicode literal introducer")
  ExInst<CalciteException> unicodeEscapeUnexpected(Locale locale);

  @BaseMessage("Unicode escape sequence starting at character {0,number,#} is not exactly four hex digits")
  ExInst<SqlValidatorException> unicodeEscapeMalformed(int a0, Locale locale);

  @BaseMessage("No match found for function signature {0}")
  ExInst<SqlValidatorException> validatorUnknownFunction(String a0, Locale locale);

  @BaseMessage("Invalid number of arguments to function ''{0}''. Was expecting {1,number,#} arguments")
  ExInst<SqlValidatorException> invalidArgCount(String a0, int a1, Locale locale);

  @BaseMessage("At line {0,number,#}, column {1,number,#}")
  ExInstWithCause<CalciteContextException> validatorContextPoint(int a0,
      int a1, Locale locale);

  @BaseMessage("From line {0,number,#}, column {1,number,#} to line {2,number,#}, column {3,number,#}")
  ExInstWithCause<CalciteContextException> validatorContext(int a0, int a1,
      int a2,
      int a3, Locale locale);

  @BaseMessage("Cast function cannot convert value of type {0} to type {1}")
  ExInst<SqlValidatorException> cannotCastValue(String a0, String a1, Locale locale);

  @BaseMessage("Unknown datatype name ''{0}''")
  ExInst<SqlValidatorException> unknownDatatypeName(String a0, Locale locale);

  @BaseMessage("Values passed to {0} operator must have compatible types")
  ExInst<SqlValidatorException> incompatibleValueType(String a0, Locale locale);

  @BaseMessage("Values in expression list must have compatible types")
  ExInst<SqlValidatorException> incompatibleTypesInList(Locale locale);

  @BaseMessage("Cannot apply {0} to the two different charsets {1} and {2}")
  ExInst<SqlValidatorException> incompatibleCharset(String a0, String a1,
      String a2, Locale locale);

  @BaseMessage("ORDER BY is only allowed on top-level SELECT")
  ExInst<SqlValidatorException> invalidOrderByPos(Locale locale);

  @BaseMessage("Unknown identifier ''{0}''")
  ExInst<SqlValidatorException> unknownIdentifier(String a0, Locale locale);

  @BaseMessage("Unknown field ''{0}''")
  ExInst<SqlValidatorException> unknownField(String a0, Locale locale);

  @BaseMessage("Unknown target column ''{0}''")
  ExInst<SqlValidatorException> unknownTargetColumn(String a0, Locale locale);

  @BaseMessage("Target column ''{0}'' is assigned more than once")
  ExInst<SqlValidatorException> duplicateTargetColumn(String a0, Locale locale);

  @BaseMessage("Number of INSERT target columns ({0,number}) does not equal number of source items ({1,number})")
  ExInst<SqlValidatorException> unmatchInsertColumn(int a0, int a1, Locale locale);

  @BaseMessage("Column ''{0}'' has no default value and does not allow NULLs")
  ExInst<SqlValidatorException> columnNotNullable(String a0, Locale locale);

  @BaseMessage("Cannot assign to target field ''{0}'' of type {1} from source field ''{2}'' of type {3}")
  ExInst<SqlValidatorException> typeNotAssignable(String a0, String a1,
      String a2, String a3, Locale locale);

  @BaseMessage("Table ''{0}'' not found")
  ExInst<SqlValidatorException> tableNameNotFound(String a0, Locale locale);

  @BaseMessage("Table ''{0}'' not found; did you mean ''{1}''?")
  ExInst<SqlValidatorException> tableNameNotFoundDidYouMean(String a0,
      String a1, Locale locale);

  /** Same message as {@link #tableNameNotFound(String, Locale)} but a different kind
   * of exception, so it can be used in {@code RelBuilder}. */
  @BaseMessage("Table ''{0}'' not found")
  ExInst<CalciteException> tableNotFound(String tableName, Locale locale);

  @BaseMessage("Object ''{0}'' not found")
  ExInst<SqlValidatorException> objectNotFound(String a0, Locale locale);

  @BaseMessage("Object ''{0}'' not found within ''{1}''")
  ExInst<SqlValidatorException> objectNotFoundWithin(String a0, String a1, Locale locale);

  @BaseMessage("Object ''{0}'' not found; did you mean ''{1}''?")
  ExInst<SqlValidatorException> objectNotFoundDidYouMean(String a0, String a1, Locale locale);

  @BaseMessage("Object ''{0}'' not found within ''{1}''; did you mean ''{2}''?")
  ExInst<SqlValidatorException> objectNotFoundWithinDidYouMean(String a0,
      String a1, String a2, Locale locale);

  @BaseMessage("Table ''{0}'' is not a sequence")
  ExInst<SqlValidatorException> notASequence(String a0, Locale locale);

  @BaseMessage("Column ''{0}'' not found in any table")
  ExInst<SqlValidatorException> columnNotFound(String a0, Locale locale);

  @BaseMessage("Column ''{0}'' not found in any table; did you mean ''{1}''?")
  ExInst<SqlValidatorException> columnNotFoundDidYouMean(String a0, String a1, Locale locale);

  @BaseMessage("Column ''{0}'' not found in table ''{1}''")
  ExInst<SqlValidatorException> columnNotFoundInTable(String a0, String a1, Locale locale);

  @BaseMessage("Column ''{0}'' not found in table ''{1}''; did you mean ''{2}''?")
  ExInst<SqlValidatorException> columnNotFoundInTableDidYouMean(String a0,
      String a1, String a2, Locale locale);

  @BaseMessage("Column ''{0}'' is ambiguous")
  ExInst<SqlValidatorException> columnAmbiguous(String a0, Locale locale);

  @BaseMessage("Param ''{0}'' not found in lambda expression ''{1}''")
  ExInst<SqlValidatorException> paramNotFoundInLambdaExpression(String a0, String a1, Locale locale);

  @BaseMessage("Operand {0} must be a query")
  ExInst<SqlValidatorException> needQueryOp(String a0, Locale locale);

  @BaseMessage("Parameters must be of the same type")
  ExInst<SqlValidatorException> needSameTypeParameter(Locale locale);

  @BaseMessage("Cannot apply ''{0}'' to arguments of type {1}. Supported form(s): {2}")
  ExInst<SqlValidatorException> canNotApplyOp2Type(String a0, String a1,
      String a2, Locale locale);

  @BaseMessage("Expected a boolean type")
  ExInst<SqlValidatorException> expectedBoolean(Locale locale);

  @BaseMessage("Expected a character type")
  ExInst<SqlValidatorException> expectedCharacter(Locale locale);

  @BaseMessage("ELSE clause or at least one THEN clause must be non-NULL")
  ExInst<SqlValidatorException> mustNotNullInElse(Locale locale);

  @BaseMessage("Function ''{0}'' is not defined")
  ExInst<SqlValidatorException> functionUndefined(String a0, Locale locale);

  @BaseMessage("Encountered {0} with {1,number} parameter(s); was expecting {2}")
  ExInst<SqlValidatorException> wrongNumberOfParam(String a0, int a1,
      String a2, Locale locale);

  @BaseMessage("Illegal mixing of types in CASE or COALESCE statement")
  ExInst<SqlValidatorException> illegalMixingOfTypes(Locale locale);

  @BaseMessage("Invalid compare. Comparing (collation, coercibility): ({0}, {1} with ({2}, {3}) is illegal")
  ExInst<CalciteException> invalidCompare(String a0, String a1, String a2,
      String a3, Locale locale);

  @BaseMessage("Invalid syntax. Two explicit different collations ({0}, {1}) are illegal")
  ExInst<CalciteException> differentCollations(String a0, String a1, Locale locale);

  @BaseMessage("{0} is not comparable to {1}")
  ExInst<SqlValidatorException> typeNotComparable(String a0, String a1, Locale locale);

  @BaseMessage("Cannot compare values of types ''{0}'', ''{1}''")
  ExInst<SqlValidatorException> typeNotComparableNear(String a0, String a1, Locale locale);

  @BaseMessage("Wrong number of arguments to expression")
  ExInst<SqlValidatorException> wrongNumOfArguments(Locale locale);

  @BaseMessage("Operands {0} not comparable to each other")
  ExInst<SqlValidatorException> operandNotComparable(String a0, Locale locale);

  @BaseMessage("Types {0} not comparable to each other")
  ExInst<SqlValidatorException> typeNotComparableEachOther(String a0, Locale locale);

  @BaseMessage("Numeric literal ''{0}'' out of range")
  ExInst<SqlValidatorException> numberLiteralOutOfRange(String a0, Locale locale);

  @BaseMessage("Date literal ''{0}'' out of range")
  ExInst<SqlValidatorException> dateLiteralOutOfRange(String a0, Locale locale);

  @BaseMessage("String literal continued on same line")
  ExInst<SqlValidatorException> stringFragsOnSameLine(Locale locale);

  @BaseMessage("Table or column alias must be a simple identifier")
  ExInst<SqlValidatorException> aliasMustBeSimpleIdentifier(Locale locale);

  @BaseMessage("List of column aliases must have same degree as table; table has {0,number,#} columns {1}, whereas alias list has {2,number,#} columns")
  ExInst<SqlValidatorException> aliasListDegree(int a0, String a1, int a2, Locale locale);

  @BaseMessage("Duplicate name ''{0}'' in column alias list")
  ExInst<SqlValidatorException> aliasListDuplicate(String a0, Locale locale);

  @BaseMessage("INNER, LEFT, RIGHT or FULL join requires a condition (NATURAL keyword or ON or USING clause)")
  ExInst<SqlValidatorException> joinRequiresCondition(Locale locale);

  @BaseMessage("Cannot specify condition (NATURAL keyword, or ON or USING clause) following CROSS JOIN")
  ExInst<SqlValidatorException> crossJoinDisallowsCondition(Locale locale);

  @BaseMessage("Cannot specify NATURAL keyword with ON or USING clause")
  ExInst<SqlValidatorException> naturalDisallowsOnOrUsing(Locale locale);

  @BaseMessage("Column name ''{0}'' in USING clause is not unique on one side of join")
  ExInst<SqlValidatorException> columnInUsingNotUnique(String a0, Locale locale);

  @BaseMessage("Column ''{0}'' matched using NATURAL keyword or USING clause has incompatible types: cannot compare ''{1}'' to ''{2}''")
  ExInst<SqlValidatorException> naturalOrUsingColumnNotCompatible(String a0,
      String a1, String a2, Locale locale);

  @BaseMessage("OVER clause is necessary for window functions")
  ExInst<SqlValidatorException> absentOverClause(Locale locale);

  @BaseMessage("Window ''{0}'' not found")
  ExInst<SqlValidatorException> windowNotFound(String a0, Locale locale);

  @BaseMessage("Cannot specify IGNORE NULLS or RESPECT NULLS following ''{0}''")
  ExInst<SqlValidatorException> disallowsNullTreatment(String a0, Locale locale);

  @BaseMessage("Expression ''{0}'' is not being grouped")
  ExInst<SqlValidatorException> notGroupExpr(String a0, Locale locale);

  @BaseMessage("Argument to {0} operator must be a grouped expression")
  ExInst<SqlValidatorException> groupingArgument(String a0, Locale locale);

  @BaseMessage("{0} operator may only occur in an aggregate query")
  ExInst<SqlValidatorException> groupingInAggregate(String a0, Locale locale);

  @BaseMessage("{0} operator may only occur in SELECT, HAVING or ORDER BY clause")
  ExInst<SqlValidatorException> groupingInWrongClause(String a0, Locale locale);

  @BaseMessage("Expression ''{0}'' is not in the select clause")
  ExInst<SqlValidatorException> notSelectDistinctExpr(String a0, Locale locale);

  @BaseMessage("Aggregate expression is illegal in {0} clause")
  ExInst<SqlValidatorException> aggregateIllegalInClause(String a0, Locale locale);

  @BaseMessage("Windowed aggregate expression is illegal in {0} clause")
  ExInst<SqlValidatorException> windowedAggregateIllegalInClause(String a0, Locale locale);

  @BaseMessage("Aggregate expressions cannot be nested")
  ExInst<SqlValidatorException> nestedAggIllegal(Locale locale);

  @BaseMessage("FILTER must not contain aggregate expression")
  ExInst<SqlValidatorException> aggregateInFilterIllegal(Locale locale);

  @BaseMessage("WITHIN GROUP must not contain aggregate expression")
  ExInst<SqlValidatorException> aggregateInWithinGroupIllegal(Locale locale);

  @BaseMessage("Aggregate expression ''{0}'' must contain a within group clause")
  ExInst<SqlValidatorException> aggregateMissingWithinGroupClause(String a0, Locale locale);

  @BaseMessage("Aggregate expression ''{0}'' must not contain a within group clause")
  ExInst<SqlValidatorException> withinGroupClauseIllegalInAggregate(String a0, Locale locale);

  @BaseMessage("Aggregate expression is illegal in ORDER BY clause of non-aggregating SELECT")
  ExInst<SqlValidatorException> aggregateIllegalInOrderBy(Locale locale);

  @BaseMessage("{0} clause must be a condition")
  ExInst<SqlValidatorException> condMustBeBoolean(String a0, Locale locale);

  @BaseMessage("HAVING clause must be a condition")
  ExInst<SqlValidatorException> havingMustBeBoolean(Locale locale);

  @BaseMessage("OVER must be applied to aggregate function")
  ExInst<SqlValidatorException> overNonAggregate(Locale locale);

  @BaseMessage("FILTER must be applied to aggregate function")
  ExInst<SqlValidatorException> filterNonAggregate(Locale locale);

  @BaseMessage("Cannot override window attribute")
  ExInst<SqlValidatorException> cannotOverrideWindowAttribute(Locale locale);

  @BaseMessage("Column count mismatch in {0}")
  ExInst<SqlValidatorException> columnCountMismatchInSetop(String a0, Locale locale);

  @BaseMessage("Type mismatch in column {0,number} of {1}")
  ExInst<SqlValidatorException> columnTypeMismatchInSetop(int a0, String a1, Locale locale);

  @BaseMessage("Binary literal string must contain an even number of hexits")
  ExInst<SqlValidatorException> binaryLiteralOdd(Locale locale);

  @BaseMessage("Binary literal string must contain only characters ''0'' - ''9'', ''A'' - ''F''")
  ExInst<SqlValidatorException> binaryLiteralInvalid(Locale locale);

  @BaseMessage("Illegal interval literal format {0} for {1}")
  ExInst<SqlValidatorException> unsupportedIntervalLiteral(String a0,
      String a1, Locale locale);

  @BaseMessage("Interval field value {0,number} exceeds precision of {1} field")
  ExInst<SqlValidatorException> intervalFieldExceedsPrecision(Number a0,
      String a1, Locale locale);

  @BaseMessage("RANGE clause cannot be used with compound ORDER BY clause")
  ExInst<SqlValidatorException> compoundOrderByProhibitsRange(Locale locale);

  @BaseMessage("Data type of ORDER BY prohibits use of RANGE clause")
  ExInst<SqlValidatorException> orderByDataTypeProhibitsRange(Locale locale);

  @BaseMessage("Data Type mismatch between ORDER BY and RANGE clause")
  ExInst<SqlValidatorException> orderByRangeMismatch(Locale locale);

  @BaseMessage("Window ORDER BY expression of type DATE requires range of type INTERVAL")
  ExInst<SqlValidatorException> dateRequiresInterval(Locale locale);

  @BaseMessage("ROWS value must be a non-negative integral constant")
  ExInst<SqlValidatorException> rowMustBeNonNegativeIntegral(Locale locale);

  @BaseMessage("Window specification must contain an ORDER BY clause")
  ExInst<SqlValidatorException> overMissingOrderBy(Locale locale);

  @BaseMessage("PARTITION BY expression should not contain OVER clause")
  ExInst<SqlValidatorException> partitionbyShouldNotContainOver(Locale locale);

  @BaseMessage("ORDER BY expression should not contain OVER clause")
  ExInst<SqlValidatorException> orderbyShouldNotContainOver(Locale locale);

  @BaseMessage("UNBOUNDED FOLLOWING cannot be specified for the lower frame boundary")
  ExInst<SqlValidatorException> badLowerBoundary(Locale locale);

  @BaseMessage("UNBOUNDED PRECEDING cannot be specified for the upper frame boundary")
  ExInst<SqlValidatorException> badUpperBoundary(Locale locale);

  @BaseMessage("Upper frame boundary cannot be PRECEDING when lower boundary is CURRENT ROW")
  ExInst<SqlValidatorException> currentRowPrecedingError(Locale locale);

  @BaseMessage("Upper frame boundary cannot be CURRENT ROW when lower boundary is FOLLOWING")
  ExInst<SqlValidatorException> currentRowFollowingError(Locale locale);

  @BaseMessage("Upper frame boundary cannot be PRECEDING when lower boundary is FOLLOWING")
  ExInst<SqlValidatorException> followingBeforePrecedingError(Locale locale);

  @BaseMessage("Window name must be a simple identifier")
  ExInst<SqlValidatorException> windowNameMustBeSimple(Locale locale);

  @BaseMessage("Duplicate window names not allowed")
  ExInst<SqlValidatorException> duplicateWindowName(Locale locale);

  @BaseMessage("Empty window specification not allowed")
  ExInst<SqlValidatorException> emptyWindowSpec(Locale locale);

  @BaseMessage("Duplicate window specification not allowed in the same window clause")
  ExInst<SqlValidatorException> dupWindowSpec(Locale locale);

  @BaseMessage("ROW/RANGE not allowed with RANK, DENSE_RANK or ROW_NUMBER functions")
  ExInst<SqlValidatorException> rankWithFrame(Locale locale);

  @BaseMessage("RANK or DENSE_RANK functions require ORDER BY clause in window specification")
  ExInst<SqlValidatorException> funcNeedsOrderBy(Locale locale);

  @BaseMessage("PARTITION BY not allowed with existing window reference")
  ExInst<SqlValidatorException> partitionNotAllowed(Locale locale);

  @BaseMessage("ORDER BY not allowed in both base and referenced windows")
  ExInst<SqlValidatorException> orderByOverlap(Locale locale);

  @BaseMessage("Referenced window cannot have framing declarations")
  ExInst<SqlValidatorException> refWindowWithFrame(Locale locale);

  @BaseMessage("Type ''{0}'' is not supported")
  ExInst<SqlValidatorException> typeNotSupported(String a0, Locale locale);

  @BaseMessage("DISTINCT/ALL not allowed with {0} function")
  ExInst<SqlValidatorException> functionQuantifierNotAllowed(String a0, Locale locale);

  @BaseMessage("WITHIN GROUP not allowed with {0} function")
  ExInst<SqlValidatorException> withinGroupNotAllowed(String a0, Locale locale);

  @BaseMessage("Some but not all arguments are named")
  ExInst<SqlValidatorException> someButNotAllArgumentsAreNamed(Locale locale);

  @BaseMessage("Duplicate argument name ''{0}''")
  ExInst<SqlValidatorException> duplicateArgumentName(String name, Locale locale);

  @BaseMessage("DEFAULT is only allowed for optional parameters")
  ExInst<SqlValidatorException> defaultForOptionalParameter(Locale locale);

  @BaseMessage("DEFAULT not allowed here")
  ExInst<SqlValidatorException> defaultNotAllowed(Locale locale);

  @BaseMessage("Not allowed to perform {0} on {1}")
  ExInst<SqlValidatorException> accessNotAllowed(String a0, String a1, Locale locale);

  @BaseMessage("The {0} function does not support the {1} data type.")
  ExInst<SqlValidatorException> minMaxBadType(String a0, String a1, Locale locale);

  @BaseMessage("Only scalar sub-queries allowed in select list.")
  ExInst<SqlValidatorException> onlyScalarSubQueryAllowed(Locale locale);

  @BaseMessage("Ordinal out of range")
  ExInst<SqlValidatorException> orderByOrdinalOutOfRange(Locale locale);

  @BaseMessage("Window has negative size")
  ExInst<SqlValidatorException> windowHasNegativeSize(Locale locale);

  @BaseMessage("UNBOUNDED FOLLOWING window not supported")
  ExInst<SqlValidatorException> unboundedFollowingWindowNotSupported(Locale locale);

  @BaseMessage("Cannot use DISALLOW PARTIAL with window based on RANGE")
  ExInst<SqlValidatorException> cannotUseDisallowPartialWithRange(Locale locale);

  @BaseMessage("Interval leading field precision ''{0,number,#}'' out of range for {1}")
  ExInst<SqlValidatorException> intervalStartPrecisionOutOfRange(int a0,
      String a1, Locale locale);

  @BaseMessage("Interval fractional second precision ''{0,number,#}'' out of range for {1}")
  ExInst<SqlValidatorException> intervalFractionalSecondPrecisionOutOfRange(
      int a0, String a1, Locale locale);

  @BaseMessage("Duplicate relation name ''{0}'' in FROM clause")
  ExInst<SqlValidatorException> fromAliasDuplicate(String a0, Locale locale);

  @BaseMessage("Duplicate column name ''{0}'' in output")
  ExInst<SqlValidatorException> duplicateColumnName(String a0, Locale locale);

  @BaseMessage("Duplicate name ''{0}'' in column list")
  ExInst<SqlValidatorException> duplicateNameInColumnList(String a0, Locale locale);

  @BaseMessage("Internal error: {0}")
  ExInst<CalciteException> internal(String a0, Locale locale);

  @BaseMessage("Argument to function ''{0}'' must be a literal")
  ExInst<SqlValidatorException> argumentMustBeLiteral(String a0, Locale locale);

  @BaseMessage("Argument to function ''{0}'' must be a positive integer literal")
  ExInst<SqlValidatorException> argumentMustBePositiveInteger(String a0, Locale locale);

  @BaseMessage("Validation Error: {0}")
  ExInst<CalciteException> validationError(String a0, Locale locale);

  @BaseMessage("Locale ''{0}'' in an illegal format")
  ExInst<CalciteException> illegalLocaleFormat(String a0, Locale locale);

  @BaseMessage("Argument to function ''{0}'' must not be NULL")
  ExInst<SqlValidatorException> argumentMustNotBeNull(String a0, Locale locale);

  @BaseMessage("Illegal use of ''NULL''")
  ExInst<SqlValidatorException> nullIllegal(Locale locale);

  @BaseMessage("Illegal use of dynamic parameter")
  ExInst<SqlValidatorException> dynamicParamIllegal(Locale locale);

  @BaseMessage("''{0}'' is not a valid boolean value")
  ExInst<CalciteException> invalidBoolean(String a0, Locale locale);

  @BaseMessage("Argument to function ''{0}'' must be a valid precision between ''{1,number,#}'' and ''{2,number,#}''")
  ExInst<SqlValidatorException> argumentMustBeValidPrecision(String a0, int a1,
      int a2, Locale locale);

  @BaseMessage("Wrong arguments for table function ''{0}'' call. Expected ''{1}'', actual ''{2}''")
  ExInst<CalciteException> illegalArgumentForTableFunctionCall(String a0,
      String a1, String a2, Locale locale);

  @BaseMessage("''{0}'' is not a valid datetime format")
  ExInst<CalciteException> invalidDatetimeFormat(String a0, Locale locale);

  @BaseMessage("Cannot INSERT into generated column ''{0}''")
  ExInst<SqlValidatorException> insertIntoAlwaysGenerated(String a0, Locale locale);

  @BaseMessage("Argument to function ''{0}'' must have a scale of 0")
  ExInst<CalciteException> argumentMustHaveScaleZero(String a0, Locale locale);

  @BaseMessage("Statement preparation aborted")
  ExInst<CalciteException> preparationAborted(Locale locale);

  @BaseMessage("SELECT DISTINCT not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_E051_01(Locale locale);

  @BaseMessage("EXCEPT not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_E071_03(Locale locale);

  @BaseMessage("UPDATE not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_E101_03(Locale locale);

  @BaseMessage("Transactions not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_E151(Locale locale);

  @BaseMessage("INTERSECT not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_F302(Locale locale);

  @BaseMessage("MERGE not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_F312(Locale locale);

  @BaseMessage("Basic multiset not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_S271(Locale locale);

  @BaseMessage("TABLESAMPLE not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_T613(Locale locale);

  @BaseMessage("Execution of a new autocommit statement while a cursor is still open on same connection is not supported")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  ExInst<CalciteException> sQLConformance_MultipleActiveAutocommitStatements(Locale locale);

  @BaseMessage("Descending sort (ORDER BY DESC) not supported")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  Feature sQLConformance_OrderByDesc(Locale locale);

  @BaseMessage("Sharing of cached statement plans not supported")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  ExInst<CalciteException> sharedStatementPlans(Locale locale);

  @BaseMessage("TABLESAMPLE SUBSTITUTE not supported")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  Feature sQLFeatureExt_T613_Substitution(Locale locale);

  @BaseMessage("Personality does not maintain table''s row count in the catalog")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  ExInst<CalciteException> personalityManagesRowCount(Locale locale);

  @BaseMessage("Personality does not support snapshot reads")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  ExInst<CalciteException> personalitySupportsSnapshots(Locale locale);

  @BaseMessage("Personality does not support labels")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  ExInst<CalciteException> personalitySupportsLabels(Locale locale);

  @BaseMessage("Require at least 1 argument")
  ExInst<SqlValidatorException> requireAtLeastOneArg(Locale locale);

  @BaseMessage("Map requires at least 2 arguments")
  ExInst<SqlValidatorException> mapRequiresTwoOrMoreArgs(Locale locale);

  @BaseMessage("Map requires an even number of arguments")
  ExInst<SqlValidatorException> mapRequiresEvenArgCount(Locale locale);

  @BaseMessage("Incompatible types")
  ExInst<SqlValidatorException> incompatibleTypes(Locale locale);

  @BaseMessage("Number of columns must match number of query columns")
  ExInst<SqlValidatorException> columnCountMismatch(Locale locale);

  @BaseMessage("Column has duplicate column name ''{0}'' and no column list specified")
  ExInst<SqlValidatorException> duplicateColumnAndNoColumnList(String s, Locale locale);

  @BaseMessage("Declaring class ''{0}'' of non-static user-defined function must have a public constructor with zero parameters")
  ExInst<RuntimeException> requireDefaultConstructor(String className, Locale locale);

  @BaseMessage("In user-defined aggregate class ''{0}'', first parameter to ''add'' method must be the accumulator (the return type of the ''init'' method)")
  ExInst<RuntimeException> firstParameterOfAdd(String className, Locale locale);

  @BaseMessage("FilterableTable.scan returned a filter that was not in the original list: {0}")
  ExInst<CalciteException> filterableTableInventedFilter(String s, Locale locale);

  @BaseMessage("FilterableTable.scan must not return null")
  ExInst<CalciteException> filterableTableScanReturnedNull(Locale locale);

  @BaseMessage("Cannot convert table ''{0}'' to stream")
  ExInst<SqlValidatorException> cannotConvertToStream(String tableName, Locale locale);

  @BaseMessage("Cannot convert stream ''{0}'' to relation")
  ExInst<SqlValidatorException> cannotConvertToRelation(String tableName, Locale locale);

  @BaseMessage("Streaming aggregation requires at least one monotonic expression in GROUP BY clause")
  ExInst<SqlValidatorException> streamMustGroupByMonotonic(Locale locale);

  @BaseMessage("Streaming ORDER BY must start with monotonic expression")
  ExInst<SqlValidatorException> streamMustOrderByMonotonic(Locale locale);

  @BaseMessage("Set operator cannot combine streaming and non-streaming inputs")
  ExInst<SqlValidatorException> streamSetOpInconsistentInputs(Locale locale);

  @BaseMessage("Cannot stream VALUES")
  ExInst<SqlValidatorException> cannotStreamValues(Locale locale);

  @BaseMessage("Cannot resolve ''{0}''; it references view ''{1}'', whose definition is cyclic")
  ExInst<SqlValidatorException> cyclicDefinition(String id, String view, Locale locale);

  @BaseMessage("Modifiable view must be based on a single table")
  ExInst<SqlValidatorException> modifiableViewMustBeBasedOnSingleTable(Locale locale);

  @BaseMessage("Modifiable view must be predicated only on equality expressions")
  ExInst<SqlValidatorException> modifiableViewMustHaveOnlyEqualityPredicates(Locale locale);

  @BaseMessage("View is not modifiable. More than one expression maps to column ''{0}'' of base table ''{1}''")
  ExInst<SqlValidatorException> moreThanOneMappedColumn(String columnName, String tableName, Locale locale);

  @BaseMessage("View is not modifiable. No value is supplied for NOT NULL column ''{0}'' of base table ''{1}''")
  ExInst<SqlValidatorException> noValueSuppliedForViewColumn(String columnName, String tableName, Locale locale);

  @BaseMessage("Modifiable view constraint is not satisfied for column ''{0}'' of base table ''{1}''")
  ExInst<SqlValidatorException> viewConstraintNotSatisfied(String columnName, String tableName, Locale locale);

  @BaseMessage("Not a record type. The ''*'' operator requires a record")
  ExInst<SqlValidatorException> starRequiresRecordType(Locale locale);

  @BaseMessage("FILTER expression must be of type BOOLEAN")
  ExInst<CalciteException> filterMustBeBoolean(Locale locale);

  @BaseMessage("Cannot stream results of a query with no streaming inputs: ''{0}''. At least one input should be convertible to a stream")
  ExInst<SqlValidatorException> cannotStreamResultsForNonStreamingInputs(String inputs, Locale locale);

  @BaseMessage("MINUS is not allowed under the current SQL conformance level")
  ExInst<CalciteException> minusNotAllowed(Locale locale);

  @BaseMessage("SELECT must have a FROM clause")
  ExInst<SqlValidatorException> selectMissingFrom(Locale locale);

  @BaseMessage("Group function ''{0}'' can only appear in GROUP BY clause")
  ExInst<SqlValidatorException> groupFunctionMustAppearInGroupByClause(String funcName, Locale locale);

  @BaseMessage("Call to auxiliary group function ''{0}'' must have matching call to group function ''{1}'' in GROUP BY clause")
  ExInst<SqlValidatorException> auxiliaryWithoutMatchingGroupCall(String func1, String func2, Locale locale);

  @BaseMessage("Pattern variable ''{0}'' has already been defined")
  ExInst<SqlValidatorException> patternVarAlreadyDefined(String varName, Locale locale);

  @BaseMessage("Cannot use PREV/NEXT in MEASURE ''{0}''")
  ExInst<SqlValidatorException> patternPrevFunctionInMeasure(String call, Locale locale);

  @BaseMessage("Cannot nest PREV/NEXT under LAST/FIRST ''{0}''")
  ExInst<SqlValidatorException> patternPrevFunctionOrder(String call, Locale locale);

  @BaseMessage("Cannot use aggregation in navigation ''{0}''")
  ExInst<SqlValidatorException> patternAggregationInNavigation(String call, Locale locale);

  @BaseMessage("Invalid number of parameters to COUNT method")
  ExInst<SqlValidatorException> patternCountFunctionArg(Locale locale);

  @BaseMessage("The system time period specification expects Timestamp type but is ''{0}''")
  ExInst<SqlValidatorException> illegalExpressionForTemporal(String type, Locale locale);

  @BaseMessage("Table ''{0}'' is not a temporal table, can not be queried in system time period specification")
  ExInst<SqlValidatorException> notTemporalTable(String tableName, Locale locale);

  @BaseMessage("Cannot use RUNNING/FINAL in DEFINE ''{0}''")
  ExInst<SqlValidatorException> patternRunningFunctionInDefine(String call, Locale locale);

  @BaseMessage("Multiple pattern variables in ''{0}''")
  ExInst<SqlValidatorException> patternFunctionVariableCheck(String call, Locale locale);

  @BaseMessage("Function ''{0}'' can only be used in MATCH_RECOGNIZE")
  ExInst<SqlValidatorException> functionMatchRecognizeOnly(String call, Locale locale);

  @BaseMessage("Null parameters in ''{0}''")
  ExInst<SqlValidatorException> patternFunctionNullCheck(String call, Locale locale);

  @BaseMessage("Unknown pattern ''{0}''")
  ExInst<SqlValidatorException> unknownPattern(String call, Locale locale);

  @BaseMessage("Interval must be non-negative ''{0}''")
  ExInst<SqlValidatorException> intervalMustBeNonNegative(String call, Locale locale);

  @BaseMessage("Must contain an ORDER BY clause when WITHIN is used")
  ExInst<SqlValidatorException> cannotUseWithinWithoutOrderBy(Locale locale);

  @BaseMessage("First column of ORDER BY must be of type TIMESTAMP")
  ExInst<SqlValidatorException> firstColumnOfOrderByMustBeTimestamp(Locale locale);

  @BaseMessage("Extended columns not allowed under the current SQL conformance level")
  ExInst<SqlValidatorException> extendNotAllowed(Locale locale);

  @BaseMessage("Rolled up column ''{0}'' is not allowed in {1}")
  ExInst<SqlValidatorException> rolledUpNotAllowed(String column, String context);

  @BaseMessage("Schema ''{0}'' already exists")
  ExInst<SqlValidatorException> schemaExists(String name, Locale locale);

  @BaseMessage("Invalid schema type ''{0}''; valid values: {1}")
  ExInst<SqlValidatorException> schemaInvalidType(String type, String values);

  @BaseMessage("Table ''{0}'' already exists")
  ExInst<SqlValidatorException> tableExists(String name, Locale locale);

  // If CREATE TABLE does not have "AS query", there must be a column list
  @BaseMessage("Missing column list")
  ExInst<SqlValidatorException> createTableRequiresColumnList(Locale locale);

  // If CREATE TABLE does not have "AS query", a type must be specified for each
  // column
  @BaseMessage("Type required for column ''{0}'' in CREATE TABLE without AS")
  ExInst<SqlValidatorException> createTableRequiresColumnTypes(String columnName, Locale locale);

  @BaseMessage("View ''{0}'' already exists and REPLACE not specified")
  ExInst<SqlValidatorException> viewExists(String name, Locale locale);

  @BaseMessage("Schema ''{0}'' not found")
  ExInst<SqlValidatorException> schemaNotFound(String name, Locale locale);

  @BaseMessage("View ''{0}'' not found")
  ExInst<SqlValidatorException> viewNotFound(String name, Locale locale);

  @BaseMessage("Type ''{0}'' not found")
  ExInst<SqlValidatorException> typeNotFound(String name, Locale locale);

  @BaseMessage("Dialect does not support feature: ''{0}''")
  ExInst<SqlValidatorException> dialectDoesNotSupportFeature(String featureName, Locale locale);

  @BaseMessage("Substring error: negative substring length not allowed")
  ExInst<CalciteException> illegalNegativeSubstringLength(Locale locale);

  @BaseMessage("Trim error: trim character must be exactly 1 character")
  ExInst<CalciteException> trimError(Locale locale);

  @BaseMessage("Invalid types for arithmetic: {0} {1} {2}")
  ExInst<CalciteException> invalidTypesForArithmetic(String clazzName0, String op,
      String clazzName1, Locale locale);

  @BaseMessage("Invalid types for comparison: {0} {1} {2}")
  ExInst<CalciteException> invalidTypesForComparison(String clazzName0, String op,
      String clazzName1, Locale locale);

  @BaseMessage("Cannot convert {0} to {1}")
  ExInst<CalciteException> cannotConvert(String o, String toType, Locale locale);

  @BaseMessage("Invalid character for cast: {0}")
  ExInst<CalciteException> invalidCharacterForCast(String s, Locale locale);

  @BaseMessage("More than one value in list: {0}")
  ExInst<CalciteException> moreThanOneValueInList(String list, Locale locale);

  @BaseMessage("Failed to access field ''{0}'' of object of type {1}")
  ExInstWithCause<CalciteException> failedToAccessField(String fieldName, String typeName, Locale locale);

  @BaseMessage("Illegal jsonpath spec ''{0}'', format of the spec should be: ''<lax|strict> $'{'expr'}'''")
  ExInst<CalciteException> illegalJsonPathSpec(String pathSpec, Locale locale);

  @BaseMessage("Illegal jsonpath mode ''{0}''")
  ExInst<CalciteException> illegalJsonPathMode(String pathMode, Locale locale);

  @BaseMessage("Illegal jsonpath mode ''{0}'' in jsonpath spec: ''{1}''")
  ExInst<CalciteException> illegalJsonPathModeInPathSpec(String pathMode, String pathSpec, Locale locale);

  @BaseMessage("Strict jsonpath mode requires a non empty returned value, but is null")
  ExInst<CalciteException> strictPathModeRequiresNonEmptyValue(Locale locale);

  @BaseMessage("Illegal error behavior ''{0}'' specified in JSON_EXISTS function")
  ExInst<CalciteException> illegalErrorBehaviorInJsonExistsFunc(String errorBehavior, Locale locale);

  @BaseMessage("Empty result of JSON_VALUE function is not allowed")
  ExInst<CalciteException> emptyResultOfJsonValueFuncNotAllowed(Locale locale);

  @BaseMessage("Illegal empty behavior ''{0}'' specified in JSON_VALUE function")
  ExInst<CalciteException> illegalEmptyBehaviorInJsonValueFunc(String emptyBehavior, Locale locale);

  @BaseMessage("Illegal error behavior ''{0}'' specified in JSON_VALUE function")
  ExInst<CalciteException> illegalErrorBehaviorInJsonValueFunc(String errorBehavior, Locale locale);

  @BaseMessage("Strict jsonpath mode requires scalar value, and the actual value is: ''{0}''")
  ExInst<CalciteException> scalarValueRequiredInStrictModeOfJsonValueFunc(String value, Locale locale);

  @BaseMessage("Illegal wrapper behavior ''{0}'' specified in JSON_QUERY function")
  ExInst<CalciteException> illegalWrapperBehaviorInJsonQueryFunc(String wrapperBehavior, Locale locale);

  @BaseMessage("Empty result of JSON_QUERY function is not allowed")
  ExInst<CalciteException> emptyResultOfJsonQueryFuncNotAllowed(Locale locale);

  @BaseMessage("Illegal empty behavior ''{0}'' specified in JSON_VALUE function")
  ExInst<CalciteException> illegalEmptyBehaviorInJsonQueryFunc(String emptyBehavior, Locale locale);

  @BaseMessage("Strict jsonpath mode requires array or object value, and the actual value is: ''{0}''")
  ExInst<CalciteException> arrayOrObjectValueRequiredInStrictModeOfJsonQueryFunc(String value, Locale locale);

  @BaseMessage("Illegal error behavior ''{0}'' specified in JSON_VALUE function")
  ExInst<CalciteException> illegalErrorBehaviorInJsonQueryFunc(String errorBehavior, Locale locale);

  @BaseMessage("Null key of JSON object is not allowed")
  ExInst<CalciteException> nullKeyOfJsonObjectNotAllowed(Locale locale);

  @BaseMessage("Timeout of ''{0}'' ms for query execution is reached. Query execution started at ''{1}''")
  ExInst<CalciteException> queryExecutionTimeoutReached(String timeout, String queryStart, Locale locale);

  @BaseMessage("Including both WITHIN GROUP(...) and inside ORDER BY in a single JSON_ARRAYAGG call is not allowed")
  ExInst<CalciteException> ambiguousSortOrderInJsonArrayAggFunc(Locale locale);

  @BaseMessage("While executing SQL [{0}] on JDBC sub-schema")
  ExInst<RuntimeException> exceptionWhilePerformingQueryOnJdbcSubSchema(String sql, Locale locale);

  @BaseMessage("Not a valid input for JSON_TYPE: ''{0}''")
  ExInst<CalciteException> invalidInputForJsonType(String value, Locale locale);

  @BaseMessage("Not a valid input for JSON_DEPTH: ''{0}''")
  ExInst<CalciteException> invalidInputForJsonDepth(String value, Locale locale);

  @BaseMessage("Cannot serialize object to JSON: ''{0}''")
  ExInst<CalciteException> exceptionWhileSerializingToJson(String value, Locale locale);

  @BaseMessage("Not a valid input for JSON_LENGTH: ''{0}''")
  ExInst<CalciteException> invalidInputForJsonLength(String value, Locale locale);

  @BaseMessage("Not a valid input for JSON_KEYS: ''{0}''")
  ExInst<CalciteException> invalidInputForJsonKeys(String value, Locale locale);

  @BaseMessage("Invalid input for JSON_REMOVE: document: ''{0}'', jsonpath expressions: ''{1}''")
  ExInst<CalciteException> invalidInputForJsonRemove(String value, String pathSpecs, Locale locale);

  @BaseMessage("Not a valid input for JSON_STORAGE_SIZE: ''{0}''")
  ExInst<CalciteException> invalidInputForJsonStorageSize(String value, Locale locale);

  @BaseMessage("Not a valid input for REGEXP_REPLACE: ''{0}''")
  ExInst<CalciteException> invalidInputForRegexpReplace(String value, Locale locale);
}

// End CalciteResource.java
