package com.vertabelo.mobileorm.myplaces.orm.gen;

public interface AddressViewDAO extends
        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.DAO<AddressView> {

    /**
     * Table expression class representing table address_view
     */
    class AddressViewTableExpression extends com.vertabelo.mobileorm.myplaces.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        AddressViewTableExpression() {
            super("address_view");
            addColumn("address_id", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.INTEGER);
            addColumn("address", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.TEXT);
            addColumn("city_name", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.TEXT);
            addColumn("country_name", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.TEXT);
        }
    }

    /**
     * Result set handler class for table address_view
     */
    class AddressViewResultSetHandler implements
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler<AddressView> {
        @Override
        public java.util.List<AddressView>
                getObjects(android.database.Cursor cursor) {
            java.util.List<AddressView> ret = new java.util.LinkedList<AddressView>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                AddressView obj = new AddressView();
                if (!cursor.isNull(0)) {
                    obj.setAddressId(cursor.getInt(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setAddress(cursor.getString(1));
                }
                if (!cursor.isNull(2)) {
                    obj.setCityName(cursor.getString(2));
                }
                if (!cursor.isNull(3)) {
                    obj.setCountryName(cursor.getString(3));
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
    Class<AddressView> POJO_CLASS = AddressView.class;
    /**
     * Table expression for the table.
     */
    AddressViewTableExpression TABLE_EXPRESSION = new AddressViewTableExpression();
    /**
     * Result set handler for the table.
     */
    AddressViewResultSetHandler RESULT_SET_HANDLER = new AddressViewResultSetHandler();
    /**
     * Column object representing column address_id
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column ADDRESS_ID = TABLE_EXPRESSION.getColumn("address_id");
    /**
     * Column object representing column address
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column ADDRESS = TABLE_EXPRESSION.getColumn("address");
    /**
     * Column object representing column city_name
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column CITY_NAME = TABLE_EXPRESSION.getColumn("city_name");
    /**
     * Column object representing column country_name
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column COUNTRY_NAME = TABLE_EXPRESSION.getColumn("country_name");

    /**
     * Returns all rows from table address_view
     * @return all rows from table funkcja.
     */
    java.util.List<AddressView> getAddressViewList();

    /**
     * Returns all rows from table address_view
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<AddressView> getAddressViewList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table address_view
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<AddressView> getAddressViewList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table address_view matching given where clause
     * @param where where clause
     * @return all rows from table address_view matching given where clause
     */
    java.util.List<AddressView> getAddressViewList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table address_view matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table address_view matching given where clause
     */
    java.util.List<AddressView> getAddressViewList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table address_view matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table address_view matching given where clause
     */
    java.util.List<AddressView> getAddressViewList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

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

}
