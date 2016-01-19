package com.vertabelo.mobileorm.myplaces;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ns.developer.tagview.entity.Tag;
import com.ns.developer.tagview.widget.TagCloudLinkView;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for activity_add_edit layout
 */
public abstract class AddEditPlaceActivity extends AppCompatActivity {

    protected static final int SELECT_PICTURE = 1;

    protected boolean imgSet = false;

    /**
     * Add tag onClick event.
     */
    public void addTag(View view) {
        TagCloudLinkView tagView = (TagCloudLinkView) findViewById(R.id.tags);
        invokeAddTagDialog(this, view, tagView);
    }

    /**
     * Add image onClick event.
     */
    public void addImage(View view) {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, SELECT_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SELECT_PICTURE) {
            if (resultCode == RESULT_OK) {
                ImageView img = (ImageView) findViewById(R.id.img);
                this.imgSet = true;
                img.setImageURI(data.getData());
            }
        }
    }

    /**
     * @return info about provided place
     */
    protected PlaceStringDescriptor getPlaceStringDescriptor() {
        TextView nameView = (TextView) findViewById(R.id.name);
        TextView commentView = (TextView) findViewById(R.id.comment);
        TextView addressView = (TextView) findViewById(R.id.address);
        TextView cityView = (TextView) findViewById(R.id.city);
        TextView countryView = (TextView) findViewById(R.id.country);
        ImageView img = (ImageView) findViewById(R.id.img);
        RatingBar rating = (RatingBar) findViewById(R.id.rating_bar);
        TagCloudLinkView tagView = (TagCloudLinkView) findViewById(R.id.tags);
        List<String> tagNames = new ArrayList<>();
        for (Tag t : tagView.getTags()) {
            tagNames.add(t.getText());
        }

        PlaceStringDescriptor placeDescription = new PlaceStringDescriptor();
        placeDescription.setName(nameView.getText().toString().trim());
        placeDescription.setRating(Math.round(rating.getRating()));
        placeDescription.setAddress(addressView.getText().toString().trim());
        placeDescription.setCity(cityView.getText().toString().trim());
        placeDescription.setCountry(countryView.getText().toString().trim());
        placeDescription.setComment(commentView.getText().toString().trim());
        placeDescription.setTags(tagNames);

        if (!placeDescription.validate(this)) {
            return null;
        }

        if (this.imgSet) {
            placeDescription.setImage(img.getDrawable());
        }
        return placeDescription;
    }

    /**
     * Invokes dialog to add tag.
     */
    protected static void invokeAddTagDialog(final Context ctx, View view,
                                          final TagCloudLinkView tagView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("Add tag");

        final EditText input = new EditText(ctx);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String providedTag = input.getText().toString().trim();
                boolean duplicate = false;
                for (Tag t : tagView.getTags()) {
                    if (t.getText().equals(providedTag)) {
                        duplicate = true;
                        break;
                    }
                }

                if (!providedTag.isEmpty() && !duplicate) {
                    tagView.add(new Tag(1, providedTag));
                    tagView.drawTags();
                } else {
                    Toast.makeText(ctx, "Incorrect tag name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
