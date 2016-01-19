package com.vertabelo.mobileorm.myplaces.orm.runtime.dao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.Value;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.DAOMonitor;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.monitors.EmptyDAOMonitor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * This class provides auxiliary functions used by generated DAO classes.
 */
public abstract class BaseDAO<T> implements DAO<T> {

    /**
     * An object monitoring DAO operations.
     */
    protected DAOMonitor daoMonitor;

    /**
     * Util used to perform database operations.
     */
    protected SQLiteDataSource dataSource;

    /**
     * Constructor.
     *
     * @param dataSource data source used by this DAO object.
     */
    public BaseDAO(SQLiteDataSource dataSource) {
        this(dataSource, new EmptyDAOMonitor());
    }

    /**
     * Constructor.
     *
     * @param dataSource data source used by this DAO object.
     * @param daoMonitor object monitoring this DAO operations.
     */
    public BaseDAO(SQLiteDataSource dataSource, DAOMonitor daoMonitor) {
        setDataSource(dataSource);
        setDAOMonitor(daoMonitor);
    }

    @Override
    public <U> SelectObjectListResult<U> select(SelectQuery query, ResultSetHandler<U> resultSetHandler)
            throws  SQLException {
        StringBuilder sb = new StringBuilder();
        List<Value> parameters = new ArrayList<Value>();

        query.build(sb, parameters);
        String queryString = sb.toString();
        daoMonitor.selectObjectList(this, queryString, parameters);

        SQLiteDatabase database = dataSource.getSQLiteDatabase();
        String[] args = new String[parameters.size()];
        int i = 0;
        for (Value value: parameters) {
            args[i] = value.getValue().toString();
            i++;
        }

        Cursor cursor = database.rawQuery(queryString, args);

        List list = resultSetHandler.getObjects(cursor);

        cursor.close();

        return new SelectObjectListResult<U>(list, queryString, parameters);
    }

    /**
     * Invokes an <code>INSERT</code> statement. The method invokes the specified <code>INSERT</code> statement
     * and logs the operation in an appropriate way.
     *
     * @param insertStatement <code>INSERT</code> statement to run
     * @return the number of rows modified by the statement
     */
    public long insert(InsertStatement insertStatement) throws SQLException {
        StringBuilder sb = new StringBuilder();
        List<Value> parameters = new ArrayList<Value>();

        insertStatement.build(sb, parameters);
        SQLiteStatement statement = prepareStatement(sb.toString(), parameters);

        daoMonitor.insert(this, sb.toString(), parameters);

        return statement.executeInsert();
    }

    /**
     * Invokes an <code>UPDATE</code> statement. The method invokes the specified <code>UPDATE</code> statement
     * and logs the operation in an appropriate way.
     *
     * @param updateStatement <code>UPDATE</code> statement to run
     * @return the number of rows modified by the statement
     */
    public int update(UpdateStatement updateStatement) throws SQLException {
        StringBuilder sb = new StringBuilder();
        List<Value> parameters = new ArrayList<Value>();

        updateStatement.build(sb, parameters);
        SQLiteStatement statement = prepareStatement(sb.toString(), parameters);

        daoMonitor.update(this, sb.toString(), parameters);

        return statement.executeUpdateDelete();
    }

    /**
     * Invokes a <code>DELETE</code> statement. The method invokes the specified <code>DELETE</code> statement
     * and logs the operation in an appropriate way.
     *
     * @param deleteStatement <code>UPDATE</code> statement to run
     * @return the number of rows modified by the statement
     */
    public int delete(DeleteStatement deleteStatement) throws SQLException {
        StringBuilder sb = new StringBuilder();
        List<Value> parameters = new ArrayList<Value>();

        deleteStatement.build(sb, parameters);
        SQLiteStatement statement = prepareStatement(sb.toString(), parameters);

        daoMonitor.delete(this, sb.toString(), parameters);

        return statement.executeUpdateDelete();
    }

    @Override
    public SQLiteDataSource getDataSource() {
        return dataSource;
    }

    /**
     * Sets SQLiteDataSource used by this instance
     * @param dataSource SQLiteDataSource used to perform SQL queries
     */
    public void setDataSource(SQLiteDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public DAOMonitor getDAOMonitor() {
        return daoMonitor;
    }

    /**
     * Sets the DAO monitor used by this DAO object.
     *
     * @param daoMonitor DAO monitor used by this DAO
     */
    public void setDAOMonitor(DAOMonitor daoMonitor) {
        this.daoMonitor = daoMonitor;
    }

    private SQLiteStatement prepareStatement(String statement, List<Value> parameters) {
        SQLiteStatement ret = dataSource.getSQLiteDatabase().compileStatement(statement);

        //arguments in SQLStatements are 1-indexed
        int i = 1;
        for (Iterator<Value> it = parameters.iterator(); it.hasNext(); i++) {
            Value value = it.next();
            Object object = value.getValue();
            if (object == null) {
                ret.bindNull(i);
            } else if (object instanceof String) {
                ret.bindString(i, object.toString());
            } else if (object instanceof Long) {
                ret.bindLong(i, (Long) object);
            } else if (object instanceof Integer) {
                ret.bindLong(i, ((Integer) object).longValue());
            } else if (object instanceof Short) {
                ret.bindLong(i, ((Short) object).longValue());
            } else if (object instanceof Double) {
                ret.bindDouble(i, (Double) object);
            } else if (object instanceof Float) {
                ret.bindDouble(i, ((Float) object).doubleValue());
            } else if (object instanceof BigDecimal) {
                ret.bindString(i, object.toString());
            } else if (object instanceof Boolean) {
                ret.bindLong(i, ((Boolean) object) ? 1 : 0);
            } else if (object instanceof Timestamp) {
                ret.bindLong(i, ((Timestamp) object).getTime());
            } else if (object instanceof Time) {
                ret.bindLong(i, ((Time) object).getTime());
            } else if (object instanceof Date) {
                ret.bindLong(i, ((Date) object).getTime());
            } else if (object instanceof byte[]) {
                ret.bindBlob(i, (byte[]) object);
            } else {
                throw new IllegalStateException("Type not supported.");
            }
        }
        return ret;
    }

    @Override
    public Cursor select(SelectQuery query) {
        StringBuilder sb = new StringBuilder();
        List<Value> parameters = new ArrayList<Value>();

        query.build(sb, parameters);
        String queryString = sb.toString();
        daoMonitor.selectObjectList(this, queryString, parameters);

        SQLiteDatabase database = dataSource.getSQLiteDatabase();
        String[] args = new String[parameters.size()];
        int i = 0;
        for (Value value: parameters) {
            args[i] = value.getValue().toString();
            i++;
        }

        return database.rawQuery(queryString, args);

    }
}
