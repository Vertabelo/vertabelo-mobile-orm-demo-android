package com.vertabelo.mobileorm.myplaces.orm.gen;

public interface CityDAO extends
        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.DAO<City> {

    /**
     * Table expression class representing table city
     */
    class CityTableExpression extends com.vertabelo.mobileorm.myplaces.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        CityTableExpression() {
            super("city");
            addColumn("id", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.INTEGER, true);
            addColumn("country_id", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.INTEGER, true);
            addColumn("name", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.TEXT, true);
        }
    }

    /**
     * Result set handler class for table city
     */
    class CityResultSetHandler implements
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler<City> {
        @Override
        public java.util.List<City>
                getObjects(android.database.Cursor cursor) {
            java.util.List<City> ret = new java.util.LinkedList<City>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                City obj = new City();
                if (!cursor.isNull(0)) {
                    obj.setId(cursor.getInt(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setCountryId(cursor.getInt(1));
                }
                if (!cursor.isNull(2)) {
                    obj.setName(cursor.getString(2));
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
    Class<City> POJO_CLASS = City.class;
    /**
     * Table expression for the table.
     */
    CityTableExpression TABLE_EXPRESSION = new CityTableExpression();
    /**
     * Result set handler for the table.
     */
    CityResultSetHandler RESULT_SET_HANDLER = new CityResultSetHandler();
    /**
     * Column object representing column id
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column ID = TABLE_EXPRESSION.getColumn("id");
    /**
     * Column object representing column country_id
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column COUNTRY_ID = TABLE_EXPRESSION.getColumn("country_id");
    /**
     * Column object representing column name
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column NAME = TABLE_EXPRESSION.getColumn("name");

    /**
     * Returns all rows from table city
     * @return all rows from table funkcja.
     */
    java.util.List<City> getCityList();

    /**
     * Returns all rows from table city
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<City> getCityList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table city
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<City> getCityList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table city matching given where clause
     * @param where where clause
     * @return all rows from table city matching given where clause
     */
    java.util.List<City> getCityList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table city matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table city matching given where clause
     */
    java.util.List<City> getCityList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table city matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table city matching given where clause
     */
    java.util.List<City> getCityList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table city based on value of primary key
     * @return row from table city
     */
    City getById(Integer id);

    /**
     * Returns row from table city based on value of city_ak_1 key
     */
    City getByCountryIdName(Integer countryId, String name);

    /**
     * Returns list of rows from table city referencing given row from table country
     * @param country object representing row from referenced by rows from table city
     * @return list of rows from table city referencing given row from table country
     */
    java.util.List<City> getCityList(Country country);

    /**
     * Returns list of rows from table city referencing given row from table country
     * @param country object representing row from referenced by rows from table city
     * @param orderBy column to sort by
     * @return list of rows from table city referencing given row from table country
     */
    java.util.List<City> getCityList(Country country, com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns list of rows from table city referencing given row from table country
     * @param country object representing row from referenced by rows from table city
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return list of rows from table city referencing given row from table country
     */
    java.util.List<City> getCityList(Country country, com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table city referenced by given row from table address
     * @param address object representing row referencing row from table address
     * @return row from table city referenced by given row from table address
     */
    City getCity(Address address);

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
     * Inserts row into table city
     * @param city city to be inserted.
     * @return id number of new row
     */
    long insert(City city);

    /**
     * Inserts collection of rows into table city
     * @param citys rows to be inserted
     */
    void insert(java.util.Collection<City> citys);

    /**
     * Updates row in table city
     * @param city city to be updated.
     */
    void update(City city);

    /**
     * Updates collection of rows in table city
     * @param citys rows to be update
     */
    void update(java.util.Collection<City> citys);

    /**
     * Deletes row from table city
     * @param city city to be deleted.
     */
    void delete(City city);

    /**
     * Deletes row from table city based on primary key
     */
    void delete(Integer id);

    /**
     * Deletes collection of rows from table city
     * @param citys rows to be deleted
     */
    void delete(java.util.Collection<City> citys);

    /**
     * Deletes all rows from table city matching given where clause
     * @param where where clause
     */
    void delete(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);
}
