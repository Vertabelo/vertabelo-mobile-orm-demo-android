package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

/**
 * Represents an ORDER BY clause.
 */
public class OrderBy implements Expression {

    /**
     * The expression we are ordering by.
     */
    private AExp expression;

    /**
     * Direction of ordering.
     */
    private OrderByDirection direction;

    /**
     * Constructor.
     *
     * @param expression expression we are ordering by
     * @param direction  direction of ordering
     */
    public OrderBy(AExp expression, OrderByDirection direction) {
        this.expression = expression;
        this.direction = direction;
    }

    /**
     * Returns the expression we are ordering by.
     *
     * @return expression we are ordering by
     */
    public AExp getExpression() {
        return this.expression;
    }

    /**
     * Returns direction of ordering.
     *
     * @return direction of ordering
     */
    public OrderByDirection getDirection() {
        return this.direction;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        if (this.expression == null) {
            throw new IllegalStateException("EXPRESSION must not be null.");
        }

        this.expression.build(sb, objs);
        sb.append(this.direction);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.direction == OrderByDirection.ASC ? 1231 : 1237);
        result = prime * result
                + ((this.expression == null) ? 0 : this.expression.hashCode());
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
        OrderBy other = (OrderBy) obj;
        if (this.direction != other.direction) {
            return false;
        }
        if (this.expression == null) {
            if (other.expression != null) {
                return false;
            }
        } else if (!this.expression.equals(other.expression)) {
            return false;
        }
        return true;
    }

}
