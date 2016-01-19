package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents an <code>INSERT</code> query.
 */
public class InsertStatement implements Expression {

    /**
     * Constant used to build a query.
     */
    public static final String INSERT = "INSERT";

    /**
     * Constant used to build a query.
     */
    public static final String INTO = " INTO ";

    /**
     * Constant used to build a query.
     */
    public static final String VALUES = " VALUES ";

    /**
     * Constant used to build a query.
     */
    public static final String QUESTION_MARK = "?";

    /**
     * Table expression for which this query was created.
     */
    protected TableExpression table;

    /**
     * Map of values inserted by the query.
     */
    private Map<Column, Object> values;

    /**
     * Constructor.
     *
     * @param table table expression this query inserts into
     */
    public InsertStatement(TableExpression table) {
        this.table = table;
    }

    /**
     * Checks whether the table of this query and the specified column are the same.
     *
     * @param c column to check
     * @throws IllegalArgumentException if the table of this query and the specified column are not the same
     */
    protected void checkColumn(Column c) {
        if (!this.table.getName().equals(c.getOwner().getName())) {
            throw new IllegalArgumentException("Table from table expression ('" + this.table.getName()
                            + "') and table from column ('" + c.getOwner().getName()
                            + "') are not the same.");
        }
    }

    /**
     * Sets the values of the inserted tuple.
     *
     * @param vals map where ({@link Column}) objects are keys, and the inserted values are values
     */
    public InsertStatement setValues(Map<Column, Object> vals) {
        for (Iterator<Column> i = vals.keySet().iterator(); i.hasNext();) {
            checkColumn(i.next());
        }
        this.values = vals;
        return this;
    }

    /**
     * Sets the value of a single column.
     *
     * @param column column to be set
     * @param value  value to be set
     * @return this query this the value of a single column set
     */
    public InsertStatement setValue(Column column, Object value) {
        checkColumn(column);

        if (this.values == null) {
            this.values = new LinkedHashMap<Column, Object>(this.table.getColumns().size(), 1);
        }
        this.values.put(column, value);
        return this;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        sb.append(INSERT);
        sb.append(INTO);
        this.table.build(sb, objs);

        if (this.values != null) {
            StringBuilder realValues = new StringBuilder(VALUES);

            sb.append(" ");
            sb.append(LB);
            realValues.append(LB);

            for (Iterator it = values.entrySet().iterator(); it.hasNext();) {
                Map.Entry<Column, Object> pair = (Map.Entry) it.next();
                sb.append(pair.getKey().getName());
                realValues.append(QUESTION_MARK);
                objs.add(new Value(pair.getValue(), pair.getKey().getType()));
                if (it.hasNext()) {
                    sb.append(COMMA);
                    realValues.append(COMMA);
                }
            }

            sb.append(RB);
            realValues.append(RB);

            sb.append(realValues.toString());
        } else {
            throw new IllegalStateException("VALUES should be defined.");
        }
    }

}
