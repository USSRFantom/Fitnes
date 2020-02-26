package space.kroha.fitnes.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LessonsDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "lessons.db";
    private static final int DB_VERSION = 1;

    public LessonsDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LessonsContract.LessonsEntry.CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(LessonsContract.LessonsEntry.DROP_COMMAND);
        onCreate(db);
    }
}
