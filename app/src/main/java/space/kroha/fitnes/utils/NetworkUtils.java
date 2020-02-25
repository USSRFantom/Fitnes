package space.kroha.fitnes.utils;



import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

//Работа с сетью
public class NetworkUtils {
    private static final String BASE_URL = "https://sample.fitnesskit-admin.ru/schedule/get_group_lessons_v2/1/";

    //мотод формирования зароса (если нужно будет тащить вторую страницу или какие-то параметры)

    public static URL buildURL(){
        URL result = null;
        Uri uri = Uri.parse(BASE_URL).buildUpon()
                .build();
        try {
            result = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //Метод получения JSON из сети
    public static JSONArray getJSONFromNetwork(){
        JSONArray result = null;

        URL url = buildURL();

        try {
           result =  new JSONLoadTask().execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return  result;
    }

    private static class JSONLoadTask extends AsyncTask<URL, Void, JSONArray> {
        @Override
        protected JSONArray doInBackground(URL... urls) {
            JSONObject result = null;
            JSONArray mainObjectArray = null;
            if (urls == null || urls.length == 0) {
                return mainObjectArray;
            }
            HttpsURLConnection connection = null;
            try {
                connection = (HttpsURLConnection) urls[0].openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                mainObjectArray = new JSONArray(stringBuilder.toString());



               // result = new JSONObject(builder.toString());



            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return mainObjectArray;
        }

    }

}




//Метод загрузки данных из интернета

