package com.vertabelo.mobileorm.myplaces.orm.runtime.util;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Simple implementation of {@link android.database.sqlite.SQLiteOpenHelper} used to perform creation and upgrades of
 * SQLite database according to scripts given as android resource IDs. To specify which scripts should be executed on
 * creation or upgrade time {@link #configure()} method should be implemented.
 *
 * Note that create and upgrade script files mustn't contain any semicolons at the ends of lines except for those
 * separating single statements, e.g. create, alter or insert.
 */
public abstract class SimpleSQLiteOpenHelper extends SQLiteOpenHelper implements SQLiteDataSource   {

    private Context context;

    private List<Integer> creationScripts = new LinkedList<Integer>();

    private Map<Integer, List<Integer>> migrationScripts = new HashMap<Integer, List<Integer>>();

    public SimpleSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version,
                                  DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.context = context;
        configure();
    }

    public SimpleSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
        configure();
    }

    public SimpleSQLiteOpenHelper(Context context, String name, int version) {
        this(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (Integer id : creationScripts) {
            for (String statement : parseFile(id)) {
                db.execSQL(statement);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int i = oldVersion; i < newVersion; i++) {
            List<Integer> scripts = migrationScripts.get(i);
            if (scripts != null) {
                for (Integer id : scripts) {
                    for (String statement : parseFile(id)) {
                        db.execSQL(statement);
                    }
                }
            }
        }
    }

    @Override
    public SQLiteDatabase getSQLiteDatabase() {
        return this.getWritableDatabase();
    }

    /**
     * Specifies methods executed on creation or upgrade time.
     *
     * @see #addCreationScript(Integer)
     * @see #addMigrationScript(Integer, Integer)
     */
    public abstract void configure();

    /**
     * Adds id of resource to the list of SQL scripts executed in {@link #onCreate(SQLiteDatabase)} method
     *
     * @param resourceId android resorurce ID, the resource must be put in res/raw directory
     */
    public void addCreationScript(Integer resourceId) {
        creationScripts.add(resourceId);
    }

    /**
     * Adds id of resource to the list of SQL scripts executed in {@link #onUpgrade(SQLiteDatabase, int, int)}} method.
     * Scripts should perform migrations incrementally, from version {@code fromVersion} to version
     * {@code fromVersion} + 1
     *
     * @param fromVersion numer of version which the migration is from
     * @param resourceId android resorurce ID, the resource must be put in res/raw directory
     */
    public void addMigrationScript(Integer fromVersion, Integer resourceId) {
        if (migrationScripts.get(fromVersion) == null) {
            migrationScripts.put(fromVersion, new LinkedList<Integer>());
        }
        migrationScripts.get(fromVersion).add(resourceId);
    }

    /**
     * Parses SQL script into simgle operations separated with semicolons.
     *
     * @param resourceId id of the resource put in res/raw directory
     * @return array of single SQL statements
     */
    private String[] parseFile(Integer resourceId) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(this.context.getResources().openRawResource(resourceId), "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Charset UTF-8 not supported.", ex);
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
                line = bufferedReader.readLine();
            }
            String[] ret = stringBuilder.toString().split(";\n", -1);
            return Arrays.copyOf(ret, ret.length - 1);
        } catch (IOException ex) {
            throw new RuntimeException("Cannot parse given SQL script file.", ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Log.e("MobiORM", "Error when closing BufferedReader.");
            }
        }
    }
}
