package com.vertabelo.mobileorm.myplaces.orm.gen;

public class DAOProvider {

    /**
     * Data source for this DAOProvider.
     */
    protected com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource;

    /**
     * DAOMonitor for this DAOProvider.
     */
    protected com.vertabelo.mobileorm.myplaces.orm.runtime.util.DAOMonitor daoMonitor;

    /**
     * DAO instance for tableplace
     */
    protected PlaceDAO placeDAO = null;

    /**
     * DAO instance for tableaddress
     */
    protected AddressDAO addressDAO = null;

    /**
     * DAO instance for tabletag
     */
    protected TagDAO tagDAO = null;

    /**
     * DAO instance for tableplace_tag
     */
    protected PlaceTagDAO placeTagDAO = null;

    /**
     * DAO instance for tablecountry
     */
    protected CountryDAO countryDAO = null;

    /**
     * DAO instance for tablecity
     */
    protected CityDAO cityDAO = null;

    /**
     * DAO instance for viewaddress_view
     */
    protected AddressViewDAO addressViewDAO = null;

    /**
     * Constructor.
     * @param dataSource SQLiteDataSource implementation for DAOProvider
     */
    public DAOProvider(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource) {
        this.dataSource = dataSource;
        this.daoMonitor = new com.vertabelo.mobileorm.myplaces.orm.runtime.util.monitors.EmptyDAOMonitor();
    }

    /**
     * Constructor.
     * @param dataSource SQLiteDataSource implementation for DAOProvider
     * @param daoMonitor DAOMonitor implementation for DAOProvider
     */
    public DAOProvider(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.DAOMonitor daoMonitor) {
        this.dataSource = dataSource;
        this.daoMonitor = daoMonitor;
    }

    /**
     * Returns DAO implementation object for table place
     * @return DAO implementation object for table place
     */
    public PlaceDAO getPlaceDAO() {
        if (this.placeDAO == null) {
            this.placeDAO = new PlaceDAOImpl(dataSource, daoMonitor);
        }
        return this.placeDAO;
    }

    /**
     * Returns DAO implementation object for table address
     * @return DAO implementation object for table address
     */
    public AddressDAO getAddressDAO() {
        if (this.addressDAO == null) {
            this.addressDAO = new AddressDAOImpl(dataSource, daoMonitor);
        }
        return this.addressDAO;
    }

    /**
     * Returns DAO implementation object for table tag
     * @return DAO implementation object for table tag
     */
    public TagDAO getTagDAO() {
        if (this.tagDAO == null) {
            this.tagDAO = new TagDAOImpl(dataSource, daoMonitor);
        }
        return this.tagDAO;
    }

    /**
     * Returns DAO implementation object for table place_tag
     * @return DAO implementation object for table place_tag
     */
    public PlaceTagDAO getPlaceTagDAO() {
        if (this.placeTagDAO == null) {
            this.placeTagDAO = new PlaceTagDAOImpl(dataSource, daoMonitor);
        }
        return this.placeTagDAO;
    }

    /**
     * Returns DAO implementation object for table country
     * @return DAO implementation object for table country
     */
    public CountryDAO getCountryDAO() {
        if (this.countryDAO == null) {
            this.countryDAO = new CountryDAOImpl(dataSource, daoMonitor);
        }
        return this.countryDAO;
    }

    /**
     * Returns DAO implementation object for table city
     * @return DAO implementation object for table city
     */
    public CityDAO getCityDAO() {
        if (this.cityDAO == null) {
            this.cityDAO = new CityDAOImpl(dataSource, daoMonitor);
        }
        return this.cityDAO;
    }

    /**
     * Returns DAO implementation object for view address_view
     * @return DAO implementation object for view address_view
     */
    public AddressViewDAO getAddressViewDAO() {
        if (this.addressViewDAO == null) {
            this.addressViewDAO = new AddressViewDAOImpl(dataSource, daoMonitor);
        }
        return this.addressViewDAO;
    }

}
