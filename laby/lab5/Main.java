import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static int takeIntInput() {
        Scanner myScanner = new Scanner(System.in);
        boolean inputController = true;
        while(inputController) {
            try {
                String firstInput = myScanner.nextLine();
                int intInput = Integer.parseInt(firstInput);
                myScanner = null;
                inputController = false;
                return intInput;
            } catch (NumberFormatException error) {
                System.out.println("Wartosc musi byc liczba");
            }
        }
        return 0;
    }

    static boolean addMeeting(Scanner sc, Calendar calendar) {
        System.out.println("podaj dzien: poniedzialek - 1, wtorek 2 - itd.");
        int day = takeIntInput();
        System.out.println("podaj opis");
        String str = sc.nextLine();
        System.out.println("podaj godzine rozpoczecia");
        int startHour = takeIntInput();
        System.out.println("podaj minute rozpoczecia");
        int startMinute = takeIntInput();
        System.out.println("podaj godzine zakonczenia");
        int endHour = takeIntInput();
        System.out.println("podaj minute zakonczenia");
        int endMinute = takeIntInput();
        System.out.println("podaj priorytet 0 - normalny, 1 - wysoki, 2 - najwyzszy");
        int priority = takeIntInput();
        Meeting newMeeting = new Meeting(str, day, startHour, startMinute, endHour, endMinute, priority);
        if (newMeeting.EARLIEST_TIME.isBefore(newMeeting.getStartTime())) {
            calendar.addMeetingWithObject(day, newMeeting);
            System.out.println("dodano");
            return true;
        } else {
            System.out.println("sprecyzowana godzina jest za wczesna");
            return false;
        }
    }

    static void removeMeeting(Calendar calendar) {
        System.out.println("podaj dzien z ktorego chcesz usunac: poniedzialek - 1, wtorek 2 - itd.");
        int day = takeIntInput();
        ArrayList<Meeting> toDisplayList = calendar.getAllMeetingsWithPredicate(day, meeting -> meeting.getDay() == day);
        int i = 0;
        for (Meeting meeting : toDisplayList) {
            System.out.println("id: " + i + " dzien: ".concat(displayDay(meeting.getDay())).concat(meeting.toString()));
            i++;
        }
        System.out.println("podaj numer spotkania ktore chcesz usunac");
        int id = takeIntInput();
        calendar.removeMeeting(day, id);
    }

    static void displayAll(Calendar calendar) {
        System.out.println("podaj dzien");
        int day = takeIntInput();
        ArrayList<Meeting> toDisplayList = calendar.getAllMeetingsWithPredicate(day, meeting -> meeting.getDay() == day);
        int i = 0;
        for (Meeting meeting : toDisplayList) {
            System.out.println("id: " + i + " dzien: ".concat(displayDay(meeting.getDay())).concat(meeting.toString()));
            i++;
        }
    }

    static String displayDay(int num) {
        String typeOfDay;
        switch(num) {
            case(1) -> typeOfDay ="Poniedziałek";
            case(2) -> typeOfDay ="Wtorek";
            case(3) -> typeOfDay ="Środa";
            case(4) -> typeOfDay ="Czwartek";
            case(5) -> typeOfDay ="Piątek";
            case(6) -> typeOfDay ="Sobota";
            case(7) -> typeOfDay ="Niedziela";
            default -> typeOfDay ="?";
        }
        return typeOfDay;
    }

    static void displayAllPriority(Calendar calendar) {
        System.out.println("podaj dzien");
        int day = takeIntInput();
        System.out.println("podaj priorytet");
        int priority = takeIntInput();
        ArrayList<Meeting> toDisplayList = calendar.getAllMeetingsWithPredicate(day, meeting -> meeting.getPriority() == priority);
        for (Meeting meeting : toDisplayList) {
            System.out.println("dzien: ".concat(displayDay(meeting.getDay())).concat(meeting.toString()));
        }
    }

    static void displayAllByStartingTime(Calendar calendar) {
        System.out.println("podaj dzien");
        int day = takeIntInput();
        System.out.println("podaj tylko godzine");
        int hour = takeIntInput();
        System.out.println("podaj tylko minute");
        int minute = takeIntInput();
        LocalTime selectedHour = LocalTime.of(hour, minute);
        ArrayList<Meeting> toDisplayList = calendar.getAllMeetingsWithPredicate(day, meeting -> meeting.getStartTime().isAfter(selectedHour));
        for (Meeting meeting : toDisplayList) {
            System.out.println("dzien: ".concat(displayDay(meeting.getDay())).concat(meeting.toString()));
        }
    }

    static void displayAllBetweenTime(Calendar calendar) {
        System.out.println("podaj dzien");
        int day = takeIntInput();
        System.out.println("podaj tylko godzine rozpoczecia");
        int startHour = takeIntInput();
        System.out.println("podaj tylko minute rozpoczecia");
        int startMinute = takeIntInput();
        System.out.println("podaj tylko godzine zakonczenia");
        int endHour = takeIntInput();
        System.out.println("podaj tylko minute zakonczenia");
        int endMinute = takeIntInput();
        LocalTime selectedStartTime = LocalTime.of(startHour, startMinute);
        LocalTime selectedEndTime = LocalTime.of(endHour, endMinute);
        ArrayList<Meeting> toDisplayList = calendar.getAllMeetingsWithPredicate(day, meeting -> meeting.getStartTime().isAfter(selectedStartTime) && meeting.getEndTime().isBefore(selectedEndTime));
        for (Meeting meeting : toDisplayList) {
            System.out.println("dzien: ".concat(displayDay(meeting.getDay())).concat(meeting.toString()));
        }
    }

    static void displayAllByTimeAndPriority(Calendar calendar) {
        System.out.println("podaj dzien");
        int day = takeIntInput();
        System.out.println("podaj tylko godzine rozpoczecia");
        int startHour = takeIntInput();
        System.out.println("podaj tylko minute rozpoczecia");
        int startMinute = takeIntInput();
        System.out.println("podaj priorytet");
        int priority = takeIntInput();
        LocalTime selectedStartTime = LocalTime.of(startHour, startMinute);
        ArrayList<Meeting> toDisplayList = calendar.getAllMeetingsWithPredicate(day, meeting -> meeting.getStartTime().isAfter(selectedStartTime) && meeting.getPriority() == priority);
        for (Meeting meeting : toDisplayList) {
            System.out.println("dzien: ".concat(displayDay(meeting.getDay())).concat(meeting.toString()));
        }
    }

    static void fillWithMeetings(Calendar calendar) {
        for (int n = 1; n < 8; n++) {
            for (int i = 0; i < 7; i++) {
                Meeting tempObj = new Meeting("opis", n, 7 + i, 10 + 2 * i, 11 + n, 15 + 2 * i, 1);
                calendar.addMeetingWithObject(n, tempObj);
            }
            for (int i = 0; i < 3; i++) {
                Meeting tempObj = new Meeting("opis2", n, 9 + n, 20 + 2 * i, 13 + i, 25 + 2 * i, 2);
                calendar.addMeetingWithObject(n, tempObj);
            }
            for (int i = 4; i < 7; i++) {
                Meeting tempObj = new Meeting("opis3", n, 10 + n, 25 + 2 * i, 14 + i, 35 + 2 * i, 0);
                calendar.addMeetingWithObject(n, tempObj);
            }
        }
    }


    static boolean switchMenu(int num, Calendar calendarHandler, boolean programController) {
        Scanner sc= new Scanner(System.in);
        switch(num) {
            case(1) -> addMeeting(sc, calendarHandler);
            case(2) -> removeMeeting(calendarHandler);
            case(3) -> displayAll(calendarHandler);
            case(4) -> displayAllPriority(calendarHandler);
            case(5) -> displayAllByStartingTime(calendarHandler);
            case(6) -> displayAllBetweenTime(calendarHandler);
            case(7) -> displayAllByTimeAndPriority(calendarHandler);
            case(8) -> fillWithMeetings(calendarHandler);
            default -> {
                System.out.println("koniec programu");
                programController = false;
                return programController;
            }
        }
        return programController;
    }

    public static void main(String[] args) {

        boolean programController = true;

        Calendar calendarHandler = new Calendar();
        calendarHandler.populateArrayList();
        System.out.println(calendarHandler.toString());
        while(programController) {
            System.out.println("(dni w zakresie 1-7) wybierz opcje:");
            System.out.println("menu: 1 - dodaj spotkanie, 2 - usun spotkanie, 3 - wyswietl z dnia, 4 - po priorytecie,");
            System.out.println("5 - po czasie rozpoczecia, 6 - w zakresie czasu, 7 - po czasie i priorytecie, 8 - wygeneruj spotkania");
            int num = takeIntInput();
            if (!switchMenu(num, calendarHandler, programController)) {
                programController = false;
            }
        }

    }
}
//dodatkowa metoda w klasie main i opcja do menu
//9.6 : dodac 7 roznych spotkan do kalendarza do 1 dnia, spotkania inne,