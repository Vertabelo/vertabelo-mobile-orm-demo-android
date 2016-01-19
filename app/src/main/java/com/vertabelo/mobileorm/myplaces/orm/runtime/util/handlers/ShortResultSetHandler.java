package com.vertabelo.mobileorm.myplaces.orm.runtime.util.handlers;

import android.database.Cursor;
import android.database.SQLException;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of every row in cursor into List<Short>.
 */
public class ShortResultSetHandler implements ResultSetHandler<Short> {
    @Override
    public List<Short> getObjects(Cursor cursor) throws SQLException {
        List<Short> ret = new LinkedList<Short>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ret.add(cursor.getShort(0));
            cursor.moveToNext();
        }
        return ret;
    }
}
