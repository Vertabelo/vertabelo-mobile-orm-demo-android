package com.vertabelo.mobileorm.myplaces;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.vertabelo.mobileorm.myplaces.orm.gen.DAOProvider;

/**
 * Extension of Application to store database and managers inside.
 */
public class MyPlacesApplication extends Application {

    protected static SQLiteDatabase db;
    protected static AddressManager addressManager;
    protected static ImageManager imageManager;
    protected static PlaceManager placeManager;
    protected static TagManager tagManager;

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseOpenHelper helper = new DatabaseOpenHelper(this);
        DAOProvider provider = new DAOProvider(helper);

        db = helper.getWritableDatabase();
        addressManager = new AddressManager(db, provider.getAddressDAO(),
                provider.getCityDAO(), provider.getCountryDAO(), provider.getAddressViewDAO());
        imageManager = new ImageManager(provider.getPlaceDAO());
        tagManager = new TagManager(provider.getTagDAO(), provider.getPlaceTagDAO());
        placeManager = new PlaceManager(db, provider.getPlaceDAO(),
                addressManager, imageManager, tagManager);
    }

    public static SQLiteDatabase getDb() {
        return db;
    }

    public static AddressManager getAddressManager() {
        return addressManager;
    }

    public static ImageManager getImageManager() {
        return imageManager;
    }

    public static PlaceManager getPlaceManager() {
        return placeManager;
    }

    public static TagManager getTagManager() {
        return tagManager;
    }
}
