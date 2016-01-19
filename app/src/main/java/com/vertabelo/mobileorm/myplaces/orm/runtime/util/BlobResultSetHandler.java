package com.vertabelo.mobileorm.myplaces.orm.runtime.util;

import android.database.Cursor;
import android.database.SQLException;

import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of cursor into list of byte arrays.
 */
public class BlobResultSetHandler implements ResultSetHandler<byte[]> {

    public BlobResultSetHandler() {
    }

    @Override
    public List<byte[]> getObjects(Cursor cursor) throws SQLException {
        List<byte[]> ret = new LinkedList<byte[]>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ret.add(cursor.getBlob(0));
            cursor.moveToNext();
        }
        return ret;
    }
}
