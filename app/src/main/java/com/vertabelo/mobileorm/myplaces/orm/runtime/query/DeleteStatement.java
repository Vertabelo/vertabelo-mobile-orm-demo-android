package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

/**
 * Represent the <code>DELETE</code> delete query.
 */
public class DeleteStatement extends WhereQuery {

    /** Constant used to build a query. */
    public static final String DELETE = "DELETE ";

    /** Constant used to build a query. */
    public static final String FROM = "FROM ";

    /** Table expression for which this query was created. */
    protected TableExpression table;

    /**
     * Constructor.
     * @param table table expression this query deletes from
     */
    public DeleteStatement(TableExpression table) {
        this.table = table;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        sb.append(DELETE);
        sb.append(FROM);
        this.table.build(sb, objs);

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
        DeleteStatement other = (DeleteStatement) obj;
        if (this.table == null) {
            if (other.table != null) {
                return false;
            }
        } else if (!this.table.equals(other.table)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DeleteStatement [table=" + this.table + ", where=" + this.where + "]";
    }

}
