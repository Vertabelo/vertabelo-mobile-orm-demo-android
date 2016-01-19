package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Represents an UPDATE statement.
 */
public class UpdateStatement extends WhereQuery {

    /**
     * Constant used to build a query.
     */
    public static final String UPDATE = "UPDATE ";

    /**
     * Constant used to build a query.
     */
    public static final String SET = " SET ";

    /**
     * Constant used to build a query.
     */
    public static final String EQ = " = ";

    /**
     * Constant used to build a query.
     */
    public static final String EQ_QUESTION_MARK = " = ?";

    /**
     * Map which represents column values to be updated by the statement
     */
    private Map<Column, Value> values;

    /**
     * Table expression the statement modifies.
     */
    protected TableExpression table;

    /**
     * Constructor.
     *
     * @param table table expression this UPDATE statement modifies
     */
    public UpdateStatement(TableExpression table) {
        this.table = table;
    }

    /**
     * Checks whether the table expresion of the query and the specified column are
     * the same.
     *
     * @param c column to be checked
     * @throws IllegalArgumentException if the table expresion of the query and the specified column are not
     *                                  the same
     */
    protected void checkColumn(Column c) {
        if (!this.table.getName().equals(c.getOwner().getName())) {
            throw new IllegalArgumentException("Table from table expression ('" + this.table.getName()
                    + "') and table from column ('" + c.getOwner().getName()
                    + "') are not the same.");
        }
    }

    /**
     * Sets values for updated columns in one go.
     *
     * @param vals map representing columns to be updated; column is the key, its new value is the value
     */
    public UpdateStatement setValues(Map<Column, ?> vals) {
        this.values = new LinkedHashMap<Column, Value>(vals.size(), 1);

        for (Iterator<?> i = vals.entrySet().iterator(); i.hasNext();) {
            Entry<Column, Object> entry = (Entry<Column, Object>) i.next();
            Column c = entry.getKey();
            Object o = entry.getValue();
            checkColumn(c);
            this.values.put(c, new Value(o, c.getType()));
        }
        return this;
    }

    /**
     * Sets value for a single column.
     *
     * @param column column to be set
     * @param value  new value of the column
     * @return modified query
     */
    public UpdateStatement setValue(Column column, Object value) {
        checkColumn(column);

        if (this.values == null) {
            this.values = new LinkedHashMap<Column, Value>(this.table.getColumns().size(), 1);
        }
        this.values.put(column, new Value(value, column.getType()));
        return this;
    }

    /**
     * Sets values for updated columns to empty map.
     */
    public UpdateStatement clearValues() {
        this.values = new HashMap<Column, Value>();
        return this;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        if (this.values == null) {
            throw new IllegalStateException("SET should be defined.");
        }

        sb.append(UPDATE);
        this.table.build(sb, objs);
        sb.append(SET);

        for (Iterator<Map.Entry<Column, Value>> i = this.values.entrySet().iterator(); i.hasNext();) {
            Entry<Column, Value> entry = i.next();
            Column c = entry.getKey();
            Value v = entry.getValue();
            Object o = v.getValue();

            sb.append(c.getName());
            if (o instanceof Expression) {
                Expression exp = (Expression) o;
                sb.append(EQ);
                exp.build(sb, objs);
            } else {
                sb.append(EQ_QUESTION_MARK);
                objs.add(v);
            }

            if (i.hasNext()) {
                sb.append(COMMA);
            }
        }

        if (this.where != null) {
            sb.append(WHERE);
            this.where.build(sb, objs);
        }
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.table == null) ? 0 : this.table.hashCode());
        result = prime * result + ((this.values == null) ? 0 : this.values.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UpdateStatement other = (UpdateStatement) obj;
        if (this.table == null) {
            if (other.table != null) {
                return false;
            }
        } else if (!this.table.equals(other.table)) {
            return false;
        }
        if (this.values == null) {
            if (other.values != null) {
                return false;
            }
        } else if (!this.values.equals(other.values)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UpdateStatement [values=" + this.values + ", table=" + this.table
                + ", where=" + this.where + "]";
    }

}
