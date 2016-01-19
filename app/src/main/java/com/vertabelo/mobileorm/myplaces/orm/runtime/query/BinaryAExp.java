package com.vertabelo.mobileorm.myplaces.orm.runtime.query;


import java.util.List;

/**
 * Represents two arithmetical expressions connected into one using arithmetical operator.
 */
public class BinaryAExp extends AExp {

    /**
     * Arithmetical expression representing left part of this expression.
     */
    private final AExp left;

    /**
     * Arithmetical expression representing left part of this expression.
     */
    private final AExp right;

    /**
     * Operator of this expression.
     */
    private final String operator;

    /**
     * Constructor.
     * @param left left part of expression
     * @param right right part of expression
     * @param operator operator
     */
    public BinaryAExp(AExp left, String operator, AExp right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objects) {
        if (left != null) {
            left.build(sb, objects);
        }

        sb.append(operator);

        if (right != null) {
            right.build(sb, objects);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BinaryAExp that = (BinaryAExp) o;

        if (left != null ? !left.equals(that.left) : that.left != null) {
            return false;
        }
        if (right != null ? !right.equals(that.right) : that.right != null) {
            return false;
        }
        return !(operator != null ? !operator.equals(that.operator) : that.operator != null);

    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BinaryAExp{"
                + "left=" + left
                + ", right=" + right
                + ", operator='" + operator + '\''
                + '}';
    }
}
