package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Represents a <b>logical</b> expression i.e., the one which has a logical value, <code>true</code>
 * or <code>false</code>.
 * <p/>
 * <p/>
 * It is convenient to distinguished to types of logical expressions used in
 * this component
 * <p/>
 * <table border="1" cellpadding="3" cellspacing="0" width="100%">
 * <tr class="TableHeadingColor">
 * <th>expression type</th>
 * <th>description</th>
 * </tr>
 * <tr>
 * <td><b>terminal expressions</b></th>
 * <td> Expression which has a logical value.It may be created by comparison of two arithmetic expressions
 * {@link AExp}.</td>
 * </tr>
 * <tr>
 * <td><b>nonterminal expressions</b></td>
 * <td> Expression which is composed of other logical expression joined with logical operations:
 * AND, OR, negation etc.</td>
 * </tr>
 * </table>
 */
public abstract class LExp implements Expression {

    /**
     * Constant used to build a query.
     */
    static final String AND = " AND ";

    /**
     * Constant used to build a query.
     */
    static final String OR = " OR ";

    /**
     * Constant used to build a query.
     */
    static final String NOT = "NOT ";

    /**
     * Constant used to build a query.
     */
    static final String IS_NULL = " IS NULL";

    /**
     * Constant used to build a query.
     */
    static final String IS_NOT_NULL = " IS NOT NULL";

    /**
     * Constant used to build a query.
     */
    static final String LIKE = " LIKE ";

    /**
     * Constant used to build a query.
     */
    static final String IN = " IN ";
    /**
     * Constant used to build a query.
     */
    static final String EXISTS = " EXISTS ";


    /**
     * Constant representing a logical expression which is always true
     */
    public static final LExp TRUE = new LExp() {
        @Override
        public void build(StringBuilder sb, List<Value> objects) {
            sb.append("1 = 1");
        }
    };

    /**
     * Constant representing a logical expression which is always false
     */
    public static final LExp FALSE = new LExp() {
        @Override
        public void build(StringBuilder sb, List<Value> objects) {
            sb.append("1 = 0");
        }
    };



    /**
     * Puts parentheses around the specifed logical expression.
     *
     * @param exp logical expression
     * @return an logical expression <code>exp</code> with parentheses around it
     */

    public static LExp par(LExp exp) {
        return new ParenthesesLExp(exp);
    }

    // static methods to create logical expression
    // from comparision of two arithmetic expressions.

    /**
     * Creates a logical expression using the equality operator ('='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(AExp left, AExp right) {
        return new BinaryLExp(left, AExp.EQ, right);
    }

    /**
     * Creates a logical expression using the equality operator ('='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(boolean left, boolean right) {
        return new BinaryLExp(AExp.exp(left), AExp.EQ, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(long left, long right) {
        return new BinaryLExp(AExp.exp(left), AExp.EQ, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(double left, double right) {
        return new BinaryLExp(AExp.exp(left), AExp.EQ, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(Boolean left, Boolean right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.EQ,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(Integer left, Integer right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.EQ,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(Long left, Long right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.EQ,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(Float left, Float right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.EQ,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(Double left, Double right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.EQ,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(BigDecimal left, BigDecimal right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.EQ,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(String left, String right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.EQ,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(Date left, Date right) {
        return new BinaryLExp(AExp.exp(new java.sql.Date(left.getTime())),
                AExp.EQ,
                AExp.exp(new java.sql.Date(right.getTime())));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(java.sql.Date left, java.sql.Date right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.EQ,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(java.sql.Time left, java.sql.Time right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.EQ,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp eq(java.sql.Timestamp left, java.sql.Timestamp right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.EQ,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the equality operator ('=') between an arithmetical expression and
     * subselect.
     * @param exp left expression
     * @param query SELECT query to e wrapped in subselect
     * @return the created logical expression
     */
    public static LExp eq(AExp exp, SelectQuery query) {
        return new BinaryLExp(AExp.exp(exp), AExp.EQ, new Subselect(query));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(AExp left, AExp right) {
        return new BinaryLExp(left, AExp.NE, right);
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(boolean left, boolean right) {
        return new BinaryLExp(AExp.exp(left), AExp.NE, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(long left, long right) {
        return new BinaryLExp(AExp.exp(left), AExp.NE, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(double left, double right) {
        return new BinaryLExp(AExp.exp(left), AExp.NE, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(Boolean left, Boolean right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.NE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(Integer left, Integer right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.NE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(Long left, Long right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.NE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(Float left, Float right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.NE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(Double left, Double right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.NE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(BigDecimal left, BigDecimal right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.NE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(String left, String right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.NE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(Date left, Date right) {
        return new BinaryLExp(AExp.exp(new java.sql.Date(left.getTime())),
                AExp.NE,
                AExp.exp(new java.sql.Date(right.getTime())));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(java.sql.Date left, java.sql.Date right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.NE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(java.sql.Time left, java.sql.Time right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.NE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator ('&lt;&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ne(java.sql.Timestamp left, java.sql.Timestamp right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.NE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the inequality operator (&lt;&gt;') between an arithmetical expression and
     * subselect.
     * @param exp left expression
     * @param query SELECT query to e wrapped in subselect
     * @return the created logical expression
     */
    public static LExp ne(AExp exp, SelectQuery query) {
        return new BinaryLExp(AExp.exp(exp), AExp.NE, new Subselect(query));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(AExp left, AExp right) {
        return new BinaryLExp(left, AExp.GT, right);
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(long left, long right) {
        return new BinaryLExp(AExp.exp(left), AExp.GT, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(double left, double right) {
        return new BinaryLExp(AExp.exp(left), AExp.GT, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(Integer left, Integer right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(Long left, Long right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(Float left, Float right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(Double left, Double right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(BigDecimal left, BigDecimal right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(Date left, Date right) {
        return new BinaryLExp(AExp.exp(new java.sql.Date(left.getTime())),
                AExp.GT,
                AExp.exp(new java.sql.Date(right.getTime())));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(java.sql.Date left, java.sql.Date right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(java.sql.Time left, java.sql.Time right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp gt(java.sql.Timestamp left, java.sql.Timestamp right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than operator ('&gt;') between an arithmetical expression and
     * subselect.
     * @param exp left expression
     * @param query SELECT query to e wrapped in subselect
     * @return the created logical expression
     */
    public static LExp gt(AExp exp, SelectQuery query) {
        return new BinaryLExp(AExp.exp(exp), AExp.GT, new Subselect(query));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(AExp left, AExp right) {
        return new BinaryLExp(left, AExp.GE, right);
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(long left, long right) {
        return new BinaryLExp(AExp.exp(left), AExp.GE, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(double left, double right) {
        return new BinaryLExp(AExp.exp(left), AExp.GE, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(Integer left, Integer right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(Long left, Long right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(Float left, Float right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(Double left, Double right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(BigDecimal left, BigDecimal right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(Date left, Date right) {
        return new BinaryLExp(AExp.exp(new java.sql.Date(left.getTime())),
                AExp.GE,
                AExp.exp(new java.sql.Date(right.getTime())));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(java.sql.Date left, java.sql.Date right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(java.sql.Time left, java.sql.Time right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp ge(java.sql.Timestamp left, java.sql.Timestamp right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.GE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the greater than or equal to operator ('&gt;')
     * between an arithmetical expression and subselect.
     * @param exp left expression
     * @param query SELECT query to e wrapped in subselect
     * @return the created logical expression
     */
    public static LExp ge(AExp exp, SelectQuery query) {
        return new BinaryLExp(AExp.exp(exp), AExp.GE, new Subselect(query));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(AExp left, AExp right) {
        return new BinaryLExp(left, AExp.LT, right);
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(long left, long right) {
        return new BinaryLExp(AExp.exp(left), AExp.LT, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(double left, double right) {
        return new BinaryLExp(AExp.exp(left), AExp.LT, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(Integer left, Integer right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(Long left, Long right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(Float left, Float right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(Double left, Double right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(BigDecimal left, BigDecimal right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(Date left, Date right) {
        return new BinaryLExp(AExp.exp(new java.sql.Date(left.getTime())),
                AExp.LT,
                AExp.exp(new java.sql.Date(right.getTime())));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(java.sql.Date left, java.sql.Date right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(java.sql.Time left, java.sql.Time right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than operator ('&lt;'). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp lt(java.sql.Timestamp left, java.sql.Timestamp right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LT,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than operator ('&gt;')
     * between an arithmetical expression and subselect.
     * @param exp left expression
     * @param query SELECT query to e wrapped in subselect
     * @return the created logical expression
     */
    public static LExp lt(AExp exp, SelectQuery query) {
        return new BinaryLExp(AExp.exp(exp), AExp.LT, new Subselect(query));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(AExp left, AExp right) {
        return new BinaryLExp(left, AExp.LE, right);
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(long left, long right) {
        return new BinaryLExp(AExp.exp(left), AExp.LE, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(double left, double right) {
        return new BinaryLExp(AExp.exp(left), AExp.LE, AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(Integer left, Integer right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(Long left, Long right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(Float left, Float right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(Double left, Double right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(BigDecimal left, BigDecimal right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(Date left, Date right) {
        return new BinaryLExp(AExp.exp(new java.sql.Date(left.getTime())),
                AExp.LE,
                AExp.exp(new java.sql.Date(right.getTime())));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(java.sql.Date left, java.sql.Date right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(java.sql.Time left, java.sql.Time right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&lt;='). 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp le(java.sql.Timestamp left, java.sql.Timestamp right) {
        return new BinaryLExp(AExp.exp(left),
                AExp.LE,
                AExp.exp(right));
    }

    /**
     * Creates a logical expression using the less than or equal to operator ('&gt;')
     * between an arithmetical expression and subselect.
     * @param exp left expression
     * @param query SELECT query to e wrapped in subselect
     * @return the created logical expression
     */
    public static LExp le(AExp exp, SelectQuery query) {
        return new BinaryLExp(AExp.exp(exp), AExp.LE, new Subselect(query));
    }

    /**
     * Creates a logical expression using the IN operator.
     *
     * @param left left operand
     * @param query query to be wrapped as subselect
     * @return the created logical expression
     */
    public static LExp in(AExp left, SelectQuery query) {
        return new BinaryLExp(left, IN, new Subselect(query));
    }

    /**
     * Creates a logical expression using the IN operator.
     *
     * @param left  left operand
     * @param right list of operands
     * @return the created logical expression
     */
    public static LExp in(AExp left, Collection<AExp> right) {
        return new BinaryLExp(new ParenthesesAExp(left), IN, new CollectionAExp(right));
    }

    /**
     * Creates the logical conjunction ('AND') of the specified expressions.
     * 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp and(LExp left, LExp right) {
        return new BinaryLExp(new ParenthesesLExp(left), AND, new ParenthesesLExp(right));
    }

    /**
     * Creates the logical alternative ('OR') of the specified expressions.
     * 
     *
     * @param left  left operand
     * @param right right operand
     * @return the created logical expression
     */
    public static LExp or(LExp left, LExp right) {
        return new BinaryLExp(new ParenthesesLExp(left), OR, new ParenthesesLExp(right));
    }

    /**
     * Creates the logical negation ('NOT') of the specified expression.
     * 
     *
     * @param exp expression to negate.
     * @return the created logical expression
     */
    public static LExp not(LExp exp) {
        return new LeftOperatorLExp(NOT, new ParenthesesLExp(exp));
    }

    /**
     * Creates a logical expression testing whether the specifies arithmetic expression is null
     * ('IS NULL' condition).
     *
     * @param exp expression to test for nullability.
     * @return the created logical expression
     */
    public static LExp isNull(AExp exp) {
        return new RightOperatorLExp(new ParenthesesAExp(exp), IS_NULL);
    }

    /**
     * Creates a logical expression using LIKE operatoror.
     *
     * @param left left expression
     * @param right right expression
     * @return the created logical expression
     */
    public static LExp like(AExp left, AExp right) {
        return new BinaryLExp(new ParenthesesAExp(left), LIKE, new ParenthesesAExp(right));
    }

    /**
     * Creates a logical expression using LIKE operatoror.
     *
     * @param exp left expression
     * @param pattern pattern to be matched
     * @return the created logical expression
     */
    public static LExp like(AExp exp, String pattern) {
        return new BinaryLExp(new ParenthesesAExp(exp), LIKE, new ParenthesesAExp(AExp.exp(pattern)));
    }

    /**
     * Creates a logical expression using EXISTS operatoror.
     *
     * @param subselect subselect to be used in query
     */
    public static LExp exists(SelectQuery subselect) {
        return new LeftOperatorLExp(EXISTS, new Subselect(subselect));
    }

    /**
     * Creates a logical expression testing whether the specifies arithmetic expression is not null
     * ('IS NOT NULL' condition).
     *
     * @param exp expression to test for nullability.
     * @return the created logical expression
     */
    public static LExp isNotNull(AExp exp) {
        return new RightOperatorLExp(new ParenthesesAExp(exp), IS_NOT_NULL);
    }

    // instance methods


    /**
     * Creates the logical expression representing the conjunction ('AND')
     * of <code>this</code> expression and a specified expression.
     * It does not put the expression in parentheses.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp and(LExp exp) {
        return new BinaryLExp(new ParenthesesLExp(this), AND, new ParenthesesLExp(exp));
    }

    /**
     * Creates the logical expression representing the conjunction ('AND')
     * of the specified list of logical expressions. If the list is empty, it returns {@link LExp#TRUE}.
     *
     * @param l list of logical expressions
     * @return the conjunction of the specified list of expressions or {@link LExp#TRUE} if the list is empty
     */
    public static LExp and(List<LExp> l) {
        if (l.size() == 0) {
            return LExp.TRUE;
        }

        if (l.size() == 1) {
            return l.get(0);
        }

        return LExp.and(l.get(0), and(l.subList(1, l.size())));
    }


    /**
     * Creates the logical expression representing the alternative ('OR')
     * of <code>this</code> expression and a specified expression.
     * It does not put the expression in parentheses.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp or(LExp exp) {
        return new BinaryLExp(new ParenthesesLExp(this), OR, new ParenthesesLExp(exp));
    }


    /**
     * Creates the logical expression representing the alternative ('OR')
     * of the specified list of logical expressions. If the list is empty, it returns {@link LExp#FALSE}.
     *
     * @param l list of logical expressions
     * @return the conjunction of the specified list of expressions or {@link LExp#FALSE} if the list is empty
     */
    public static LExp or(List<LExp> l) {
        if (l.size() == 0) {
            return LExp.FALSE;
        }

        if (l.size() == 1) {
            return l.get(0);
        }

        return LExp.or(l.get(0), or(l.subList(1, l.size())));
    }

}
