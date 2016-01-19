package com.vertabelo.mobileorm.myplaces;

/**
 * State of filter.
 */
public class FilteringState {

    // all ratings shown by default
    protected int ratingFrom = 1;
    protected int ratingTo = 5;

    // names to filter
    protected String filterTag;
    protected String filterCountry;
    protected String filterCity;
    protected String filterAddress;

    public int getRatingTo() {
        return ratingTo;
    }

    public void setRatingTo(int ratingTo) {
        this.ratingTo = ratingTo;
    }

    public int getRatingFrom() {
        return ratingFrom;
    }

    public void setRatingFrom(int ratingFrom) {
        this.ratingFrom = ratingFrom;
    }

    public String getFilterTag() {
        return filterTag;
    }

    public void setFilterTag(String filterTag) {
        this.filterTag = filterTag;
    }

    public String getFilterCountry() {
        return filterCountry;
    }

    public void setFilterCountry(String filterCountry) {
        this.filterCountry = filterCountry;
    }

    public String getFilterCity() {
        return filterCity;
    }

    public void setFilterCity(String filterCity) {
        this.filterCity = filterCity;
    }

    public String getFilterAddress() {
        return filterAddress;
    }

    public void setFilterAddress(String filterAddress) {
        this.filterAddress = filterAddress;
    }

    public void reset() {
        this.ratingFrom = 1;
        this.ratingTo = 5;
        this.filterTag = null;
        this.filterCountry = null;
        this.filterCity = null;
        this.filterAddress = null;
    }
}
