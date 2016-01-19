package com.vertabelo.mobileorm.myplaces.orm.gen;

/**
 * POJO representing table address_view.
 */
public class AddressView implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = -17367224602343670L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<AddressViewDAO> DAO_INTERFACE_CLASS = AddressViewDAO.class;
    /**
     * Property representing column address_id
     */
    protected Integer addressId;
    /**
     * Property representing column address
     */
    protected String address;
    /**
     * Property representing column city_name
     */
    protected String cityName;
    /**
     * Property representing column country_name
     */
    protected String countryName;

    /**
     * Default constructor.
     */
    public AddressView() {
    }

    /**
     * All columns constructor.
     * @param addressId value of column address_id.
     * @param address value of column address.
     * @param cityName value of column city_name.
     * @param countryName value of column country_name.
     */
    public AddressView(Integer addressId, String address, String cityName, String countryName) {
        setAddressId(addressId);
        setAddress(address);
        setCityName(cityName);
        setCountryName(countryName);
    }

    /**
     * Returns value of property {@link #addressId}.
     * @return value of property {@link #addressId}.
     */
    public Integer getAddressId() {
        return this.addressId;
    }
    /**
     * Sets new value of property {@link #addressId}.
     * @param addressId new value of property {@link #addressId}.
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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
    /**
     * Returns value of property {@link #cityName}.
     * @return value of property {@link #cityName}.
     */
    public String getCityName() {
        return this.cityName;
    }
    /**
     * Sets new value of property {@link #cityName}.
     * @param cityName new value of property {@link #cityName}.
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    /**
     * Returns value of property {@link #countryName}.
     * @return value of property {@link #countryName}.
     */
    public String getCountryName() {
        return this.countryName;
    }
    /**
     * Sets new value of property {@link #countryName}.
     * @param countryName new value of property {@link #countryName}.
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddressView addressView = (AddressView) o;

        if (addressId != null ? !addressId.equals(addressView.addressId) : addressView.addressId != null) {
            return false;
        }
        if (address != null ? !address.equals(addressView.address) : addressView.address != null) {
            return false;
        }
        if (cityName != null ? !cityName.equals(addressView.cityName) : addressView.cityName != null) {
            return false;
        }
        if (countryName != null ? !countryName.equals(addressView.countryName) : addressView.countryName != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddressView{"
                + "addressId='" + addressId + '\''
                + ", address='" + address + '\''
                + ", cityName='" + cityName + '\''
                + ", countryName='" + countryName + '\''
                + '}';
    }
}
