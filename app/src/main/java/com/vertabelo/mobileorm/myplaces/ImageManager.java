package com.vertabelo.mobileorm.myplaces;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.vertabelo.mobileorm.myplaces.orm.gen.Place;
import com.vertabelo.mobileorm.myplaces.orm.gen.PlaceDAO;

import java.io.ByteArrayOutputStream;

/**
 * Manager for images.
 */
public class ImageManager {

    /**
     * compression rate for .JPG image compression
     */
    protected static final int COMPRESSION_RATE = 15;

    /**
     * max size of image, either height or width
     */
    protected static final int REQUIRED_IMG_SIZE = 300;

    protected final PlaceDAO placeDao;

    public ImageManager(PlaceDAO placeDao) {
        this.placeDao = placeDao;
    }

    public Bitmap getSampledBitmap(byte[] byteArray) {
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, o);

        // Find the correct scale value. It should be the power of 2.
        int scale = 1;
        while (o.outWidth / scale / 2 >= REQUIRED_IMG_SIZE
                && o.outHeight / scale / 2 >= REQUIRED_IMG_SIZE) {
            scale *= 2;
        }

        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, o2);
    }

    public void insertImage(Place place, Drawable image) {
        if (image != null) {
            placeDao.setImage(place, this.getByteArray(image));
        }
    }

    protected byte[] getByteArray(Drawable image) {
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, COMPRESSION_RATE, stream);
        return stream.toByteArray();
    }

    public byte[] getImage(Place place) {
        return placeDao.getImage(place);
    }
}
