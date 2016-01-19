package com.vertabelo.mobileorm.myplaces.orm.gen;

public class PlaceTagDAOImpl
        extends com.vertabelo.mobileorm.myplaces.orm.runtime.dao.BaseDAO<PlaceTag>
        implements PlaceTagDAO {

    public PlaceTagDAOImpl(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource) {
        super(dataSource);
    }

    public PlaceTagDAOImpl(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource,
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.DAOMonitor daoMonitor) {
        super(dataSource, daoMonitor);
    }

    @Override
    public Class<PlaceTag> getPojoClass() {
        return POJO_CLASS;
    }

    @Override
    public com.vertabelo.mobileorm.myplaces.orm.runtime.query.TableExpression getTableExpression() {
        return TABLE_EXPRESSION;
    }

    @Override
    public com.vertabelo.mobileorm.myplaces.orm.runtime.util.ResultSetHandler getResultSetHandler() {
        return RESULT_SET_HANDLER;
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList() {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public PlaceTag getByPlaceIdTagName(Integer placeId, String tagName) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(PLACE_ID.eq(placeId));
        lExps.add(TAG_NAME.eq(tagName));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<PlaceTag> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(Place place) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(PLACE_ID.eq(place.getId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(Place place,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(PLACE_ID.eq(place.getId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(Place place,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(PLACE_ID.eq(place.getId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(Tag tag) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(TAG_NAME.eq(tag.getName()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(Tag tag,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(TAG_NAME.eq(tag.getName()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(Tag tag,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(TAG_NAME.eq(tag.getName()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<PlaceTag> getPlaceTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<PlaceTag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public Long getCount() {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.fun("COUNT",
                        com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.ASTERISK));
        java.util.List<Long> list = select(query, new com.vertabelo.mobileorm.myplaces.orm.runtime.util.handlers.LongResultSetHandler()).getObjectList();
        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new RuntimeException("Cannot retrieve count() method result");
        }
    }

    @Override
    public Long getCount(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.fun("COUNT",
                        com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.ASTERISK));
        query.setWhere(where);
        java.util.List<Long> list = select(query, new com.vertabelo.mobileorm.myplaces.orm.runtime.util.handlers.LongResultSetHandler()).getObjectList();
        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new RuntimeException("Cannot retrieve count() method result");
        }
    }

    @Override
    public long insert(PlaceTag placeTag) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement (TABLE_EXPRESSION);
        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(PLACE_ID, placeTag.getPlaceId());
        values.put(TAG_NAME, placeTag.getTagName());

        query.setValues(values);

        long id = insert(query);


        return id;
    }

    @Override
    public void insert(java.util.Collection<PlaceTag> placeTags) {
        for(PlaceTag obj : placeTags) {
            insert(obj);
        }
    }

    @Override
    public void update(PlaceTag placeTag) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement (TABLE_EXPRESSION);
        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(PLACE_ID, placeTag.getPlaceId());
        values.put(TAG_NAME, placeTag.getTagName());

        query.setValues(values);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(PlaceTagDAO.PLACE_ID,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(placeTag.getPlaceId())));
        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(PlaceTagDAO.TAG_NAME,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(placeTag.getTagName())));
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        update(query);
    }

    @Override
    public void update(java.util.Collection<PlaceTag> placeTags) {
        for(PlaceTag obj : placeTags) {
            update(obj);
        }
    }

    @Override
    public void delete(PlaceTag placeTag) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(PlaceTagDAO.PLACE_ID,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(placeTag.getPlaceId())));
        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(PlaceTagDAO.TAG_NAME,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(placeTag.getTagName())));
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        delete(query);
    }

    @Override
    public void delete(Integer placeId, String tagName) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(PLACE_ID.eq(placeId));
        lExps.add(TAG_NAME.eq(tagName));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);
        delete(query);
    }

    @Override
    public void delete(java.util.Collection<PlaceTag> placeTags) {
        for(PlaceTag obj : placeTags) {
            delete(obj);
        }
    }

    @Override
    public void delete(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        query.setWhere(where);

        delete(query);
    }
}
