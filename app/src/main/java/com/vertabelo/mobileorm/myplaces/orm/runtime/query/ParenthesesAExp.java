package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

/**
 * Represents arithmetical expression put in parentheses.
 */
public class ParenthesesAExp extends AExp {

    private final AExp exp;

    public ParenthesesAExp(AExp exp) {
        this.exp = exp;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objects) {
        sb.append(LB);

        exp.build(sb, objects);

        sb.append(RB);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ParenthesesAExp that = (ParenthesesAExp) o;

        return !(exp != null ? !exp.equals(that.exp) : that.exp != null);

    }

    @Override
    public int hashCode() {
        return exp != null ? exp.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ParenthesesAExp{"
                + "exp=" + exp
                + '}';
    }
}
