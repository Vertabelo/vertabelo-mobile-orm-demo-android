package com.vertabelo.mobileorm.myplaces.orm.gen;

public class PlaceDAOImpl
        extends com.vertabelo.mobileorm.myplaces.orm.runtime.dao.BaseDAO<Place>
        implements PlaceDAO {

    public PlaceDAOImpl(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource) {
        super(dataSource);
    }

    public PlaceDAOImpl(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource,
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.DAOMonitor daoMonitor) {
        super(dataSource, daoMonitor);
    }

    @Override
    public Class<Place> getPojoClass() {
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
    public java.util.List<Place> getPlaceList() {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Place>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Place> getPlaceList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Place>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Place> getPlaceList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Place>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public Place getById(Integer id) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(ID.eq(id));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Place> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Place getPlace(PlaceTag placeTag) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(ID.eq(placeTag.getPlaceId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Place> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Place getPlace(Address address) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(ADDRESS_ID.eq(address.getId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Place> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public java.util.List<Place> getPlaceList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Place>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Place> getPlaceList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Place>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Place> getPlaceList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Place>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public byte[] getImage(Place place) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION, IMAGE);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(ID.eq(place.getId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);
        java.util.List<byte[]> list = select(query, new com.vertabelo.mobileorm.myplaces.orm.runtime.util.BlobResultSetHandler()).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void setImage(Place place, byte[] blob) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement(TABLE_EXPRESSION);

        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(IMAGE, blob);
        query.setValues(values);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(PlaceDAO.ID,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(place.getId())));
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        update(query);
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
    public long insert(Place place) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement (TABLE_EXPRESSION);
        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(ID, place.getId());
        values.put(NAME, place.getName());
        values.put(ADDRESS_ID, place.getAddressId());
        values.put(RATING, place.getRating());
        values.put(ADDED, place.getAdded());
        values.put(COMMENT, place.getComment());

        values.put(IMAGE, null);
        query.setValues(values);

        long id = insert(query);

        place.setId(new Long(id).intValue());

        return id;
    }

    @Override
    public void insert(java.util.Collection<Place> places) {
        for(Place obj : places) {
            insert(obj);
        }
    }

    @Override
    public void update(Place place) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement (TABLE_EXPRESSION);
        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(ID, place.getId());
        values.put(NAME, place.getName());
        values.put(ADDRESS_ID, place.getAddressId());
        values.put(RATING, place.getRating());
        values.put(ADDED, place.getAdded());
        values.put(COMMENT, place.getComment());

        query.setValues(values);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(PlaceDAO.ID,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(place.getId())));
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        update(query);
    }

    @Override
    public void update(java.util.Collection<Place> places) {
        for(Place obj : places) {
            update(obj);
        }
    }

    @Override
    public void delete(Place place) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(PlaceDAO.ID,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(place.getId())));
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        delete(query);
    }

    @Override
    public void delete(Integer id) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(ID.eq(id));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);
        delete(query);
    }

    @Override
    public void delete(java.util.Collection<Place> places) {
        for(Place obj : places) {
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
