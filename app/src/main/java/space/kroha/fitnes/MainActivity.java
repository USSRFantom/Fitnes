package space.kroha.fitnes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import space.kroha.fitnes.utils.JSONUtils;
import space.kroha.fitnes.utils.LessonAdepter;
import space.kroha.fitnes.utils.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLessons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewLessons = findViewById(R.id.recyclerViewLessons);





        JSONArray jsonArray= NetworkUtils.getJSONFromNetwork();
        ArrayList<Lessons> lessons =  JSONUtils.getLessonsFromJSON(jsonArray);
        StringBuilder builder = new StringBuilder();
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
        LessonAdepter adepter = new LessonAdepter(lessons);
        recyclerViewLessons.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLessons.setAdapter(adepter);







    }

}

  //





/* Проверка сборки url
    String url = NetworkUtils.buildURL().toString();
        Log.i("MyResult", url);
*/