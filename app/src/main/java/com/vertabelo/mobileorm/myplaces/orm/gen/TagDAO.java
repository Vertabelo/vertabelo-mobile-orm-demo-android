package com.vertabelo.mobileorm.myplaces.orm.gen;

public interface TagDAO extends
        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.DAO<Tag> {

    /**
     * Table expression class representing table tag
     */
    class TagTableExpression extends com.vertabelo.mobileorm.myplaces.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        TagTableExpression() {
            super("tag");
            addColumn("name", com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteType.TEXT, true);
        }
    }

    /**
     * Result set handler class for table tag
     */
    class TagResultSetHandler implements
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler<Tag> {
        @Override
        public java.util.List<Tag>
                getObjects(android.database.Cursor cursor) {
            java.util.List<Tag> ret = new java.util.LinkedList<Tag>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Tag obj = new Tag();
                if (!cursor.isNull(0)) {
                    obj.setName(cursor.getString(0));
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
    Class<Tag> POJO_CLASS = Tag.class;
    /**
     * Table expression for the table.
     */
    TagTableExpression TABLE_EXPRESSION = new TagTableExpression();
    /**
     * Result set handler for the table.
     */
    TagResultSetHandler RESULT_SET_HANDLER = new TagResultSetHandler();
    /**
     * Column object representing column name
     */
    com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column NAME = TABLE_EXPRESSION.getColumn("name");

    /**
     * Returns all rows from table tag
     * @return all rows from table funkcja.
     */
    java.util.List<Tag> getTagList();

    /**
     * Returns all rows from table tag
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<Tag> getTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table tag
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<Tag> getTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table tag matching given where clause
     * @param where where clause
     * @return all rows from table tag matching given where clause
     */
    java.util.List<Tag> getTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table tag matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table tag matching given where clause
     */
    java.util.List<Tag> getTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table tag matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table tag matching given where clause
     */
    java.util.List<Tag> getTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where, 
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table tag based on value of primary key
     * @return row from table tag
     */
    Tag getByName(String name);

    /**
     * Returns row from table tag referenced by given row from table place_tag
     * @param placeTag object representing row referencing row from table place_tag
     * @return row from table tag referenced by given row from table place_tag
     */
    Tag getTag(PlaceTag placeTag);

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
     * Inserts row into table tag
     * @param tag tag to be inserted.
     * @return id number of new row
     */
    long insert(Tag tag);

    /**
     * Inserts collection of rows into table tag
     * @param tags rows to be inserted
     */
    void insert(java.util.Collection<Tag> tags);

    /**
     * Updates row in table tag
     * @param tag tag to be updated.
     */
    void update(Tag tag);

    /**
     * Updates collection of rows in table tag
     * @param tags rows to be update
     */
    void update(java.util.Collection<Tag> tags);

    /**
     * Deletes row from table tag
     * @param tag tag to be deleted.
     */
    void delete(Tag tag);

    /**
     * Deletes row from table tag based on primary key
     */
    void delete(String name);

    /**
     * Deletes collection of rows from table tag
     * @param tags rows to be deleted
     */
    void delete(java.util.Collection<Tag> tags);

    /**
     * Deletes all rows from table tag matching given where clause
     * @param where where clause
     */
    void delete(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where);
}
