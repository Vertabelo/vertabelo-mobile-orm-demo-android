package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

/**
 * Represents logical expression created from another logical expression and logical operator
 */
public class RightOperatorLExp extends LExp {

    private final Expression exp;

    private final String operator;

    public RightOperatorLExp(Expression exp, String operator) {
        this.exp = exp;
        this.operator = operator;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objects) {
        exp.build(sb, objects);

        sb.append(operator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RightOperatorLExp that = (RightOperatorLExp) o;

        if (exp != null ? !exp.equals(that.exp) : that.exp != null) {
            return false;
        }
        return !(operator != null ? !operator.equals(that.operator) : that.operator != null);

    }

    @Override
    public int hashCode() {
        int result = exp != null ? exp.hashCode() : 0;
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RightOperatorLExp{"
                + "exp=" + exp
                + ", operator='" + operator + '\''
                + '}';
    }
}
