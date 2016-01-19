package com.vertabelo.mobileorm.myplaces.orm.runtime.dao;

/**
 * Exception thrown when an SQL query returned the number of rows which is not expected.
 * This exception usually indicates an inconsistency between the database schema and
 * the generated DAO objects.
 */
public class QueryFetchException extends RuntimeException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = -153899275059711968L;

    /**
     * Result of the query.
     */
    private SelectObjectListResult<? extends Object> fetchResult;

    /**
     * Constructor.
     * @param message exception message
     * @param fetchResult result of a query.
     */
    public QueryFetchException(String message, SelectObjectListResult<? extends Object> fetchResult) {
        super(message);
        this.fetchResult = fetchResult;
    }

    /**
     * Returns the query result.
     * @return query result.
     */
    public SelectObjectListResult<? extends Object> getFetchResult() {
        return fetchResult;
    }

}
