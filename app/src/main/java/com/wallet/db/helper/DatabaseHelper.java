package com.wallet.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.wallet.R;
import com.wallet.db.enums.EnumDaoAndModelMapping;
import com.wallet.db.model.Model;

import java.sql.SQLException;
import java.util.List;

/**
 * Database helper which creates and upgrades the database and provides the DAOs for the app.
 *
 * @author Cengiz Ünlü
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    /************************************************
     * Suggested Copy/Paste code. Everything from here to the done block.
     ************************************************/

    private static final String DATABASE_NAME = "click.db";
    private static final int DATABASE_VERSION = 6;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    /************************************************
     * Suggested Copy/Paste Done
     ************************************************/

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
        try {
            List<Class> modelList = EnumDaoAndModelMapping.getAllModelClass();
            for (Class model :modelList) {
                TableUtils.createTable(connectionSource, model);
            }
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Unable to create datbases", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
        try {
            List<Class> modelList = EnumDaoAndModelMapping.getAllModelClass();
            for (Class model :modelList) {
                TableUtils.dropTable(connectionSource, model, true);
            }
            onCreate(sqliteDatabase, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + oldVer + " to new "
                    + newVer, e);
        }
    }

    public  Object getDaoObject(Class<? extends Model> modelClass) throws SQLException{
        Class daoClass = EnumDaoAndModelMapping.getDaoClass(modelClass);
        if (daoClass!=null){
            return getDao(daoClass);
        }
        return null;
    }
}