import java.time.LocalTime;
public class Meeting {

    public Meeting(String description, int day, int startHour, int startMinute, int endHour, int endMinute, int priority) {
        this.day = day;
        this.description = description;
        this.startTime = LocalTime.of(startHour, startMinute);
        this.endTime = LocalTime.of(endHour, endMinute);
        this.priority = priority;
    }

    public Meeting() {

    }

    private String description = "bazowy opis";
    private LocalTime startTime = LocalTime.of(0, 0);
    private LocalTime endTime = LocalTime.of(0, 0);
    private int priority;
    private int day;
    public final LocalTime EARLIEST_TIME = LocalTime.of(6,0);

    public int setDay(int day) {
        this.day = day;
        return day;
    }

    public int getDay() {
        return day;
    }

    public int getPriority() {
        return priority;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    public String getDescription() {
        return description;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalTime addStartTime(int startHour, int startMinute) {
        this.startTime = LocalTime.of(startHour, startMinute);
        return this.startTime;
    }

    public LocalTime endStartTime(int endHour, int endMinute) {
        this.endTime = LocalTime.of(endHour, endMinute);
        return this.endTime;
    }

    public int setPriority(int priority) {
        this.priority = priority;
        return priority;
    }

    public String addDescription(String description) {
        this.description = description;
        return description;
    }

    public String toString() {
        return " czas rozpoczecia " + startTime + " czas zakonczenia: " + endTime + " priorytet " + priority;
    }
}
