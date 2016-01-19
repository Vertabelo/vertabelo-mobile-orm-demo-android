package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

/**
 * Base class of all queries which contains the WHERE clause (such as <code>SELECT</code>,
 * <code>UPDATE</code>, <code>DELETE</code>).
 * The WHERE clauses are represented as logical expressions{@link LExp}.
 */
public abstract class WhereQuery implements Expression {

    /**
     * Constant used to build a query.
     */
    public static final String WHERE = " WHERE ";

    /**
     * Constructor. The WHERE condition is set to <code>null</code>.
     */
    public WhereQuery() {

    }

    /**
     * WHERE clause of the query
     */
    protected LExp where;

    /**
     * Returns the WHERE condition of the query.
     *
     * @return WHERE condition of the query
     */
    public LExp getWhere() {
        return this.where;
    }

    /**
     * Sets the WHERE condition of the query.
     *
     * @param where the WHERE condition of the query
     */
    public WhereQuery setWhere(LExp where) {
        this.where = where;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.where == null) ? 0 : this.where.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        WhereQuery other = (WhereQuery) obj;
        if (this.where == null) {
            if (other.where != null) {
                return false;
            }
        } else if (!this.where.equals(other.where)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WhereQuery [where=" + this.where + "]";
    }

}
