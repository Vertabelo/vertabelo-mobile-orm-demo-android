package com.vertabelo.mobileorm.myplaces.orm.runtime.util;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Implementation of {@link SQLiteDataSource} using {@link android.database.sqlite.SQLiteOpenHelper}.
 */
public class SQLiteOpenHelperDataSource implements SQLiteDataSource {

    private SQLiteOpenHelper helper;

    public SQLiteOpenHelperDataSource(SQLiteOpenHelper helper) {
        this.helper = helper;
    }

    @Override
    public SQLiteDatabase getSQLiteDatabase() {
        return helper.getWritableDatabase();
    }
}
