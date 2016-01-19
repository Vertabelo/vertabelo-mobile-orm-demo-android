package com.vertabelo.mobileorm.myplaces;

import android.database.sqlite.SQLiteDatabase;

import com.vertabelo.mobileorm.myplaces.orm.gen.AddressViewDAO;
import com.vertabelo.mobileorm.myplaces.orm.gen.Place;
import com.vertabelo.mobileorm.myplaces.orm.gen.PlaceDAO;
import com.vertabelo.mobileorm.myplaces.orm.gen.PlaceTagDAO;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery;

import java.sql.Timestamp;
import java.util.List;

/**
 * Manager for Place objects.
 */
public class PlaceManager {

    protected final SQLiteDatabase db;

    protected final PlaceDAO placeDao;

    protected final AddressManager addressManager;
    protected final ImageManager imageManager;
    protected final TagManager tagManager;

    public PlaceManager(SQLiteDatabase db, PlaceDAO placeDao, AddressManager addressManager,
                        ImageManager imageManager, TagManager tagManager) {
        this.db = db;
        this.placeDao = placeDao;
        this.addressManager = addressManager;
        this.imageManager = imageManager;
        this.tagManager = tagManager;
    }

    public void insertPlace(PlaceStringDescriptor placeDescription) {
        this.db.beginTransaction();
        try {
            Place place = convert(placeDescription);

            this.placeDao.insert(place);
            this.imageManager.insertImage(place, placeDescription.getImage());
            this.tagManager.insertTags(place, placeDescription.getTags());

            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    /**
     * Deletes place and everything used by it that is not used anywhere else
     * @param place place to deletePlace
     */
    public void deletePlace(Place place) {

        this.db.beginTransaction();

        try {
            placeDao.delete(place);
            this.addressManager.deleteAddress(place);
            this.tagManager.deleteTags(place);

            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    /**
     * Updates place according to info provided in placeDescription.
     * Method cleans database after updatePlace, deleting all entries that will not be used anymore.
     * @param place place in initial state
     * @param placeDescription info about updated place
     * @return updated place
     */
    public Place updatePlace(Place place, PlaceStringDescriptor placeDescription) {
        this.db.beginTransaction();
        try {

            place.setName(placeDescription.getName());
            place.setRating(placeDescription.getRating());
            place.setComment(placeDescription.getComment());
            placeDao.update(place);

            this.addressManager.updateAddress(place, placeDescription);
            this.tagManager.updateTags(place, placeDescription.getTags());

            if (placeDescription.getImage() != null) {
                this.imageManager.insertImage(place, placeDescription.getImage());
            }

            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }

        return place;
    }

    /**
     * updates adapter with current data in database, filters it and sorts it according to managers
     */
    public List<Place> getPlacesList(FilteringState filtering, SortingState sorting) {
        return this.placeDao.getPlaceList(
                this.getFilter(filtering),
                sorting.getSortingColumn(),
                sorting.getSortingDirection());
    }


    protected Place convert(PlaceStringDescriptor placeDescription) {
        Place place = new Place();

        place.setName(placeDescription.getName());
        place.setAddressId(this.addressManager.insertAddress(placeDescription));
        place.setRating(placeDescription.getRating());
        place.setComment(placeDescription.getComment());
        place.setAdded(new Timestamp(new java.util.Date().getTime()));

        return place;
    }

    /**
     * Converts filtering state to one logical expression.
     */
    protected LExp getFilter(FilteringState filtering) {

        // address filters
        String country = filtering.getFilterCountry();
        String city = filtering.getFilterCity();
        String address = filtering.getFilterAddress();

        SelectQuery addressQuery = new SelectQuery(AddressViewDAO.TABLE_EXPRESSION,
                AddressViewDAO.ADDRESS_ID);

        LExp queryFilter = LExp.TRUE;
        if (country != null && !country.isEmpty()) {
            queryFilter = AddressViewDAO.COUNTRY_NAME.eq(country);

            if (city != null && !city.isEmpty()) {
                queryFilter = queryFilter.and(AddressViewDAO.CITY_NAME.eq(city));

                if (address != null && !address.isEmpty()) {
                    queryFilter = queryFilter.and(AddressViewDAO.ADDRESS.eq(address));
                }
            }
        }
        addressQuery.setWhere(queryFilter);
        LExp addressFilter = LExp.in(PlaceDAO.ADDRESS_ID, addressQuery);

        // tag filters
        String tag = filtering.getFilterTag();

        LExp tagFilter = LExp.TRUE;
        if (tag != null && !tag.isEmpty()) {
            SelectQuery tagQuery = new SelectQuery(PlaceTagDAO.TABLE_EXPRESSION, PlaceTagDAO.PLACE_ID);
            tagQuery.setWhere(PlaceTagDAO.TAG_NAME.eq(tag));
            tagFilter = LExp.in(PlaceDAO.ID, tagQuery);
        }

        // rating filters
        LExp ratingFilter = PlaceDAO.RATING.ge(filtering.getRatingFrom())
                .and(PlaceDAO.RATING.le(filtering.getRatingTo()));

        return addressFilter.and(tagFilter).and(ratingFilter);
    }
}
