package com.vertabelo.mobileorm.myplaces.orm.runtime.util;

import com.vertabelo.mobileorm.myplaces.orm.runtime.dao.DAO;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.Value;

import java.util.List;


/**
 * The DAOMonitor logs information about SQL queries invoked by DAO object.
 */
public interface DAOMonitor {

    /**
     * Callback of <code>SELECT</code> query.
     *
     * @param dao         DAO object
     * @param queryString <code>SQL</code> query
     * @param parameters  <code>SQL</code> query parameters.
     */
    void selectObjectList(DAO<?> dao, String queryString, List<Value> parameters);

    /**
     * Callback of <code>INSERT</code> statement.
     *
     * @param dao             DAO object
     * @param insertStatement <code>SQL</code> insert statement
     * @param parameters      <code>SQL</code> statement parameters.
     */
    void insert(DAO<?> dao, String insertStatement, List<Value> parameters);

    /**
     * Callback of <code>UPDATE</code> statement.
     *
     * @param dao             DAO object
     * @param updateStatement <code>SQL</code> update statement
     * @param parameters      <code>SQL</code> statement parameters
     */
    void update(DAO<?> dao, String updateStatement, List<Value> parameters);

    /**
     * Callback of <code>DELETE</code> statement.
     *
     * @param dao             DAO object
     * @param deleteStatement <code>SQL</code> delete statement
     * @param parameters      <code>SQL</code> statement parameters
     */
    void delete(DAO<?> dao, String deleteStatement, List<Value> parameters);

}
