package com.vertabelo.mobileorm.myplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;


import com.ns.developer.tagview.entity.Tag;
import com.ns.developer.tagview.widget.TagCloudLinkView;
import com.vertabelo.mobileorm.myplaces.orm.gen.AddressView;
import com.vertabelo.mobileorm.myplaces.orm.gen.Place;

import java.util.List;

/**
 * Activity to show the details of the place.
 */
public class DetailsActivity extends AppCompatActivity {

    protected static final int EDIT = 1;

    protected PlaceManager placeManager;
    protected TagManager tagManager;
    protected AddressManager addressManager;
    protected ImageManager imageManager;

    protected Place place;
    
    // byte array to store photo
    protected byte[] imgByteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.placeManager = MyPlacesApplication.getPlaceManager();
        this.tagManager = MyPlacesApplication.getTagManager();
        this.addressManager = MyPlacesApplication.getAddressManager();
        this.imageManager = MyPlacesApplication.getImageManager();

        if (this.place == null) {
            this.place = (Place) getIntent().getSerializableExtra(getString(R.string.object_intent_key));
        }

        setContentView(R.layout.activity_details);

        if (this.place != null) {
            setDataIntoTextViews();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.details_delete) {
            this.placeManager.deletePlace(this.place);
            finish();
        } else if (id == R.id.details_edit) {
            Intent edit = new Intent(DetailsActivity.this, EditPlaceActivity.class);
            edit.putExtra(getString(R.string.object_intent_key), this.place);
            edit.putExtra(getString(R.string.img_intent_key), this.imgByteArray);
            startActivityForResult(edit, EDIT);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDIT) {
            if (resultCode == RESULT_OK) {
                this.place = (Place) data.getSerializableExtra(getString(R.string.object_intent_key));
                setDataIntoTextViews();
            }
        }
    }

    protected void setDataIntoTextViews() {
        TextView nameView = (TextView) findViewById(R.id.details_name);
        TextView addedView = (TextView) findViewById(R.id.details_added);
        TextView addressView = (TextView) findViewById(R.id.details_address);
        TextView commentView = (TextView) findViewById(R.id.details_comment);

        nameView.setText(this.place.getName());
        addedView.setText(this.place.getAdded().toString());

        AddressView address = this.addressManager.getAddressView(this.place);
        if (address != null) {
            String addressText = address.getAddress();
            if (addressText == null || addressText.isEmpty()) {
                addressText = getString(R.string.blank);
            } else {
                addressText += ", ";
            }
            addressView.setText(addressText + address.getCityName() + ", " + address.getCountryName());
        }
        
        commentView.setText(this.place.getComment());

        RatingBar rating = (RatingBar) findViewById(R.id.details_rating_bar);
        rating.setRating(this.place.getRating());

        printTags();
        setImage();
    }

    /**
     * Get tags for a place from database and print them to the view.
     */
    protected void printTags() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.details_tags_layout);
        List<String> tags = this.tagManager.getTags(this.place);

        if (tags == null || tags.isEmpty()) {
            layout.setVisibility(View.GONE);
        } else {
            layout.setVisibility(View.VISIBLE);

            TagCloudLinkView view = (TagCloudLinkView) findViewById(R.id.details_tags);
            view.getTags().clear();
            for (String tag : tags) {
                view.add(new Tag(1, tag));
            }
            view.drawTags();
        }
    }

    /**
     * Sets image for a view.
     */
    protected void setImage() {
        ImageView img = (ImageView) findViewById(R.id.image_view);
        this.imgByteArray = this.imageManager.getImage(this.place);

        if (this.imgByteArray != null) {
            img.setImageBitmap(this.imageManager.getSampledBitmap(this.imgByteArray));
        } else {
            img.setVisibility(View.GONE);
        }
    }
}
