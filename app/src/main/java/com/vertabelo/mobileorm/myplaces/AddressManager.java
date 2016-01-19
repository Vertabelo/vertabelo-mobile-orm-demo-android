package com.vertabelo.mobileorm.myplaces;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.vertabelo.mobileorm.myplaces.orm.gen.Address;
import com.vertabelo.mobileorm.myplaces.orm.gen.AddressDAO;
import com.vertabelo.mobileorm.myplaces.orm.gen.AddressView;
import com.vertabelo.mobileorm.myplaces.orm.gen.AddressViewDAO;
import com.vertabelo.mobileorm.myplaces.orm.gen.City;
import com.vertabelo.mobileorm.myplaces.orm.gen.CityDAO;
import com.vertabelo.mobileorm.myplaces.orm.gen.Country;
import com.vertabelo.mobileorm.myplaces.orm.gen.CountryDAO;
import com.vertabelo.mobileorm.myplaces.orm.gen.Place;

import java.util.ArrayList;
import java.util.List;

/**
 *  Manager for addresses.
 */
public class AddressManager {
    
    protected final SQLiteDatabase db;

    protected final AddressDAO addressDao;
    protected final CityDAO cityDao;
    protected final CountryDAO countryDao;
    protected final AddressViewDAO addressViewDao;

    public AddressManager(SQLiteDatabase db, AddressDAO addressDao, CityDAO cityDao,
                          CountryDAO countryDao, AddressViewDAO addressViewDao) {
        this.db = db;
        this.addressDao = addressDao;
        this.cityDao = cityDao;
        this.countryDao = countryDao;
        this.addressViewDao = addressViewDao;
    }

    public Integer insertAddress(PlaceStringDescriptor placeDescription) {
        Address address = new Address();
        address.setAddress(placeDescription.getAddress());
        address.setCityId(this.insertCity(placeDescription));
        this.addressDao.insert(address);
        return address.getId();
    }

    /**
     * @return list of country names
     */
    public List<String> getCountryStringList() {
        List<Country> countryList = this.countryDao.getCountryList();
        List<String> lst = new ArrayList<>(countryList.size());
        for (Country country : countryList) {
            lst.add(country.getName());
        }
        return lst;
    }

    /**
     * @return list of city names in given country
     */
    public List<String> getCityStringList(String countryName) {
        List<City> cityList = this.cityDao.getCityList(this.countryDao.getByName(countryName));
        List<String> result = new ArrayList<>(cityList.size());
        for (City city : cityList) {
            result.add(city.getName());
        }
        return result;
    }

    /**
     * @return list of address names in given city
     */
    public List<String> getAddressStringList(String city, String country) {
        List<AddressView> addressViewList = this.addressViewDao.getAddressViewList(
                AddressViewDAO.CITY_NAME.eq(city).and(AddressViewDAO.COUNTRY_NAME.eq(country)));

        List<String> result = new ArrayList<>(addressViewList.size());
        for (AddressView addressView : addressViewList) {
            result.add(addressView.getAddress());
        }
        return result;
    }

    public AddressView getAddressView(Place place) {
        List<AddressView> addressList = addressViewDao.getAddressViewList(
                AddressViewDAO.ADDRESS_ID.eq(place.getAddressId()));

        if (addressList == null || addressList.isEmpty()) {
            return null;
        } else {
            return addressList.get(0);
        }
    }

    public void deleteAddress(Place place) {
        Address address = this.addressDao.getAddress(place);
        this.addressDao.delete(address);
        this.deleteCityIfNotUsed(address.getCityId());
    }

    public void updateAddress(Place place, PlaceStringDescriptor placeDescription) {
        Address address = this.addressDao.getAddress(place);
        AddressView addressView = this.getAddressView(place);

        Integer oldCityId = address.getCityId();
        if (!addressView.getCountryName().equals(placeDescription.getCountry())
                || !addressView.getCityName().equals(placeDescription.getCity())) {
            address.setCityId(this.insertCity(placeDescription));
        }

        address.setAddress(placeDescription.getAddress());
        addressDao.update(address);

        if (!address.getCityId().equals(oldCityId)) {
            this.deleteCityIfNotUsed(oldCityId);
        }
    }

    /**
     * Deletes city if there is no address using it. If there is no other city in given city's country,
     * the country will also be deleted.
     */
    protected void deleteCityIfNotUsed(Integer cityId) {
        this.db.beginTransaction();
        try {
            Long cityUsage = this.addressDao.getCount(AddressDAO.CITY_ID.eq(cityId));
            Log.e("usuwanie", "sprawdzamy czy ktos uzywa");
            if (cityUsage.equals(0L)) {
                Log.e("usuwanie", "nikt nie uzywa miasta nara");
                Integer countryId = this.cityDao.getById(cityId).getCountryId();
                this.cityDao.delete(cityId);
                deleteCountryIfNotUsed(countryId);
            }
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    /**
     * Deletes country if there is no city using it.
     */
    protected void deleteCountryIfNotUsed(Integer countryId) {
        Long countryUsage = this.cityDao.getCount(CityDAO.COUNTRY_ID.eq(countryId));
        if (countryUsage.equals(0L)) {
            Log.e("usuwanie", "nikt nie uzywa panstwa nara");
            this.countryDao.delete(countryId);
        }
    }

    /**
     * Inserts city if it does not exist and returns its id.
     * If city exists, its id is returned.
     */
    protected Integer insertCity(PlaceStringDescriptor placeDescription) {
        Integer countryId = this.insertCountry(placeDescription.getCountry());
        City city = this.cityDao.getByCountryIdName(countryId, placeDescription.getCity());

        // if city does not exist in database - add it
        if (city == null) {
            city = new City();
            city.setName(placeDescription.getCity());
            city.setCountryId(countryId);
            this.cityDao.insert(city);
        }

        return city.getId();
    }

    /**
     * Inserts country if it does not exist and returns its id.
     * If country exists, its id is returned.
     */
    protected Integer insertCountry(String countryName) {
        Country country = this.countryDao.getByName(countryName);

        // if country does not exist in database - add it
        if (country == null) {
            country = new Country();
            country.setName(countryName);
            this.countryDao.insert(country);
        }

        return country.getId();
    }
}
