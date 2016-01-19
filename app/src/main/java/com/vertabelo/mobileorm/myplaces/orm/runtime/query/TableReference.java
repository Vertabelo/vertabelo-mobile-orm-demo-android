package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

/**
 * Represents a reference to the table (an element of a <code>FROM</code> clause from <code>SELECT</code>).
 */
public interface TableReference extends Expression {

    /**
     * Returns the list of columns of this table expression.
     *
     * @return list of columns of this table expression
     */
    List<Column> getColumns();
}
