package space.kroha.fitnes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import space.kroha.fitnes.database.Lessons;
import space.kroha.fitnes.database.LessonsContract;
import space.kroha.fitnes.database.LessonsDBHelper;
import space.kroha.fitnes.utils.JSONUtils;
import space.kroha.fitnes.utils.LessonAdepter;
import space.kroha.fitnes.utils.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLessons;
    private LessonsDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewLessons = findViewById(R.id.recyclerViewLessons);
        dbHelper = new LessonsDBHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();


        JSONArray jsonArray = NetworkUtils.getJSONFromNetwork();
        ArrayList<Lessons> lessons = JSONUtils.getLessonsFromJSON(jsonArray); //получили
        for (Lessons lessons1 : lessons) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(LessonsContract.LessonsEntry.COLUMN_NAME, lessons1.getName());
            contentValues.put(LessonsContract.LessonsEntry.COLUMN_START_TIME, lessons1.getStartTime());
            contentValues.put(LessonsContract.LessonsEntry.COLUMN_END_TIME, lessons1.getEndTime());
            contentValues.put(LessonsContract.LessonsEntry.COLUMN_TEACHER, lessons1.getTeacher());
            contentValues.put(LessonsContract.LessonsEntry.COLUMN_PLACE, lessons1.getPlace());
            contentValues.put(LessonsContract.LessonsEntry.COLUMN_DESCRIPTION, lessons1.getDescription());
            contentValues.put(LessonsContract.LessonsEntry.COLUMN_WEEK_DAY, lessons1.getWeekDay());
            database.insert(LessonsContract.LessonsEntry.TABLE_NAME, null, contentValues);
        }
        ArrayList<Lessons> lessonsFromDB = new ArrayList<>();
        Cursor cursor= database.query(LessonsContract.LessonsEntry.TABLE_NAME, null, null, null,null, null, null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(LessonsContract.LessonsEntry.COLUMN_NAME));
            String startTime = cursor.getString(cursor.getColumnIndex(LessonsContract.LessonsEntry.COLUMN_START_TIME));
            String endTime = cursor.getString(cursor.getColumnIndex(LessonsContract.LessonsEntry.COLUMN_END_TIME));
            String teacher = cursor.getString(cursor.getColumnIndex(LessonsContract.LessonsEntry.COLUMN_TEACHER));
            String place = cursor.getString(cursor.getColumnIndex(LessonsContract.LessonsEntry.COLUMN_PLACE));
            String description = cursor.getString(cursor.getColumnIndex(LessonsContract.LessonsEntry.COLUMN_DESCRIPTION));
            String weekDay = cursor.getString(cursor.getColumnIndex(LessonsContract.LessonsEntry.COLUMN_WEEK_DAY));
            double start = Double.parseDouble(startTime);
            double end = Double.parseDouble(endTime);
            int week = Integer.parseInt(weekDay);
            Lessons lessons1 = new Lessons(name, start, end, teacher, place, description, week);
            lessonsFromDB.add(lessons1);
        }


        LessonAdepter adepter = new LessonAdepter(lessonsFromDB);
        recyclerViewLessons.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLessons.setAdapter(adepter);


    }

}

//





/* Проверка сборки url
    String url = NetworkUtils.buildURL().toString();
        Log.i("MyResult", url);
*/


        /*for (Lessons lessons1 : lessons) {
            builder.append(lessons1.getAppointment_id()).append("\n");
            builder.append(lessons1.getName()).append("\n");
            builder.append(lessons1.getStartTime()).append("\n");
            builder.append(lessons1.getEndTime()).append("\n");
            builder.append(lessons1.getTeacher()).append("\n");
            builder.append(lessons1.getPlace()).append("\n");
            builder.append(lessons1.getDescription()).append("\n");
            builder.append(lessons1.getWeekDay()).append("\n");
        }
        Log.i("MyResults", builder.toString());
        */