package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Represents an <b>arithemetic</b> expression i.e., the one which has arithmetic value.
 * <p/>
 * <p/>
 * It is convenient to distinguished to types of arithmetic expressions used in
 * this component
 * <p/>
 * <table border="1" cellpadding="3" cellspacing="0" width="100%">
 * <tr class="TableHeadingColor">
 * <th>expression type</th>
 * <th>description</th>
 * </tr>
 * <tr>
 * <td><b>terminal expressions</b></th>
 * <td> Expression which has a value. A terminal expression is created from an object representing this value.</td>
 * </tr>
 * <tr>
 * <td><b>nonterminal expressions</b></td>
 * <td> Expression which is composed of other expression with arithmetical operations: addition, mulitplication, etc.</td>
 * </tr>
 * </table>
 */
public abstract class AExp implements Expression {

    /**
     * Constant used to build a query.
     */
    static final String ADD = " + ";

    /**
     * Constant used to build a query.
     */
    static final String SUB = " - ";

    /**
     * Constant used to build a query.
     */
    static final String MUL = " * ";

    /**
     * Constant used to build a query.
     */
    static final String DIV = " / ";

    /**
     * Constant used to build a query.
     */
    static final String EQ = " = ";

    /**
     * Constant used to build a query.
     */
    static final String NE = " <> ";

    /**
     * Constant used to build a query.
     */
    static final String GT = " > ";

    /**
     * Constant used to build a query.
     */
    static final String GE = " >= ";

    /**
     * Constant used to build a query.
     */
    static final String LT = " < ";

    /**
     * Constant used to build a query.
     */
    static final String LE = " <= ";

    /**
     * Constant used to build a query.
     */
    static final String ALL = " ALL ";

    /**
     * Constant used to build a query.
     */
    static final String ANY = " ANY ";

    /**
     * Constant used to build a query.
     */
    static final String SOME = " SOME ";

    /**
     * Constant expression representing asterisk.
     */
    public static final AExp ASTERISK = exp("*");

    /**
     * Puts expression in parentheses.
     *
     * @param exp expression to be put
     * @return expression put in parenthesis
     */
    public static AExp par(AExp exp) {
        return new ParenthesesAExp(exp);
    }

    //static factory

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(boolean exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(long exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(double exp) {
        return new Value(exp, SQLiteType.REAL);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(Boolean exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(Integer exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(Byte exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(Short exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(Long exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(Float exp) {
        return new Value(exp, SQLiteType.REAL);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(Double exp) {
        return new Value(exp, SQLiteType.REAL);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(BigDecimal exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(String exp) {
        return new Value(exp, SQLiteType.TEXT);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(Date exp) {
        return new Value(new java.sql.Date(exp.getTime()), SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(java.sql.Date exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(Time exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(Timestamp exp) {
        return new Value(exp, SQLiteType.INTEGER);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter.
     *
     * @param exp the value of the expression
     */
    public static AExp exp(byte[] exp) {
        return new Value(exp, SQLiteType.NONE);
    }

    /**
     * Creates a terminal arithmetic expression from the specified parameter,
     * choosing an appropriate SQLite type from the class of the parameter. 
     * The supported classes are:
     *  <ul>
     * <li><code>String</code></li>
     * <li><code>java.math.BigDecimal</code></li>
     * <li><code>Boolean</code></li>
     * <li><code>Integer</code></li>
     * <li><code>Byte</code></li>
     * <li><code>Short</code></li>
     * <li><code>Long</code></li>
     * <li><code>Float</code></li>
     * <li><code>Double</code></li>
     * <li><code>byte[]</code></li>
     * <li><code>java.sql.Date</code></li>
     * <li><code>java.sql.Time</code></li>
     * <li><code>java.sql.Timestamp</code></li>
     * <li><code>com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp</code></li>
     * </ul>
     * If the parameter is an object of a different class, an {@link IllegalArgumentException} is thrown.
     *
     * @param exp the value of the expression
     * @return the created terminal arithmetic expression
     * @throws IllegalArgumentException if the parameter is null or it is not an object of the supported class
     */
    public static AExp exp(Object exp) {
        if (exp == null) {
            throw new IllegalArgumentException("exp is null");
        }
        if (exp instanceof String) {
            return AExp.exp((String) exp);
        } else if (exp instanceof BigDecimal) {
            return AExp.exp((BigDecimal) exp);
        } else if (exp instanceof Boolean) {
            return AExp.exp((Boolean) exp);
        } else if (exp instanceof Integer) {
            return AExp.exp((Integer) exp);
        } else if (exp instanceof Byte) {
            return AExp.exp((Byte) exp);
        } else if (exp instanceof Short) {
            return AExp.exp((Short) exp);
        } else if (exp instanceof Long) {
            return AExp.exp((Long) exp);
        } else if (exp instanceof Float) {
            return AExp.exp((Float) exp);
        } else if (exp instanceof Double) {
            return AExp.exp((Double) exp);
        } else if (exp instanceof byte[]) {
            return AExp.exp((byte[]) exp);
        } else if (exp instanceof Time) {
            return AExp.exp((Time) exp);
        } else if (exp instanceof Timestamp) {
            return AExp.exp((Timestamp) exp);
        } else if (exp instanceof java.sql.Date) {
            return AExp.exp((java.sql.Date) exp);
        } else if (exp instanceof Date) {
            return AExp.exp((Date) exp);
        } else if (exp instanceof AExp) {
            return (AExp) exp;
        } else {
            throw new IllegalArgumentException("unsupported expression object class: " + exp.getClass().getName());
        }
    }

    /**
     * Creates a nonterminal arithmetic expression which represents addition ('+').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created  arithmetic expression
     */
    public static AExp add(AExp left, AExp right) {
        return new BinaryAExp(left, ADD, right);
    }

    /**
     * Creates a nonterminal arithmetic expression which represents substraction ('-').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created  arithmetic expression
     */
    public static AExp sub(AExp left, AExp right) {
        return new BinaryAExp(left, SUB, right);
    }

    /**
     * Creates a nonterminal arithmetic expression which represents multiplication ('*').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created  arithmetic expression
     */
    public static AExp mul(AExp left, AExp right) {
        return new BinaryAExp(new ParenthesesAExp(left), MUL, new ParenthesesAExp(right));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents division ('/').
     *
     * @param left  left operand
     * @param right right operand
     * @return the created  arithmetic expression
     */
    public static AExp div(AExp left, AExp right) {
        return new BinaryAExp(new ParenthesesAExp(left), DIV, new ParenthesesAExp(right));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents a negation.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public static AExp neg(AExp exp) {
        return new ParenthesesAExp(new BinaryAExp(null, SUB, new ParenthesesAExp(exp)));
    }

    // operations on arithmetic expression

    /**
     * Creates a nonterminal arithmetic expression which represents which represents addition ('+').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp add(AExp exp) {
        return new BinaryAExp(this, ADD, exp);
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents addition ('+').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp add(long exp) {
        return new BinaryAExp(this, ADD, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents addition ('+').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp add(double exp) {
        return new BinaryAExp(this, ADD, new Value(exp, SQLiteType.REAL));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents addition ('+').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp add(Integer exp) {
        return new BinaryAExp(this, ADD, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents addition ('+').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp add(Long exp) {
        return new BinaryAExp(this, ADD, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents addition ('+').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp add(Float exp) {
        return new BinaryAExp(this, ADD, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents addition ('+').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp add(Double exp) {
        return new BinaryAExp(this, ADD, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents addition ('+').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp add(BigDecimal exp) {
        return new BinaryAExp(this, ADD, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents subtraction ('-').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp sub(AExp exp) {
        return new BinaryAExp(this, SUB, exp);
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents subtraction ('-').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp sub(long exp) {
        return new BinaryAExp(this, SUB, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents subtraction ('-').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp sub(double exp) {
        return new BinaryAExp(this, SUB, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents subtraction ('-').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp sub(Integer exp) {
        return new BinaryAExp(this, SUB, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents subtraction ('-').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp sub(Long exp) {
        return new BinaryAExp(this, SUB, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents subtraction ('-').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp sub(Float exp) {
        return new BinaryAExp(this, SUB, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents subtraction ('-').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp sub(Double exp) {
        return new BinaryAExp(this, SUB, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents subtraction ('-').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp sub(BigDecimal exp) {
        return new BinaryAExp(this, SUB, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents mutliplication ('*').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp mul(AExp exp) {
        return new BinaryAExp(new ParenthesesAExp(this), MUL, exp);
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents mutliplication ('*').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp mul(long exp) {
        return new BinaryAExp(this, MUL, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents mutliplication ('*').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp mul(double exp) {
        return new BinaryAExp(this, MUL, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents mutliplication ('*').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp mul(Integer exp) {
        return new BinaryAExp(this, MUL, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents mutliplication ('*').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp mul(Long exp) {
        return new BinaryAExp(this, MUL, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents mutliplication ('*').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp mul(Float exp) {
        return new BinaryAExp(this, MUL, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents mutliplication ('*').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp mul(Double exp) {
        return new BinaryAExp(this, MUL, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents mutliplication ('*').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp mul(BigDecimal exp) {
        return new BinaryAExp(this, MUL, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents division ('/').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp div(AExp exp) {
        return new BinaryAExp(new ParenthesesAExp(this), DIV, exp);
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents division ('/').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp div(long exp) {
        return new BinaryAExp(this, DIV, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents division ('/').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp div(double exp) {
        return new BinaryAExp(this, DIV, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents division ('/').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp div(Integer exp) {
        return new BinaryAExp(this, DIV, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents division ('/').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp div(Long exp) {
        return new BinaryAExp(this, DIV, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents division ('/').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp div(Float exp) {
        return new BinaryAExp(this, DIV, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents division ('/').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp div(Double exp) {
        return new BinaryAExp(this, DIV, new Value(exp, SQLiteType.INTEGER));
    }

    /**
     * Creates a nonterminal arithmetic expression which represents which represents division ('/').
     * It uses <code     * around the created expression.
     *
     * @param exp right operand
     * @return the created  arithmetic expression
     */
    public AExp div(BigDecimal exp) {
        return new BinaryAExp(this, DIV, new Value(exp, SQLiteType.INTEGER));
    }

    // logical operations

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(AExp exp) {
        return new BinaryLExp(this, EQ, exp);
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(boolean exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(long exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(double exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(Boolean exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(Integer exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(Long exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(Float exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(Double exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(BigDecimal exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(String exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(Date exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(java.sql.Date exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(Time exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp eq(Timestamp exp) {
        return new BinaryLExp(this, EQ, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(AExp exp) {
        return new BinaryLExp(this, NE, exp);
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(boolean exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(long exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(double exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(Boolean exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(Integer exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(Long exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(Float exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(Double exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(BigDecimal exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(String exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(Date exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(java.sql.Date exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(Time exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the inequality operator ('&lt;&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ne(Timestamp exp) {
        return new BinaryLExp(this, NE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(AExp exp) {
        return new BinaryLExp(this, GT, exp);
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(long exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(double exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(Integer exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(Long exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(Float exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(Double exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(BigDecimal exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(Date exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(java.sql.Date exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(Time exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp gt(Timestamp exp) {
        return new BinaryLExp(this, GT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(AExp exp) {
        return new BinaryLExp(this, GE, exp);
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(long exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(double exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(Integer exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(Long exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(Float exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(Double exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(BigDecimal exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(Date exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(java.sql.Date exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(Time exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp ge(Timestamp exp) {
        return new BinaryLExp(this, GE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(AExp exp) {
        return new BinaryLExp(this, LT, exp);
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(long exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(double exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(Integer exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(Long exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(Float exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(Double exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(BigDecimal exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(Date exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(java.sql.Date exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(Time exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp lt(Timestamp exp) {
        return new BinaryLExp(this, LT, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(AExp exp) {
        return new BinaryLExp(this, LE, exp);
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(long exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(double exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(Integer exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(Long exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(Float exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(Double exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(BigDecimal exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(Date exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(java.sql.Date exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(Time exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It uses <code>this</code> arithmetic expression as left operand. It does not put parentheses
     * around the created expression.
     *
     * @param exp right operand
     * @return the created logical expression
     */
    public LExp le(Timestamp exp) {
        return new BinaryLExp(this, LE, AExp.exp(exp));
    }

    /**
     * Creates a logical expression testing whether this arithmetic expression is null ('IS NULL' condition).
     *
     * @return the created logical expression
     */
    public LExp isNull() {
        return LExp.isNull(this);
    }

    /**
     * Creates a logical expression testing whether this arithmetic expression is not null ('IS NOT NULL' condition).
     *
     * @return the created logical expression
     */
    public LExp isNotNull() {
        return LExp.isNotNull(this);
    }

    //static logical operations

    /**
     * Creates a nonterminal logical expression using the equality operator ('=').
     * It does not put parenthese around the created expression.
     *
     * @param exp1 left operand
     * @param exp2 right operand
     * @return the created logical expression
     */
    public static LExp eq(AExp exp1, AExp exp2) {
        return new BinaryLExp(exp1, EQ, exp2);
    }

    /**
     * Creates a nonterminal logical expression using the nonequality operator ('&lt;&gt;').
     * It does not put parenthese around the created expression.
     *
     * @param exp1 left operand
     * @param exp2 right operand
     * @return the created logical expression
     */
    public static LExp ne(AExp exp1, AExp exp2) {
        return new BinaryLExp(exp1, NE, exp2);
    }

    /**
     * Creates a nonterminal logical expression using the greater than operator ('&gt;').
     * It does not put parenthese around the created expression.
     *
     * @param exp1 left operand
     * @param exp2 right operand
     * @return the created logical expression
     */
    public static LExp gt(AExp exp1, AExp exp2) {
        return new BinaryLExp(exp1, GT, exp2);
    }

    /**
     * Creates a nonterminal logical expression using the less than operator ('&lt;').
     * It does not put parenthese around the created expression.
     *
     * @param exp1 left operand
     * @param exp2 right operand
     * @return the created logical expression
     */
    public static LExp lt(AExp exp1, AExp exp2) {
        return new BinaryLExp(exp1, LT, exp2);
    }

    /**
     * Creates a nonterminal logical expression using the greater than or equal operator ('&gt;=').
     * It does not put parenthese around the created expression.
     *
     * @param exp1 left operand
     * @param exp2 right operand
     * @return the created logical expression
     */
    public static LExp ge(AExp exp1, AExp exp2) {
        return new BinaryLExp(exp1, GE, exp2);
    }

    /**
     * Creates a nonterminal logical expression using the less or equal than operator ('&lt;=').
     * It does not put parenthese around the created expression.
     *
     * @param exp1 left operand
     * @param exp2 right operand
     * @return the created logical expression
     */
    public static LExp le(AExp exp1, AExp exp2) {
        return new BinaryLExp(exp1, LE, exp2);
    }

    /**
     * Creates a function expression e.g. SUM, COUNT of MAX
     * @param name name of the SQLite function
     * @param arg argument of the function
     * @return the created expression
     */
    public static AExp fun(String name, AExp arg) {
        List<AExp> args = new LinkedList<AExp>();
        args.add(arg);
        return fun(name, args);
    }

    /**
    * Creates a function expression e.g. SUM, COUNT of MAX
    * @param name name of the SQLite function
    * @param args list of the arguments for the function
    * @return the created expression
    */
    public static AExp fun(String name, List<AExp> args) {
        return new FunctionAExp(name, args);
    }

}

