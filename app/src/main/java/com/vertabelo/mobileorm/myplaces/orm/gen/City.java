package com.vertabelo.mobileorm.myplaces.orm.gen;

/**
 * POJO representing table city.
 */
public class City implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = 2805257711474326435L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<CityDAO> DAO_INTERFACE_CLASS = CityDAO.class;
    /**
     * Property representing column id
     */
    protected Integer id;
    /**
     * Property representing column country_id
     */
    protected Integer countryId;
    /**
     * Property representing column name
     */
    protected String name;

    /**
     * Default constructor.
     */
    public City() {
    }

    /**
     * All columns constructor.
     * @param id value of column id.
     * @param countryId value of column country_id.
     * @param name value of column name.
     */
    public City(Integer id, Integer countryId, String name) {
        setId(id);
        setCountryId(countryId);
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
     * Returns value of property {@link #countryId}.
     * @return value of property {@link #countryId}.
     */
    public Integer getCountryId() {
        return this.countryId;
    }
    /**
     * Sets new value of property {@link #countryId}.
     * @param countryId new value of property {@link #countryId}.
     */
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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
        City city = (City) o;

        if (id != null ? !id.equals(city.id) : city.id != null) {
            return false;
        }
        if (countryId != null ? !countryId.equals(city.countryId) : city.countryId != null) {
            return false;
        }
        if (name != null ? !name.equals(city.name) : city.name != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{"
                + "id='" + id + '\''
                + ", countryId='" + countryId + '\''
                + ", name='" + name + '\''
                + '}';
    }
}
