import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

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
        if (newMeeting.getStartTime().isAfter(newMeeting.EARLIEST_TIME)) {
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

    public ArrayList<Meeting> getAllMeetingsWithPredicate(int day, Predicate<Meeting> filterPredicate) {
        ArrayList<Meeting> tempArray = new ArrayList<>();
        for (Meeting meeting : arrayOfLists.get(day-1)) {
            if (filterPredicate.test(meeting)) {
                tempArray.add(meeting);
            }
        }
        return tempArray;
    }


}





