package com.vertabelo.mobileorm.myplaces.orm.gen;

/**
 * POJO representing table country.
 */
public class Country implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = -3154212203145686547L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<CountryDAO> DAO_INTERFACE_CLASS = CountryDAO.class;
    /**
     * Property representing column id
     */
    protected Integer id;
    /**
     * Property representing column name
     */
    protected String name;

    /**
     * Default constructor.
     */
    public Country() {
    }

    /**
     * All columns constructor.
     * @param id value of column id.
     * @param name value of column name.
     */
    public Country(Integer id, String name) {
        setId(id);
        setName(name);
    }

    /**
     * Returns value of property {@link #id}.
     * @return value of property {@link #id}.
     */
    public Integer getId() {
        return this.id;
    }
    /**
     * Sets new value of property {@link #id}.
     * @param id new value of property {@link #id}.
     */
    public void setId(Integer id) {
        this.id = id;
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
        Country country = (Country) o;

        if (id != null ? !id.equals(country.id) : country.id != null) {
            return false;
        }
        if (name != null ? !name.equals(country.name) : country.name != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + '}';
    }
}
