package com.wallet.activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.wallet.R;
import com.wallet.db.helper.DatabaseHelper;
import com.wallet.db.model.ClickCount;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Testing out the TodoOrmLiteExample app by creating some Todo entries in the database,
     * and querying for all the Todo object from the todo table.
     * @throws SQLException
     */
    private void testOutOrmLiteDatabase() throws SQLException {
        DatabaseHelper todoOpenDatabaseHelper = OpenHelperManager.getHelper(this,
                DatabaseHelper.class);

        Dao<ClickCount, Integer> todoDao = todoOpenDatabaseHelper.getClickDao();

        Date currDateTime = new Date(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currDateTime);
        calendar.add(Calendar.DATE, 14);

        Date dueDate = calendar.getTime();

//        todoDao.create(new ClickCount("Todo Example 1", "Todo Example 1 Description", currDateTime, dueDate));
  //      todoDao.create(new ClickCount("Todo Example 2", "Todo Example 2 Description", currDateTime, dueDate));
    //    todoDao.create(new ClickCount("Todo Example 3", "Todo Example 3 Description", currDateTime, dueDate));

        List<ClickCount> todos = todoDao.queryForAll();
    }
}
