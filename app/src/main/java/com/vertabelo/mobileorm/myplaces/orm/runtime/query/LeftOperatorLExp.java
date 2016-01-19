package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

/**
 * Represents logical expression created from logical operator and another logical expression
 */
public class LeftOperatorLExp extends LExp {

    private final String operator;

    private final Expression exp;

    public LeftOperatorLExp(String operator, Expression exp) {
        this.exp = exp;
        this.operator = operator;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objects) {
        sb.append(operator);

        exp.build(sb, objects);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LeftOperatorLExp that = (LeftOperatorLExp) o;

        if (operator != null ? !operator.equals(that.operator) : that.operator != null) {
            return false;
        }
        return !(exp != null ? !exp.equals(that.exp) : that.exp != null);

    }

    @Override
    public int hashCode() {
        int result = operator != null ? operator.hashCode() : 0;
        result = 31 * result + (exp != null ? exp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LeftOperatorLExp{"
                + "operator='" + operator + '\''
                + ", exp=" + exp
                + '}';
    }
}
