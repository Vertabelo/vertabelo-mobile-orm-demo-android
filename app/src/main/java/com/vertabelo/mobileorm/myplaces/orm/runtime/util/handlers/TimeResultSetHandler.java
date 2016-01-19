package com.vertabelo.mobileorm.myplaces.orm.runtime.util.handlers;

import android.database.Cursor;
import android.database.SQLException;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler;

import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of every row in cursor into List<java.sql.Time>.
 */
public class TimeResultSetHandler implements ResultSetHandler<Time> {
    @Override
    public List<Time> getObjects(Cursor cursor) throws SQLException {
        List<Time> ret = new LinkedList<Time>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ret.add(new Time(cursor.getLong(0)));
            cursor.moveToNext();
        }
        return ret;
    }
}
