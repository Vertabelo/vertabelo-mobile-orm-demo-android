package com.vertabelo.mobileorm.myplaces;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import java.util.List;

/**
 * Container for place's description provided by the user.
 */
public class PlaceStringDescriptor {

    protected String name;
    protected Integer rating;
    protected String address;
    protected String city;
    protected String country;
    protected String comment;
    protected List<String> tags;
    protected Drawable image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Drawable getImage() {
        return this.image;
    }

    public void setImage(Drawable drawable) {
        this.image = drawable;
    }

    public boolean validate(Context ctx) {
        if (this.name == null || this.name.isEmpty()) {
            validationToast(ctx, R.string.place_toast);
            return false;
        }

        if (this.city == null || this.city.isEmpty()) {
            validationToast(ctx, R.string.city_toast);
            return false;
        }

        if (this.country == null || this.country.isEmpty()) {
            validationToast(ctx, R.string.country_toast);
            return false;
        }

        if (this.rating == 0) {
            validationToast(ctx, R.string.rating_toast);
            return false;
        }

        return true;
    }

    protected void validationToast(Context ctx, Integer resId) {
        Toast.makeText(ctx, "You did not enter a " + ctx.getString(resId),
                Toast.LENGTH_SHORT).show();
    }
}
