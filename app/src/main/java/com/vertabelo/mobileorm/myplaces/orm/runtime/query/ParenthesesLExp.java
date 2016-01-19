package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

/**
 * Represents logical expression put in parentheses.
 */
public class ParenthesesLExp extends LExp {

    private final LExp exp;

    public ParenthesesLExp(LExp exp) {
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

        ParenthesesLExp that = (ParenthesesLExp) o;

        return !(exp != null ? !exp.equals(that.exp) : that.exp != null);

    }

    @Override
    public int hashCode() {
        return exp != null ? exp.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ParenthesesLExp{"
                + "exp=" + exp
                + '}';
    }
}
