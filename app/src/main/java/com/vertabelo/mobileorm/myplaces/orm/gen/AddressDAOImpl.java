package com.vertabelo.mobileorm.myplaces.orm.gen;

public class AddressDAOImpl
        extends com.vertabelo.mobileorm.myplaces.orm.runtime.dao.BaseDAO<Address>
        implements AddressDAO {

    public AddressDAOImpl(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource) {
        super(dataSource);
    }

    public AddressDAOImpl(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource,
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.DAOMonitor daoMonitor) {
        super(dataSource, daoMonitor);
    }

    @Override
    public Class<Address> getPojoClass() {
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
    public java.util.List<Address> getAddressList() {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Address>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Address> getAddressList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Address>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Address> getAddressList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Address>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public Address getById(Integer id) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(ID.eq(id));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Address> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Address getAddress(Place place) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(ID.eq(place.getAddressId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Address> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public java.util.List<Address> getAddressList(City city) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(CITY_ID.eq(city.getId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Address>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Address> getAddressList(City city,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(CITY_ID.eq(city.getId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Address>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Address> getAddressList(City city,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(CITY_ID.eq(city.getId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Address>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Address> getAddressList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Address>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Address> getAddressList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Address>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Address> getAddressList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Address>
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
    public long insert(Address address) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement (TABLE_EXPRESSION);
        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(ID, address.getId());
        values.put(CITY_ID, address.getCityId());
        values.put(ADDRESS, address.getAddress());

        query.setValues(values);

        long id = insert(query);

        address.setId(new Long(id).intValue());

        return id;
    }

    @Override
    public void insert(java.util.Collection<Address> addresss) {
        for(Address obj : addresss) {
            insert(obj);
        }
    }

    @Override
    public void update(Address address) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement (TABLE_EXPRESSION);
        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(ID, address.getId());
        values.put(CITY_ID, address.getCityId());
        values.put(ADDRESS, address.getAddress());

        query.setValues(values);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(AddressDAO.ID,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(address.getId())));
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        update(query);
    }

    @Override
    public void update(java.util.Collection<Address> addresss) {
        for(Address obj : addresss) {
            update(obj);
        }
    }

    @Override
    public void delete(Address address) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(AddressDAO.ID,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(address.getId())));
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
    public void delete(java.util.Collection<Address> addresss) {
        for(Address obj : addresss) {
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
