package com.vertabelo.mobileorm.myplaces.orm.runtime.util.monitors;

import com.vertabelo.mobileorm.myplaces.orm.runtime.dao.DAO;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.Value;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.DAOMonitor;

import java.util.List;

/**
 * DAO monitor which does not log any information.
 */
public class EmptyDAOMonitor implements DAOMonitor {

    /**
     * Constructor.
     */
    public EmptyDAOMonitor() { }

    @Override
    public void delete(DAO<?> dao, String deleteStatement, List<Value> parameters) {
    }

    @Override
    public void insert(DAO<?> dao, String insertStatement, List<Value> parameters) {
    }

    @Override
    public void selectObjectList(DAO<?> dao, String queryString, List<Value> parameters) {
    }

    @Override
    public void update(DAO<?> dao, String updateStatement, List<Value> parameters) {
    }

}
