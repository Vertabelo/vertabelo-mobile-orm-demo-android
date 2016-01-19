package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

/**
 * Represents a subquery (<code>SELECT .... FROM (SELECT ....)</code>)
 */
public class Subselect extends AExp {

    /**
     * Subquery
     */
    protected SelectQuery query;

    /**
     * Constructor.
     *
     * @param query subquery
     */
    public Subselect(SelectQuery query) {
        this.query = query;
    }

    /**
     * Returns select query of this Subselect
     * @return select query of this Subselect
     */
    public SelectQuery getQuery() {
        return query;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        sb.append(LB);
        this.query.build(sb, objs);
        sb.append(RB);
    }

}
