package com.vertabelo.mobileorm.myplaces.orm.runtime.util.handlers;

import android.database.Cursor;
import android.database.SQLException;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of every row in cursor into List<java.sql.Date>.
 */
public class DateResultSetHandler implements ResultSetHandler<Date> {
    @Override
    public List<Date> getObjects(Cursor cursor) throws SQLException {
        List<Date> ret = new LinkedList<Date>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ret.add(new Date(cursor.getLong(0)));
            cursor.moveToNext();
        }
        return ret;
    }
}
