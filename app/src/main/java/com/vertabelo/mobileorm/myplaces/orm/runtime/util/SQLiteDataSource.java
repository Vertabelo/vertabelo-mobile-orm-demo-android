package com.vertabelo.mobileorm.myplaces.orm.runtime.util;

import android.database.sqlite.SQLiteDatabase;

/**
 * Used to obtain SQLite database to operate on.
 */
public interface SQLiteDataSource {

    SQLiteDatabase getSQLiteDatabase();

}
