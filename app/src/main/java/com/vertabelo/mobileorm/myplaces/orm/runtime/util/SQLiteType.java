package com.vertabelo.mobileorm.myplaces.orm.runtime.util;

/**
 * Represents SQLite datatype, according to sqlite.org
 */
public enum SQLiteType {
    TEXT,
    NUMERIC,
    INTEGER,
    REAL,
    NONE;

    /**
     * Given name of Returns proper SQLite type.
     *
     * @param input name of input type
     * @return assigned SQLite type
     */
    public static SQLiteType getSQLiteType(String input) {
        input = input.toLowerCase();

        if (input.matches(".*int.*")) {
            return INTEGER;
        } else if (input.matches(".*(char|clob|text).*")) {
            return TEXT;
        } else if (input.matches(".*blob.*") || input.isEmpty()) {
            return NONE;
        } else if (input.matches(".*(real|floa|doub).*")) {
            return REAL;
        } else {
            return NUMERIC;
        }
    }
}
