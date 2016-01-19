package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

/**
 * Interface which is used to build a {@link java.sql.PreparedStatement} object (or a part of it).
 * The only method of this interface creates the query text (through {@link StringBuilder})
 * and binds query parameters to the statement.
 */
public interface Expression {

    /**
     * Constant used to build a query.
     */
    String SPACE = " ";

    /**
     * Constant used to build a query.
     */
    String COMMA = ", ";

    /**
     * Constant used to build a query.
     */
    String DOT = ".";

    /**
     * Constant used to build a query.
     */
    String LB = "(";

    /**
     * Constant used to build a query.
     */
    String RB = ")";

    /**
     * Constant used to build a query.
     */
    String QUESTION_MARK = "?";

    /**
     * Builds the text of the query (or a part of it) represented by this object.
     *
     * @param sb   StringBuilder to build the query text
     * @param objs an accumulator list to which query parameters are appended
     */
    void build(StringBuilder sb, List<Value> objs);

}
