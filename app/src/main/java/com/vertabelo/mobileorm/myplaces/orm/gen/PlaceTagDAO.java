package com.vertabelo.mobileorm.myplaces.orm.gen;

public interface PlaceTagDAO extends
        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.DAO<PlaceTag> {

    /**
     * Table expression class representing table place_tag
     */
    class PlaceTagTableExpression extends com.vertabelo.mobileorm.myplaces.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        PlaceTagTableExpression() {
            super("place_tag");
            addColumn("place_id", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.INTEGER, true);
            addColumn("tag_name", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.TEXT, true);
        }
    }

    /**
     * Result set handler class for table place_tag
     */
    class PlaceTagResultSetHandler implements
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler<PlaceTag> {
        @Override
        public java.util.List<PlaceTag>
                getObjects(android.database.Cursor cursor) {
            java.util.List<PlaceTag> ret = new java.util.LinkedList<PlaceTag>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                PlaceTag obj = new PlaceTag();
                if (!cursor.isNull(0)) {
                    obj.setPlaceId(cursor.getInt(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setTagName(cursor.getString(1));
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
    Class<PlaceTag> POJO_CLASS = PlaceTag.class;
    /**
     * Table expression for the table.
     */
    PlaceTagTableExpression TABLE_EXPRESSION = new PlaceTagTableExpression();
    /**
     * Result set handler for the table.
     */
    PlaceTagResultSetHandler RESULT_SET_HANDLER = new PlaceTagResultSetHandler();
    /**
     * Column object representing column place_id
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column PLACE_ID = TABLE_EXPRESSION.getColumn("place_id");
    /**
     * Column object representing column tag_name
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column TAG_NAME = TABLE_EXPRESSION.getColumn("tag_name");

    /**
     * Returns all rows from table place_tag
     * @return all rows from table funkcja.
     */
    java.util.List<PlaceTag> getPlaceTagList();

    /**
     * Returns all rows from table place_tag
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<PlaceTag> getPlaceTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table place_tag
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<PlaceTag> getPlaceTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table place_tag matching given where clause
     * @param where where clause
     * @return all rows from table place_tag matching given where clause
     */
    java.util.List<PlaceTag> getPlaceTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table place_tag matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table place_tag matching given where clause
     */
    java.util.List<PlaceTag> getPlaceTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table place_tag matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table place_tag matching given where clause
     */
    java.util.List<PlaceTag> getPlaceTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table place_tag based on value of primary key
     * @return row from table place_tag
     */
    PlaceTag getByPlaceIdTagName(Integer placeId, String tagName);

    /**
     * Returns list of rows from table place_tag referencing given row from table place
     * @param place object representing row from referenced by rows from table place_tag
     * @return list of rows from table place_tag referencing given row from table place
     */
    java.util.List<PlaceTag> getPlaceTagList(Place place);

    /**
     * Returns list of rows from table place_tag referencing given row from table place
     * @param place object representing row from referenced by rows from table place_tag
     * @param orderBy column to sort by
     * @return list of rows from table place_tag referencing given row from table place
     */
    java.util.List<PlaceTag> getPlaceTagList(Place place, com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns list of rows from table place_tag referencing given row from table place
     * @param place object representing row from referenced by rows from table place_tag
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return list of rows from table place_tag referencing given row from table place
     */
    java.util.List<PlaceTag> getPlaceTagList(Place place, com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns list of rows from table place_tag referencing given row from table tag
     * @param tag object representing row from referenced by rows from table place_tag
     * @return list of rows from table place_tag referencing given row from table tag
     */
    java.util.List<PlaceTag> getPlaceTagList(Tag tag);

    /**
     * Returns list of rows from table place_tag referencing given row from table tag
     * @param tag object representing row from referenced by rows from table place_tag
     * @param orderBy column to sort by
     * @return list of rows from table place_tag referencing given row from table tag
     */
    java.util.List<PlaceTag> getPlaceTagList(Tag tag, com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns list of rows from table place_tag referencing given row from table tag
     * @param tag object representing row from referenced by rows from table place_tag
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return list of rows from table place_tag referencing given row from table tag
     */
    java.util.List<PlaceTag> getPlaceTagList(Tag tag, com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

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
     * Inserts row into table place_tag
     * @param placeTag placeTag to be inserted.
     * @return id number of new row
     */
    long insert(PlaceTag placeTag);

    /**
     * Inserts collection of rows into table place_tag
     * @param placeTags rows to be inserted
     */
    void insert(java.util.Collection<PlaceTag> placeTags);

    /**
     * Updates row in table place_tag
     * @param placeTag placeTag to be updated.
     */
    void update(PlaceTag placeTag);

    /**
     * Updates collection of rows in table place_tag
     * @param placeTags rows to be update
     */
    void update(java.util.Collection<PlaceTag> placeTags);

    /**
     * Deletes row from table place_tag
     * @param placeTag placeTag to be deleted.
     */
    void delete(PlaceTag placeTag);

    /**
     * Deletes row from table place_tag based on primary key
     */
    void delete(Integer placeId, String tagName);

    /**
     * Deletes collection of rows from table place_tag
     * @param placeTags rows to be deleted
     */
    void delete(java.util.Collection<PlaceTag> placeTags);

    /**
     * Deletes all rows from table place_tag matching given where clause
     * @param where where clause
     */
    void delete(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);
}
