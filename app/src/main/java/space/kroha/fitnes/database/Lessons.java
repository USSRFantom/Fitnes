package space.kroha.fitnes.database;

public class Lessons {
    private String appointment_id;
    private String name;
    private double startTime; //"startTime": "10.00",
    private double endTime;   //endTime":"10:45",
    private String teacher;  //"teacher":"имя преподавателя",
    private String place; //"place": "название зала",
    private String description; //"description":"описание занятия",
    private int weekDay;   //день недели




    public Lessons(String appointment_id, String name, double startTime, double endTime, String teacher, String place, String description, int weekDay) {
        this.appointment_id = appointment_id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
        this.place = place;
        this.description = description;
        this.weekDay = weekDay;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }
}
