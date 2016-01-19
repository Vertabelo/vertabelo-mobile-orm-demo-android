package com.vertabelo.mobileorm.myplaces.orm.runtime.util.handlers;

import android.database.Cursor;
import android.database.SQLException;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of every row in cursor into List<byte[]>.
 */
public class ByteArrayResultSetHandler implements ResultSetHandler<byte[]> {
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
