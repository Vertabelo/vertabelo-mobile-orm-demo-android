package com.vertabelo.mobileorm.myplaces.orm.runtime.query;


import java.util.List;

/**
 * Represents two expressions connected into one logical expression using an operator.
 */
public class BinaryLExp extends LExp {

    private final Expression left;

    private final String operator;

    private final Expression right;

    public BinaryLExp(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objects) {
        left.build(sb, objects);

        sb.append(operator);

        right.build(sb, objects);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BinaryLExp that = (BinaryLExp) o;

        if (left != null ? !left.equals(that.left) : that.left != null) {
            return false;
        }
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) {
            return false;
        }
        return !(right != null ? !right.equals(that.right) : that.right != null);

    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BinaryLExp{"
                + "left=" + left
                + ", operator='" + operator + '\''
                + ", right=" + right
                + '}';
    }
}
