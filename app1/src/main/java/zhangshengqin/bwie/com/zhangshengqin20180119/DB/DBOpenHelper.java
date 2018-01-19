package zhangshengqin.bwie.com.zhangshengqin20180119.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 额头发 on 2018/1/19.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "eric.db";

    private static final int VERSION = 1;



    public DBOpenHelper(Context context) {

        super(context, DBNAME, null, VERSION);

    }



    @Override

    public void onCreate(SQLiteDatabase db) {

        // 创建filedownlog表

        db.execSQL("CREATE TABLE IF NOT EXISTS filedownlog (id integer primary key autoincrement, downpath varchar(100), threadid INTEGER, downlength INTEGER)");

    }



    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS filedownlog");

        onCreate(db);

    }


}
