package com.vertabelo.mobileorm.myplaces.orm.runtime.util.handlers;

import android.database.Cursor;
import android.database.SQLException;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of every row in cursor into List<java.sql.Timestamp>.
 */
public class TimestampResultSetHandler implements ResultSetHandler<Timestamp> {
    @Override
    public List<Timestamp> getObjects(Cursor cursor) throws SQLException {
        List<Timestamp> ret = new LinkedList<Timestamp>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ret.add(new Timestamp(cursor.getLong(0)));
            cursor.moveToNext();
        }
        return ret;
    }
}
