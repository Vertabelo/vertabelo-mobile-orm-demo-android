package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a table expression (a table or a view).
 */
public class TableExpression implements TableReference {

    /**
     * Name of the table expression
     */
    protected String name;

    /**
     * The list of all columns of this table expression.
     */
    protected List<Column> columns = new ArrayList<Column>();

    /**
     * The list of all BLOB columns of this table expression.
     */
    protected List<Column> blobColumns = new ArrayList<Column>();

    /**
     * The list of primary key columns of this table expression.
     */
    protected List<Column> primaryKeyColumns = new ArrayList<Column>();

    /**
     * Constructor.
     *
     * @param name name of the table expression
     */
    public TableExpression(String name) {
        setName(name);
    }

    /**
     * Returns the name of the table expression
     *
     * @return name of the table expression
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the table expression.
     *
     * @param name name of the table expression
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Column> getColumns() {
        return this.columns;
    }

    /**
     * Returns list of all BLOB columns
     *
     * @return list of all BLOB columns
     */
    public List<Column> getBlobColumns() {
        return blobColumns;
    }

    /**
     * Adds a column to the list of this table expression columns.
     *
     * @param column column
     */
    public void addColumn(Column column) {
        if (column.getType().equals(SQLiteType.NONE)) {
            this.blobColumns.add(column);
        } else {
            this.columns.add(column);
        }
        if (column.isPrimaryKey()) {
            addPrimaryKeyColumn(column);
        }
    }

    /**
     * Adds a column to the list of this table expression columns.
     *
     * @param name name of the column column
     * @param type SQlite type of the column
     * @param primaryKey whether it's a part of the primary key
     */
    public void addColumn(String name, SQLiteType type, boolean primaryKey) {
        Column column = new Column(this, name, type, primaryKey);
        this.addColumn(column);
    }

    /**
     * Adds a column which if not a part of the primary key to the list of this table expression columns.
     *
     * @param name name of the column column
     * @param type SQlite type of the column
     */
    public void addColumn(String name, SQLiteType type) {
        addColumn(name, type, false);
    }

    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        sb.append(getName());
    }

    /**
     * Returns the list of columns of this table's primary key.
     *
     * @return list of columns of this table's primary key.
     */
    public List<Column> getPrimaryKeyColumns() {
        return this.primaryKeyColumns;
    }

    /**
     * Adds column to this table's primary keys.
     *
     * @param column column to be added
     */
    void addPrimaryKeyColumn(Column column) {
        this.primaryKeyColumns.add(column);
    }

    /**
     * Sets the list of columns of this table's primary key.
     *
     * @param primaryKeyColumns list of columns
     */
    void setPrimaryKeyColumns(List<Column> primaryKeyColumns) {
        this.primaryKeyColumns = primaryKeyColumns;
    }

    /**
     * Returns the column with the specified name, it searches for the column among
     * all columns.
     *
     * @param columnName name of the column
     * @return column with the specified name
     */
    public Column getColumn(String columnName) {
        Column c = findColumn(getColumns(), columnName);
        if (c != null) {
            return c;
        }
        c = findColumn(getBlobColumns(), columnName);
        if (c != null) {
            return c;
        }
        return null;
    }

    /**
     * Searches for a column of the specified name in the specified collection.
     *
     * @param collection collection of {@link Column} objects
     * @param name       name of the column
     * @return the column or <code>null</code> if the column was not found
     */
    protected static Column findColumn(Collection<Column> collection, String name) {
        Iterator<Column> i = collection.iterator();
        while (i.hasNext()) {
            Column c = i.next();
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TableExpression other = (TableExpression) obj;
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TableExpression [name=" + this.name + "]";
    }

}
