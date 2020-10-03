package net.jxvtc.sqlitedemo;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
public class CustomSqlHelper extends SQLiteOpenHelper {
    public CustomSqlHelper(@Nullable Context context, @Nullable String name,
                           @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student (" +
                " _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "sno text NOT NULL," +
                "sname TEXT NOT NULL," +
                "sex text" +
                ")");
        ContentValues cv = new ContentValues();

        cv.put("sno","182094211");
        cv.put("sname","蒋宣");
        cv.put("sex","男");
        db.insert("student",null,cv);
        Log.d("TAG", "onCreate: 数据库创建成功");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        ContentValues cv = new ContentValues();
        cv.put("sno","182094228");
        cv.put("sname","王哲欣");
        cv.put("sex","女");
        db.insert("student",null,cv);
    }
}
