package space.kroha.fitnes.utils;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import space.kroha.fitnes.database.Lessons;

import static space.kroha.fitnes.utils.NetworkUtils.getJSONFromNetwork;

public class JSONUtils {

    private static final String KYE_NAME = "name";
    private static final String KYE_START_TIME = "startTime";
    private static final String KYE_END_TIME = "endTime";
    private static final String KYE_TACHER = "teacher";
    private static final String KYE_PLASE = "place";
    private static final String KYE_WEEK_DAY = "weekDay";
    private static final String KYE_APPOINTMENT_ID = "appointment_id";
    private static final String KYE_DESCRIPTION  ="description";


    public static ArrayList<Lessons> getLessonsFromJSON (JSONArray jsonArray){

        ArrayList<Lessons> result = new ArrayList<>();
        if (jsonArray == null){
            return result;
        }
        try {
            JSONArray jsonArrayFull = jsonArray;

        for(int i = 0; i < jsonArrayFull.length(); i++){
            JSONObject objectLesson = jsonArrayFull.getJSONObject(i);
            String name = objectLesson.getString(KYE_NAME);
            double startTime = objectLesson.getDouble(KYE_START_TIME);
            double endTime = objectLesson.getDouble(KYE_END_TIME);
            String teacher = objectLesson.getString(KYE_TACHER);
            String place = objectLesson.getString(KYE_PLASE);
            int weekDay = objectLesson.getInt(KYE_WEEK_DAY);
            String appointment_id = objectLesson.getString(KYE_APPOINTMENT_ID);
            String descritpion = objectLesson.getString(KYE_DESCRIPTION);
            Lessons lessons = new Lessons(name, startTime, endTime, teacher, place, descritpion, weekDay);
            result.add(lessons);
            }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return result;
    }
}
