package com.vertabelo.mobileorm.myplaces.orm.gen;

public interface AddressDAO extends
        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.DAO<Address> {

    /**
     * Table expression class representing table address
     */
    class AddressTableExpression extends com.vertabelo.mobileorm.myplaces.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        AddressTableExpression() {
            super("address");
            addColumn("id", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.INTEGER, true);
            addColumn("city_id", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.INTEGER, true);
            addColumn("address", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.TEXT, true);
        }
    }

    /**
     * Result set handler class for table address
     */
    class AddressResultSetHandler implements
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler<Address> {
        @Override
        public java.util.List<Address>
                getObjects(android.database.Cursor cursor) {
            java.util.List<Address> ret = new java.util.LinkedList<Address>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Address obj = new Address();
                if (!cursor.isNull(0)) {
                    obj.setId(cursor.getInt(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setCityId(cursor.getInt(1));
                }
                if (!cursor.isNull(2)) {
                    obj.setAddress(cursor.getString(2));
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
    Class<Address> POJO_CLASS = Address.class;
    /**
     * Table expression for the table.
     */
    AddressTableExpression TABLE_EXPRESSION = new AddressTableExpression();
    /**
     * Result set handler for the table.
     */
    AddressResultSetHandler RESULT_SET_HANDLER = new AddressResultSetHandler();
    /**
     * Column object representing column id
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column ID = TABLE_EXPRESSION.getColumn("id");
    /**
     * Column object representing column city_id
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column CITY_ID = TABLE_EXPRESSION.getColumn("city_id");
    /**
     * Column object representing column address
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column ADDRESS = TABLE_EXPRESSION.getColumn("address");

    /**
     * Returns all rows from table address
     * @return all rows from table funkcja.
     */
    java.util.List<Address> getAddressList();

    /**
     * Returns all rows from table address
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<Address> getAddressList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table address
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<Address> getAddressList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table address matching given where clause
     * @param where where clause
     * @return all rows from table address matching given where clause
     */
    java.util.List<Address> getAddressList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table address matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table address matching given where clause
     */
    java.util.List<Address> getAddressList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table address matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table address matching given where clause
     */
    java.util.List<Address> getAddressList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table address based on value of primary key
     * @return row from table address
     */
    Address getById(Integer id);

    /**
     * Returns list of rows from table address referencing given row from table city
     * @param city object representing row from referenced by rows from table address
     * @return list of rows from table address referencing given row from table city
     */
    java.util.List<Address> getAddressList(City city);

    /**
     * Returns list of rows from table address referencing given row from table city
     * @param city object representing row from referenced by rows from table address
     * @param orderBy column to sort by
     * @return list of rows from table address referencing given row from table city
     */
    java.util.List<Address> getAddressList(City city, com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns list of rows from table address referencing given row from table city
     * @param city object representing row from referenced by rows from table address
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return list of rows from table address referencing given row from table city
     */
    java.util.List<Address> getAddressList(City city, com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table address referenced by given row from table place
     * @param place object representing row referencing row from table place
     * @return row from table address referenced by given row from table place
     */
    Address getAddress(Place place);

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
     * Inserts row into table address
     * @param address address to be inserted.
     * @return id number of new row
     */
    long insert(Address address);

    /**
     * Inserts collection of rows into table address
     * @param addresss rows to be inserted
     */
    void insert(java.util.Collection<Address> addresss);

    /**
     * Updates row in table address
     * @param address address to be updated.
     */
    void update(Address address);

    /**
     * Updates collection of rows in table address
     * @param addresss rows to be update
     */
    void update(java.util.Collection<Address> addresss);

    /**
     * Deletes row from table address
     * @param address address to be deleted.
     */
    void delete(Address address);

    /**
     * Deletes row from table address based on primary key
     */
    void delete(Integer id);

    /**
     * Deletes collection of rows from table address
     * @param addresss rows to be deleted
     */
    void delete(java.util.Collection<Address> addresss);

    /**
     * Deletes all rows from table address matching given where clause
     * @param where where clause
     */
    void delete(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);
}
