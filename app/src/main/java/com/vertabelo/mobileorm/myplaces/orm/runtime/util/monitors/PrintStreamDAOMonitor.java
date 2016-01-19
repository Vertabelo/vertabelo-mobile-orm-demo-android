package com.vertabelo.mobileorm.myplaces.orm.runtime.util.monitors;

import com.vertabelo.mobileorm.myplaces.orm.runtime.dao.DAO;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.Value;
import com.vertabelo.mobileorm.myplaces.orm.runtime.util.DAOMonitor;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

/**
 * DAO monitor which logs information to the specified {@link PrintStream} object.
 */
public class PrintStreamDAOMonitor implements DAOMonitor {

    /**
     * Strumień, do którego piszemy.
     */
    private PrintStream printStream;


    /**
     * Constructor. This monitor logs infomation to the specified PrintStream object
     * @param printStream {@link PrintStream} object to which this monitor logs information
     */
    public PrintStreamDAOMonitor(PrintStream printStream) {
        this.printStream = printStream;
    }

    /**
     * Logs the given information
     * @param dao DAO object for which we log info
     * @param info info string
     * @param parameters query parameters
     */
    private void log(DAO<?> dao, String info, String statement, List<Value> parameters) {
        printStream.println(info + statement);
        printlnValueList(parameters);

    }

    @Override
    public void delete(DAO<?> dao, String deleteStatement, List<Value> parameters) {
        log(dao, "delete statement: ", deleteStatement, parameters);
    }

    @Override
    public void insert(DAO<?> dao, String insertStatement, List<Value> parameters) {
        log(dao, "insert statement: ", insertStatement, parameters);
    }

    @Override
    public void selectObjectList(DAO<?> dao, String queryString, List<Value> parameters) {
        log(dao, "query string: ", queryString, parameters);
    }

    @Override
    public void update(DAO<?> dao, String updateStatement, List<Value> parameters) {
        log(dao, "update statement: ", updateStatement, parameters);
    }

    /**
     * Prints the specified list of parameters.
     * @param parameters the list of parameters
     */
    private void printlnValueList(List<Value> parameters) {
        int index = 1;
        Iterator<Value> i = parameters.iterator();
        while (i.hasNext()) {
            Value value = i.next();
            printStream.println("parameter #" + index + ": \"" + value.getValue());
            index++;
        }
    }

}
