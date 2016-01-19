package com.vertabelo.mobileorm.myplaces.orm.gen;

public class TagDAOImpl
        extends com.vertabelo.mobileorm.myplaces.orm.runtime.dao.BaseDAO<Tag>
        implements TagDAO {

    public TagDAOImpl(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource) {
        super(dataSource);
    }

    public TagDAOImpl(com.vertabelo.mobileorm.myplaces.orm.runtime.util.SQLiteDataSource dataSource,
            com.vertabelo.mobileorm.myplaces.orm.runtime.util.DAOMonitor daoMonitor) {
        super(dataSource, daoMonitor);
    }

    @Override
    public Class<Tag> getPojoClass() {
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
    public java.util.List<Tag> getTagList() {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Tag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Tag> getTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Tag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Tag> getTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Tag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public Tag getByName(String name) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(NAME.eq(name));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Tag> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Tag getTag(PlaceTag placeTag) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(NAME.eq(placeTag.getTagName()));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Tag> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public java.util.List<Tag> getTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Tag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Tag> getTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Tag>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Tag> getTagList(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where,
            com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp orderBy, com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection asc) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy, asc);

        com.vertabelo.mobileorm.myplaces.orm.runtime.dao.SelectObjectListResult<Tag>
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
    public long insert(Tag tag) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.InsertStatement (TABLE_EXPRESSION);
        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(NAME, tag.getName());

        query.setValues(values);

        long id = insert(query);


        return id;
    }

    @Override
    public void insert(java.util.Collection<Tag> tags) {
        for(Tag obj : tags) {
            insert(obj);
        }
    }

    @Override
    public void update(Tag tag) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.UpdateStatement (TABLE_EXPRESSION);
        java.util.Map<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column, Object>();

        values.put(NAME, tag.getName());

        query.setValues(values);

        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(TagDAO.NAME,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(tag.getName())));
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        update(query);
    }

    @Override
    public void update(java.util.Collection<Tag> tags) {
        for(Tag obj : tags) {
            update(obj);
        }
    }

    @Override
    public void delete(Tag tag) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.eq(TagDAO.NAME,
                com.vertabelo.mobileorm.myplaces.orm.runtime.query.AExp.exp(tag.getName())));
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        delete(query);
    }

    @Override
    public void delete(String name) {
        com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement query =
                new com.vertabelo.mobileorm.myplaces.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp>();

        lExps.add(NAME.eq(name));

        com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp where = com.vertabelo.mobileorm.myplaces.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);
        delete(query);
    }

    @Override
    public void delete(java.util.Collection<Tag> tags) {
        for(Tag obj : tags) {
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
