package com.vertabelo.mobileorm.myplaces.orm.gen;

public class CountryDAOImpl
        extends com.vertabelo.mobileorm.myplaces.orm.runtime.dao.BaseDAO<Country>
        implements CountryDAO {

    public CountryDAOImpl(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource) {
        super(dataSource);
    }

    public CountryDAOImpl(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource,
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.DAOMonitor daoMonitor) {
        super(dataSource, daoMonitor);
    }

    @Override
    public Class<Country> getPojoClass() {
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
    public java.util.List<Country> getCountryList() {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Country>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Country> getCountryList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Country>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Country> getCountryList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Country>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public Country getById(Integer id) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(ID.eq(id));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Country> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Country getByName(String name) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(NAME.eq(name));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Country> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Country getCountry(City city) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(ID.eq(city.getCountryId()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Country> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public java.util.List<Country> getCountryList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Country>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Country> getCountryList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Country>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Country> getCountryList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Country>
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
    public long insert(Country country) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement (TABLE_EXPRESSION);
        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(ID, country.getId());
        values.put(NAME, country.getName());

        query.setValues(values);

        long id = insert(query);

        country.setId(new Long(id).intValue());

        return id;
    }

    @Override
    public void insert(java.util.Collection<Country> countrys) {
        for(Country obj : countrys) {
            insert(obj);
        }
    }

    @Override
    public void update(Country country) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement (TABLE_EXPRESSION);
        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(ID, country.getId());
        values.put(NAME, country.getName());

        query.setValues(values);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(CountryDAO.ID,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(country.getId())));
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        update(query);
    }

    @Override
    public void update(java.util.Collection<Country> countrys) {
        for(Country obj : countrys) {
            update(obj);
        }
    }

    @Override
    public void delete(Country country) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(CountryDAO.ID,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(country.getId())));
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
    public void delete(java.util.Collection<Country> countrys) {
        for(Country obj : countrys) {
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
