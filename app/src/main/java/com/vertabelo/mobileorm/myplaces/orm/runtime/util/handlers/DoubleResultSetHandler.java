package com.vertabelo.mobileorm.myplaces.orm.runtime.util.handlers;

import android.database.Cursor;
import android.database.SQLException;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of every row in cursor into List<Double>.
 */
public class DoubleResultSetHandler implements ResultSetHandler<Double> {
    @Override
    public List<Double> getObjects(Cursor cursor) throws SQLException {
        List<Double> ret = new LinkedList<Double>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ret.add(cursor.getDouble(0));
            cursor.moveToNext();
        }
        return ret;
    }
}
