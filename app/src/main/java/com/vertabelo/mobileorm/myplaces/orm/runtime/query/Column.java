package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType;

import java.util.List;

/**
 * Represents a column of a table expression.
 */
public class Column extends AExp {

    /**
     * Table expression this column belongs to.
     */
    protected TableExpression owner;

    /**
     * Name of the column.
     */
    protected String name;

    /**
     * SQLite type of the column.
     */
    protected SQLiteType type;

    /**
     * Whether it's a part of the primary key.
     */
    protected boolean primaryKey;

    /**
     * Constructor. Adds column which is not a part of the primary key to its owner column set.
     *
     * @param owner table expression this column belongs to
     * @param name  name of the column
     * @param type  SQLite type of the column
     */
    public Column(TableExpression owner, String name, SQLiteType type) {
        this(owner, name, type, false);
    }

    /**
     * Constructor. Adds column which is not a part of the primary key to its owner column set.
     *
     * @param owner table expression this column belongs to
     * @param name  name of the column
     * @param type  SQLite type of the column
     * @param primaryKey whether it's a part of the primary key
     */
    public Column(TableExpression owner, String name, SQLiteType type, boolean primaryKey) {
        setName(name);
        setType(type);
        setOwner(owner);
        setPrimaryKey(primaryKey);
    }

    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        this.owner.build(sb, objs);
        sb.append(DOT);
        sb.append(getName());
    }

    /**
     * Returns the value of the {@link #type} field.
     *
     * @return value of the {@link #type} field
     */
    public SQLiteType getType() {
        return this.type;
    }

    /**
     * Sets the value of  the {@link #type} field.
     *
     * @param type value of the {@link #type} field
     */
    public void setType(SQLiteType type) {
        this.type = type;
    }

    /**
     * Return the value of the {@link #name} field
     *
     * @return value of the {@link #name} field
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the value of the {@link #name} field
     *
     * @param name value of the {@link #name} field
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the value of the {@link #owner} field
     *
     * @return value of the {@link #owner} field
     */
    public TableExpression getOwner() {
        return this.owner;
    }

    /**
     * Sets the value of the {@link #owner}
     *
     * @param owner value of the {@link #owner}
     */
    public void setOwner(TableExpression owner) {
        this.owner = owner;
    }

    /**
     * Checks if it's a part of the primary key.
     *
     * @return true if it's a part of the primary key.
     */
    public boolean isPrimaryKey() {
        return primaryKey;
    }

    /**
     * Sets if it's a part of the primary key
     *
     * @param primaryKey true if it's a primary key column
     */
    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    /**
     * Returns a string representation of the object. The representation
     * consists of the value of the field "name".
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Column column = (Column) o;

        if (!owner.equals(column.owner)) {
            return false;
        }
        if (!name.equals(column.name)) {
            return false;
        }
        return type == column.type;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
