package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a SELECT query.  The methods use Fluent API: they returned the modified object so that
 * you can chain expression as follows:
 * <pre>
 *     SelectQuery query = new SelectQuery(table);
 *     query.setColumns(columns).setOrderBy(orderBy).setGroupBy(groupBy) ....
 * </pre>
 */
public class SelectQuery extends WhereQuery {

    /**
     * Constant used to build a query.
     */
    public static final String SELECT = "SELECT ";

    /**
     * Constant used to build a query.
     */
    public static final String DISTINCT = "DISTINCT ";

    /**
     * Constant used to build a query.
     */
    public static final String FROM = " FROM ";

    /**
     * Constant used to build a query.
     */
    public static final String LIMIT = " LIMIT ";

    /**
     * Constant used to build a query.
     */
    public static final String OFFSET = " OFFSET ";

    /**
     * Constant used to build a query.
     */
    public static final String ORDER_BY = " ORDER BY ";

    /**
     * Constant used to build a query.
     */
    public static final String AS = " AS ";

    /**
     * List od columns retrieved by the query.
     */
    private List<AExp> columnExpressions;

    /**
     * List of table references this query uses
     */
    private List<TableReference> tableReferences;

    /**
     * ORDER BY clause
     */
    private List<OrderBy> orderBy;

    /**
     * LIMIT clause
     */
    private Limit limit;

    /**
     * OFFSET clause
     */
    private Offset offset;

    /**
     * DISTINCT claue
     */
    private boolean distinct = false;

    //constructors

    /**
     * Creates a SELECT query retrieving rows the specified columns (expressions) from the specified table reference.
     *
     * @param tableReference table reference
     * @param columns        list of columns (expressions) to select
     */
    public SelectQuery(TableReference tableReference, List<? extends AExp> columns) {
        this.tableReferences = new ArrayList<TableReference>();
        this.tableReferences.add(tableReference);
        this.columnExpressions = new ArrayList<AExp>(columns);
    }

    /**
     * Creates a SELECT query retrieving rows from the specified table reference. The resulting query
     * selects all columns of the reference.
     *
     * @param tableReference table reference
     */
    public SelectQuery(TableReference tableReference) {
        this(tableReference, new ArrayList<AExp>(tableReference.getColumns()));
    }

    /**
     * Creates a SELECT query retrieving the specified column (expression) from the specified table reference.
     *
     * @param tableReference table reference
     * @param aexp           expression
     */
    public SelectQuery(TableReference tableReference, AExp aexp) {
        this.tableReferences = new ArrayList<TableReference>();
        this.tableReferences.add(tableReference);
        this.columnExpressions = new ArrayList<AExp>();
        this.columnExpressions.add(aexp);
    }


    /**
     * Creates a SELECT query retrieving all columns from the specified table references.
     *
     * @param tableReferences list of table references
     */
    public SelectQuery(List<? extends TableReference> tableReferences) {
        this.tableReferences = new ArrayList<TableReference>(tableReferences);
        this.columnExpressions = new ArrayList<AExp>();

        for (Iterator<TableReference> i = this.tableReferences.iterator(); i.hasNext();) {
            TableReference tableReference = i.next();
            this.columnExpressions.addAll(tableReference.getColumns());
        }
    }

    /**
     * Creates a SELECT query retrieving the specified columns (expressions) from the specified table references.
     *
     * @param tableReferences list of table references
     * @param columns         list of columns (expressions)
     */
    public SelectQuery(List<? extends TableReference> tableReferences, List<? extends AExp> columns) {
        this.tableReferences = new ArrayList<TableReference>(tableReferences);
        this.columnExpressions = new ArrayList<AExp>(columns);
    }

    /**
     * Creates a SELECT query retrieving the specified column (expression) from the specified table references.
     *
     * @param tableReferences list of table references
     */
    public SelectQuery(List<? extends TableReference> tableReferences, AExp exp) {
        this.tableReferences = new ArrayList<TableReference>(tableReferences);
        this.columnExpressions = new ArrayList<AExp>();
        this.columnExpressions.add(exp);
    }

    /**
     * Full constructor.
     *
     * @param tableReferences   list of table references (FROM clause)
     * @param columnExpressions list of columns (SELECT clause)
     * @param where             WHERE condition
     */
    public SelectQuery(List<? extends TableReference> tableReferences,
                       List<? extends AExp> columnExpressions,
                       LExp where, List<OrderBy> orderBy) {
        this.columnExpressions = new ArrayList<AExp>(columnExpressions);
        this.tableReferences = new ArrayList<TableReference>(tableReferences);
        this.where = where;
        this.orderBy = orderBy;
    }

    /**
     * Returns the list of columns (expressions) the query retrieves.
     *
     * @return list of columns (expressions) the query retrieves.
     */
    public List<AExp> getColumnExpressions() {
        return this.columnExpressions;
    }

    /**
     * Sets the list of columns (expressions) the query retrieves.
     *
     * @param columnExpressions list of columns (expressions) the query retrieves.
     * @return modified query
     */
    public SelectQuery setColumnExpressions(List<? extends AExp> columnExpressions) {
        this.columnExpressions = new ArrayList<AExp>(columnExpressions);
        return this;
    }

    /**
     * Sets column (expression) the query retrieves.
     *
     * @param columnExpression expression to retrieve
     */
    public SelectQuery setColumnExpression(AExp columnExpression) {
        List<AExp> columnExpressions = new ArrayList<>();
        columnExpressions.add(columnExpression);
        this.columnExpressions = columnExpressions;
        return this;
    }

    /**
     * Sets ORDER BY clause of this query.
     *
     * @param orderBy list of expression to sort by
     */
    public SelectQuery orderBy(List<OrderBy> orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    /**
     * Sets ORDER BY clause of this query.
     *
     * @param orderBy expression to sort by
     */
    public SelectQuery orderBy(OrderBy orderBy) {
        List<OrderBy> orderByItems = new LinkedList<OrderBy>();
        orderByItems.add(orderBy);
        orderBy(orderByItems);
        return this;
    }

    /**
     * Sets ORDER BY clause of this query.
     *
     * @param orderBy expression to sort by
     * @param direction direction of ordering
     */
    public SelectQuery orderBy(AExp orderBy, OrderByDirection direction) {
        orderBy(new OrderBy(orderBy, direction));
        return this;
    }

    /**
     * Sets ORDER BY clause of this query in ascending order.
     *
     * @param orderBy expression to sort by
     */
    public SelectQuery orderBy(AExp orderBy) {
        orderBy(orderBy, OrderByDirection.ASC);
        return this;
    }

    /**
     * Sets LIMIT clause of this query.
     *
     * @param limit LIMIT clause
     */
    public SelectQuery limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Sets LIMIT clause of this query.
     *
     * @param limit number of wors to be retrieved
     */
    public SelectQuery limit(Integer limit) {
        this.limit = new Limit(AExp.exp(limit));
        return this;
    }

    /**
     * Sets OFFSET clause of this query.
     *
     * @param offset OFFSET clause
     */
    public SelectQuery offset(Offset offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Sets OFFSET clause of this query.
     *
     * @param offset number of wors to be retrieved
     */
    public SelectQuery offset(Integer offset) {
        this.offset = new Offset(AExp.exp(offset));
        return this;
    }

    /**
     * Sets DISTINCT clause of this query
     *
     * @param distinct whether DISTINCT clause should be appended
     */
    public SelectQuery distinct(boolean distinct) {
        this.distinct = distinct;
        return this;
    }

    /**
     * Sets DISTINCT clause of this query
     */
    public SelectQuery distinct() {
        this.distinct(true);
        return this;
    }

    /**
     * Adds column (expression) to retrieving exressions.
     *
     * @param columnExpression column (expression) to be added
     */
    public SelectQuery addColumnExpression(AExp columnExpression) {
        this.columnExpressions.add(columnExpression);
        return this;
    }

    /**
     * Returns the list of table references the query uses
     *
     * @return list of table references the query uses
     */
    public List<TableReference> getTableReferences() {
        return this.tableReferences;
    }

    /**
     * The same as {@link WhereQuery#setWhere(LExp)} but it returns the modified query.
     *
     * @param where WHERE clause
     * @return modified query
     */
    public SelectQuery where(LExp where) {
        setWhere(where);
        return this;
    }


    /**
     * Builds the query.
     *
     * @throws IllegalArgumentException if <code>offset</code> is greater that 0 but the query has no ORDER BY clause.
     */
    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        buildSelect(sb, objs);
        buildFrom(sb, objs);
        buildWhere(sb, objs);
        buildOrderBy(sb, objs);
        buildLimitOffset(sb, objs);
    }

    /**
     * Builds a SELECT part of query in a standard way
     *
     * @param sb   StringBuilder to build the query
     * @param objs objs an accumulator list to which query parameters are appended
     */
    protected void buildSelect(StringBuilder sb, List<Value> objs) {
        sb.append(SELECT);

        if (this.distinct) {
            sb.append(DISTINCT);
        }

        for (Iterator<AExp> i = this.columnExpressions.iterator(); i.hasNext();) {
            AExp a = i.next();
            a.build(sb, objs);

            if (i.hasNext()) {
                sb.append(COMMA);
            }
        }
    }

    /**
     * Builds a FROM part of query in a standard way
     *
     * @param sb   StringBuilder to build the query
     * @param objs objs an accumulator list to which query parameters are appended
     */
    protected void buildFrom(StringBuilder sb, List<Value> objs) {
        sb.append(FROM);

        for (Iterator<TableReference> i = this.tableReferences.iterator(); i.hasNext();) {
            TableReference tableReference = i.next();
            tableReference.build(sb, objs);

            if (i.hasNext()) {
                sb.append(COMMA);
            }
        }
    }

    /**
     * Builds a WHERE part of query in a standard way
     *
     * @param sb   StringBuilder to build the query
     * @param objs objs an accumulator list to which query parameters are appended
     */
    protected void buildWhere(StringBuilder sb, List<Value> objs) {
        if (this.where != null) {
            sb.append(WHERE);
            this.where.build(sb, objs);
        }
    }

    /**
     * Builds a ORDER BY part of query
     *
     * @param sb   StringBuilder to build the query
     * @param objs objs an accumulator list to which query parameters are appended
     */
    protected void buildOrderBy(StringBuilder sb, List<Value> objs) {
        if (this.orderBy != null) {
            sb.append(ORDER_BY);
            int i = 0;
            for (Iterator<OrderBy> it = orderBy.iterator(); it.hasNext(); i++) {
                OrderBy orderByItem = it.next();
                if (i != 0) {
                    sb.append(COMMA);
                }
                orderByItem.build(sb, objs);
            }
        }
    }

    /**
     * Builds a LIMIT and OFFSET part of query
     *
     * @param sb   StringBuilder to build the query
     * @param objs objs an accumulator list to which query parameters are appended
     */
    protected void buildLimitOffset(StringBuilder sb, List<Value> objs) {
        if (this.limit != null) {
            sb.append(LIMIT);
            this.limit.build(sb, objs);
        }
        if (this.offset != null) {
            sb.append(OFFSET);
            this.offset.build(sb, objs);
        }
    }

    @Override
    public String toString() {
        return "SelectQuery [columns=" + this.columnExpressions
                + ", tableReferences=" + this.tableReferences + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        SelectQuery that = (SelectQuery) o;

        if (!columnExpressions.equals(that.columnExpressions)) {
            return false;
        }
        return tableReferences.equals(that.tableReferences);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + columnExpressions.hashCode();
        result = 31 * result + tableReferences.hashCode();
        return result;
    }
}
