package com.vertabelo.mobileorm.myplaces.orm.runtime.util.handlers;

import android.database.Cursor;
import android.database.SQLException;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of every row in cursor into List<Integer>.
 */
public class IntegerResultSetHandler implements ResultSetHandler<Integer> {
    @Override
    public List<Integer> getObjects(Cursor cursor) throws SQLException {
        List<Integer> ret = new LinkedList<Integer>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ret.add(cursor.getInt(0));
            cursor.moveToNext();
        }
        return ret;
    }
}
