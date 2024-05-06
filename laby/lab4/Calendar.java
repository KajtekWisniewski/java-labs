import java.time.LocalTime;
import java.util.ArrayList;
public class Calendar {
    public ArrayList<ArrayList<Meeting>> arrayOfLists = new ArrayList<ArrayList<Meeting>>();
    public ArrayList<ArrayList<Meeting>> populateArrayList() {
        for (int i = 0; i < 7; i++) {
            arrayOfLists.add(new ArrayList<Meeting>());
        }
        return arrayOfLists;
    }

    public boolean addMeeting(String description, int day, int startHour, int startMinute, int endHour, int endMinute, int priority) {
        Meeting newMeeting = new Meeting(description, day, startHour, startMinute, endHour, endMinute, priority);
        if (newMeeting.startTime.isAfter(newMeeting.EARLIEST_TIME)) {
            arrayOfLists.get(day-1).add(newMeeting);
            return true;
        } else {
            return false;
            }
        }

    public boolean addMeetingWithObject(int day, Meeting newMeeting) {
        arrayOfLists.get(day - 1).add(newMeeting);
        return true;
    }


    public boolean removeMeeting(int day, int id) {
        arrayOfLists.get(day-1).remove(id);
        return true;
    }

    public ArrayList<Meeting> getAllMeetingsByDay2(int day) {
        return arrayOfLists.get(day-1);
    }
    public ArrayList<Meeting> getAllMeetingsByDay(int day) {
        ArrayList<Meeting> tempArray = new ArrayList<Meeting>();
        tempArray = arrayOfLists.get(day-1);
        return tempArray;
    }

    public ArrayList<Meeting> getAllMeetingsByDayByPriority(int day, int priority) {
        ArrayList<Meeting> tempArray = (ArrayList<Meeting>)arrayOfLists.get(day-1).clone();
        tempArray.removeIf(s -> s.priority != priority);
        return tempArray;
    }

    public ArrayList<Meeting> getAllMeetingsByDayByHour(int day, int hour, int minute) {
        ArrayList<Meeting> tempArray = (ArrayList<Meeting>)arrayOfLists.get(day-1).clone();
        LocalTime selectedHour = LocalTime.of(hour, minute);
        tempArray.removeIf(s -> s.startTime.isBefore(selectedHour));
        return tempArray;
    }
}





