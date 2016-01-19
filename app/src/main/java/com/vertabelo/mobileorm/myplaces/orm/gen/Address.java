package com.vertabelo.mobileorm.myplaces.orm.gen;

/**
 * POJO representing table address.
 */
public class Address implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = 7942001638268552772L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<AddressDAO> DAO_INTERFACE_CLASS = AddressDAO.class;
    /**
     * Property representing column id
     */
    protected Integer id;
    /**
     * Property representing column city_id
     */
    protected Integer cityId;
    /**
     * Property representing column address
     */
    protected String address;

    /**
     * Default constructor.
     */
    public Address() {
    }

    /**
     * All columns constructor.
     * @param id value of column id.
     * @param cityId value of column city_id.
     * @param address value of column address.
     */
    public Address(Integer id, Integer cityId, String address) {
        setId(id);
        setCityId(cityId);
        setAddress(address);
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
     * Returns value of property {@link #cityId}.
     * @return value of property {@link #cityId}.
     */
    public Integer getCityId() {
        return this.cityId;
    }
    /**
     * Sets new value of property {@link #cityId}.
     * @param cityId new value of property {@link #cityId}.
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    /**
     * Returns value of property {@link #address}.
     * @return value of property {@link #address}.
     */
    public String getAddress() {
        return this.address;
    }
    /**
     * Sets new value of property {@link #address}.
     * @param address new value of property {@link #address}.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;

        if (id != null ? !id.equals(address.id) : address.id != null) {
            return false;
        }
        if (cityId != null ? !cityId.equals(address.cityId) : address.cityId != null) {
            return false;
        }
        if (address != null ? !address.equals(address.address) : address.address != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{"
                + "id='" + id + '\''
                + ", cityId='" + cityId + '\''
                + ", address='" + address + '\''
                + '}';
    }
}
