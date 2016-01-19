package com.vertabelo.mobileorm.myplaces.orm.runtime.dao;

import com.vertabelo.mobileorm.myplaces.orm.runtime.query.Value;

import java.util.List;

/**
 */
public class SelectObjectListResult<T> {

    /**
     * The list of objects returned by the SQL query.
     */
    private List<T> objectList;
    /**
     * The text of the executed SQL query.
     */
    private String queryString;
    /**
     * The list of SQL query parameters.
     */
    private List<Value> parameters;

    /**
     * Constructor.
     *
     * @param objectList list of objects returned by the <code>SELECT</code> query
     * @param queryString text of the <code>SQL</code> query
     * @param parameters <code>SQL</code> query parameters.
     */
    public SelectObjectListResult(List<T> objectList, String queryString, List<Value> parameters) {
        this.objectList = objectList;
        this.queryString = queryString;
        this.parameters = parameters;
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public List<Value> getParameters() {
        return parameters;
    }

    public String getQueryString() {
        return queryString;
    }

}
