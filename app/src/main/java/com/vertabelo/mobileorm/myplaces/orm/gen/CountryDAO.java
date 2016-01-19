package com.vertabelo.mobileorm.myplaces.orm.gen;

public interface CountryDAO extends
        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.DAO<Country> {

    /**
     * Table expression class representing table country
     */
    class CountryTableExpression extends com.vertabelo.mobileorm.myplaces.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        CountryTableExpression() {
            super("country");
            addColumn("id", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.INTEGER, true);
            addColumn("name", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.TEXT, true);
        }
    }

    /**
     * Result set handler class for table country
     */
    class CountryResultSetHandler implements
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler<Country> {
        @Override
        public java.util.List<Country>
                getObjects(android.database.Cursor cursor) {
            java.util.List<Country> ret = new java.util.LinkedList<Country>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Country obj = new Country();
                if (!cursor.isNull(0)) {
                    obj.setId(cursor.getInt(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setName(cursor.getString(1));
                }
                ret.add(obj);
                cursor.moveToNext();
            }
            return ret;
        }
    }

    /**
     * Corresponding POJO class.
     */
    Class<Country> POJO_CLASS = Country.class;
    /**
     * Table expression for the table.
     */
    CountryTableExpression TABLE_EXPRESSION = new CountryTableExpression();
    /**
     * Result set handler for the table.
     */
    CountryResultSetHandler RESULT_SET_HANDLER = new CountryResultSetHandler();
    /**
     * Column object representing column id
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column ID = TABLE_EXPRESSION.getColumn("id");
    /**
     * Column object representing column name
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column NAME = TABLE_EXPRESSION.getColumn("name");

    /**
     * Returns all rows from table country
     * @return all rows from table funkcja.
     */
    java.util.List<Country> getCountryList();

    /**
     * Returns all rows from table country
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<Country> getCountryList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table country
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<Country> getCountryList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table country matching given where clause
     * @param where where clause
     * @return all rows from table country matching given where clause
     */
    java.util.List<Country> getCountryList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table country matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table country matching given where clause
     */
    java.util.List<Country> getCountryList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table country matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table country matching given where clause
     */
    java.util.List<Country> getCountryList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table country based on value of primary key
     * @return row from table country
     */
    Country getById(Integer id);

    /**
     * Returns row from table country based on value of name key
     */
    Country getByName(String name);

    /**
     * Returns row from table country referenced by given row from table city
     * @param city object representing row referencing row from table city
     * @return row from table country referenced by given row from table city
     */
    Country getCountry(City city);

    /**
     * Returns number of all rows in table.
     * @return number of all rows in table
     */
    Long getCount();

    /**
     * Returns number of rows according to given WHERE query.
     * @param where where query
     * @return number of rows
     */
    Long getCount(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);

    /**
     * Inserts row into table country
     * @param country country to be inserted.
     * @return id number of new row
     */
    long insert(Country country);

    /**
     * Inserts collection of rows into table country
     * @param countrys rows to be inserted
     */
    void insert(java.util.Collection<Country> countrys);

    /**
     * Updates row in table country
     * @param country country to be updated.
     */
    void update(Country country);

    /**
     * Updates collection of rows in table country
     * @param countrys rows to be update
     */
    void update(java.util.Collection<Country> countrys);

    /**
     * Deletes row from table country
     * @param country country to be deleted.
     */
    void delete(Country country);

    /**
     * Deletes row from table country based on primary key
     */
    void delete(Integer id);

    /**
     * Deletes collection of rows from table country
     * @param countrys rows to be deleted
     */
    void delete(java.util.Collection<Country> countrys);

    /**
     * Deletes all rows from table country matching given where clause
     * @param where where clause
     */
    void delete(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);
}
