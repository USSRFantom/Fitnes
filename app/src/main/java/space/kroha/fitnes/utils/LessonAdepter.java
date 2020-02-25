package space.kroha.fitnes.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.kroha.fitnes.R;
import space.kroha.fitnes.database.Lessons;

public class LessonAdepter extends RecyclerView.Adapter<LessonAdepter.LessonViewHolder> {
    private ArrayList<Lessons> lessons;

    public LessonAdepter(ArrayList<Lessons> lessons) {
        this.lessons = lessons;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_lesson_item, viewGroup, false);
        return  new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder lessonViewHolder, int i) {
        Lessons lessons1 = lessons.get(i);
        lessonViewHolder.textViewName.setText(lessons1.getName());
        lessonViewHolder.textViewStartTime.setText(String.format("%s", lessons1.getStartTime()));
        lessonViewHolder.textViewEndTime.setText(String.format("%s", lessons1.getEndTime()));
        lessonViewHolder.textViewTeacher.setText(lessons1.getTeacher());
        lessonViewHolder.textViewPlace.setText(lessons1.getPlace());
        lessonViewHolder.textViewDescription.setText(lessons1.getDescription());
        lessonViewHolder.textViewWeekDay.setText(String.format("%s", lessons1.getWeekDay()));
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    class LessonViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewName;
        private TextView textViewStartTime;
        private TextView textViewEndTime;
        private TextView textViewTeacher;
        private TextView textViewPlace;
        private TextView textViewDescription;
        private TextView textViewWeekDay;


        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewStartTime = itemView.findViewById(R.id.textViewStartTime);
            textViewEndTime = itemView.findViewById(R.id.textViewEndTime);
            textViewTeacher = itemView.findViewById(R.id.textViewTeacher);
            textViewPlace = itemView.findViewById(R.id.textViewPlace);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewWeekDay = itemView.findViewById(R.id.textViewWeekDay);
        }
    }
}
