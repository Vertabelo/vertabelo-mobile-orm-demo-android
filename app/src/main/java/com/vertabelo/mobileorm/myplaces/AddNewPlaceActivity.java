package com.vertabelo.mobileorm.myplaces;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ns.developer.tagview.entity.Tag;
import com.ns.developer.tagview.widget.TagCloudLinkView;

/**
 * Activity to add new places.
 */
public class AddNewPlaceActivity extends AddEditPlaceActivity {

    protected PlaceManager placeManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.placeManager = MyPlacesApplication.getPlaceManager();

        setContentView(R.layout.activity_add_edit);

        Button btn = (Button) findViewById(R.id.button);
        btn.setText(R.string.button_add_place);
        final TagCloudLinkView view = (TagCloudLinkView) findViewById(R.id.tags);
        view.setOnTagDeleteListener(new TagCloudLinkView.OnTagDeleteListener() {
            @Override
            public void onTagDeleted(Tag tag, int i) { }
        });
        view.drawTags();
    }

    /**
     * OK button onClick event.
     * Inserts place into database according to data provided by user.
     */
    public void confirmChanges(View v) {
        PlaceStringDescriptor placeDescription = getPlaceStringDescriptor();
        if (placeDescription != null) {
            this.placeManager.insertPlace(placeDescription);
            finish();
        }
    }


}


