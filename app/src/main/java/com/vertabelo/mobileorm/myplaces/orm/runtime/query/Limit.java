package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

/**
 * Represents a LIMIT clause.
 */
public class Limit implements Expression {

    protected AExp limit;

    public Limit(AExp limit) {
        this.limit = limit;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        limit.build(sb, objs);
    }
}
