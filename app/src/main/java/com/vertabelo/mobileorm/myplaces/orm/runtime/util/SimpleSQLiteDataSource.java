package com.vertabelo.mobileorm.myplaces.orm.runtime.util;

import android.database.sqlite.SQLiteDatabase;

/**
 * Simple implementation of the {@link SQLiteDataSource} interface.
 */
public class SimpleSQLiteDataSource implements SQLiteDataSource {

    private SQLiteDatabase database;

    public SimpleSQLiteDataSource(SQLiteDatabase database) {
        this.database = database;
    }

    @Override
    public SQLiteDatabase getSQLiteDatabase() {
        return database;
    }
}
