package com.vertabelo.mobileorm.myplaces.orm.gen;

/**
 * POJO representing table tag.
 */
public class Tag implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = 6304057705426653504L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<TagDAO> DAO_INTERFACE_CLASS = TagDAO.class;
    /**
     * Property representing column name
     */
    protected String name;

    /**
     * Default constructor.
     */
    public Tag() {
    }

    /**
     * All columns constructor.
     * @param name value of column name.
     */
    public Tag(String name) {
        setName(name);
    }

    /**
     * Returns value of property {@link #name}.
     * @return value of property {@link #name}.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Sets new value of property {@link #name}.
     * @param name new value of property {@link #name}.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tag tag = (Tag) o;

        if (name != null ? !name.equals(tag.name) : tag.name != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tag{"
                + "name='" + name + '\''
                + '}';
    }
}
