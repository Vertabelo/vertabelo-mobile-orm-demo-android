package com.vertabelo.mobileorm.myplaces;

import com.vertabelo.mobileorm.myplaces.orm.gen.PlaceDAO;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection;

/**
 * Manager for sorting list view.
 */
public class SortingState {

    // sorted descending by added timestamp by default
    protected Column sortingColumn = PlaceDAO.ADDED;
    protected OrderByDirection sortingDirection = OrderByDirection.DESC;

    public Column getSortingColumn() {
        return sortingColumn;
    }

    public void setSortingColumn(Column sortingColumn) {
        this.sortingColumn = sortingColumn;
    }

    public OrderByDirection getSortingDirection() {
        return sortingDirection;
    }

    public void setSortingDirection(OrderByDirection sortingDirection) {
        this.sortingDirection = sortingDirection;
    }

    public void setSorting(Column column, OrderByDirection direction) {
        this.sortingColumn = column;
        this.sortingDirection = direction;
    }

}
