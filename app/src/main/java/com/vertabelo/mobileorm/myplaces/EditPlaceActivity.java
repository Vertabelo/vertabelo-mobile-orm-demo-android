package com.vertabelo.mobileorm.myplaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ns.developer.tagview.entity.Tag;
import com.ns.developer.tagview.widget.TagCloudLinkView;
import com.vertabelo.mobileorm.myplaces.orm.gen.AddressView;
import com.vertabelo.mobileorm.myplaces.orm.gen.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity to edit place.
 */
public class EditPlaceActivity extends AddEditPlaceActivity {

    protected PlaceManager placeManager;
    protected TagManager tagManager;
    protected AddressManager addressManager;
    protected ImageManager imageManager;

    protected List<String> initialTags = new ArrayList<>();
    protected Place editedPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.placeManager = MyPlacesApplication.getPlaceManager();
        this.tagManager = MyPlacesApplication.getTagManager();
        this.addressManager = MyPlacesApplication.getAddressManager();
        this.imageManager = MyPlacesApplication.getImageManager();

        this.editedPlace = (Place) getIntent().getSerializableExtra("object");

        setContentView(R.layout.activity_add_edit);

        TextView nameView = (TextView) findViewById(R.id.name);
        TextView addressView = (TextView) findViewById(R.id.address);
        TextView cityView = (TextView) findViewById(R.id.city);
        TextView countryView = (TextView) findViewById(R.id.country);
        TextView commentView = (TextView) findViewById(R.id.comment);
        nameView.requestFocus();

        Button btn = (Button) findViewById(R.id.button);
        btn.setText(R.string.ok_button);

        nameView.setText(this.editedPlace.getName());

        AddressView addressViewObject = this.addressManager.getAddressView(this.editedPlace);

        if (addressViewObject != null) {
            addressView.setText(addressViewObject.getAddress());
            cityView.setText(addressViewObject.getCityName());
            countryView.setText(addressViewObject.getCountryName());
        }

        commentView.setText(this.editedPlace.getComment());
        RatingBar rating = (RatingBar) findViewById(R.id.rating_bar);
        rating.setRating(this.editedPlace.getRating());

        printTags();
        setImage();
    }

    /**
     * OK button onClick event.
     * Updates place in database according to data provided by user.
     * @param v
     */
    public void confirmChanges(View v) {
        PlaceStringDescriptor placeDescription = this.getPlaceStringDescriptor();
        if (placeDescription != null) {
            Place place = this.placeManager.updatePlace(
                    (Place) getIntent().getSerializableExtra("object"), placeDescription);

            Intent intent = new Intent();
            intent.putExtra("object", place);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    /**
     * Get tags for a place from database and print them to the view.
     */
    protected void printTags() {
        final TagCloudLinkView view = (TagCloudLinkView) findViewById(R.id.tags);
        view.setOnTagDeleteListener(new TagCloudLinkView.OnTagDeleteListener() {
            @Override
            public void onTagDeleted(Tag tag, int i) {
            }
        });

        List<String> tags = this.tagManager.getTags(this.editedPlace);
        for (String tag : tags) {
            view.add(new Tag(1, tag));
            this.initialTags.add(tag);
        }
        view.drawTags();
    }

    /**
     * Sets image for a view.
     */
    protected void setImage() {
        byte[] bytesImg = getIntent().getByteArrayExtra(getString(R.string.img_intent_key));
        if (bytesImg != null && bytesImg.length > 0) {
            ImageView img = (ImageView) findViewById(R.id.img);
            img.setImageBitmap(this.imageManager.getSampledBitmap(bytesImg));
        }
    }
}
