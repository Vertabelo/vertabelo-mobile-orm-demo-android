package com.vertabelo.mobileorm.myplaces.orm.runtime.util.handlers;

import android.database.Cursor;
import android.database.SQLException;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of every row in cursor into List<BigDecimal>.
 */
public class BigDecimalResultSetHandler implements ResultSetHandler<BigDecimal> {
    @Override
    public List<BigDecimal> getObjects(Cursor cursor) throws SQLException {
        List<BigDecimal> ret = new LinkedList<BigDecimal>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ret.add(new BigDecimal(cursor.getString(0)));
            cursor.moveToNext();
        }
        return ret;
    }
}
