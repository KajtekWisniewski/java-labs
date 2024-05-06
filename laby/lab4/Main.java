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
        if (newMeeting.EARLIEST_TIME.isBefore(newMeeting.startTime)) {
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
        ArrayList<Meeting> toDisplayList = calendar.getAllMeetingsByDay(day);
        int i = 0;
        for (Meeting meet : toDisplayList) {
            System.out.println("id: " + i + " day: ".concat(displayDay(meet.day)).concat(" start time ") + meet.startTime + " end hour: " + meet.endTime + " priority " + meet.priority);
            i++;
        }
        System.out.println("podaj numer spotkania ktore chcesz usunac");
        int id = takeIntInput();
        calendar.removeMeeting(day, id);
    }

    static void displayAll(Calendar calendar) {
        System.out.println("podaj dzien");
        int day = takeIntInput();
        ArrayList<Meeting> toDisplayList = calendar.getAllMeetingsByDay(day);
        int i = 0;
        for (Meeting meet : toDisplayList) {
            System.out.println("id: " + i + " day: ".concat(displayDay(meet.day)).concat(" start time ") + meet.startTime + " end hour: " + meet.endTime + " priority " + meet.priority);
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
        ArrayList<Meeting> toDisplayList = calendar.getAllMeetingsByDayByPriority(day, priority);
        for (Meeting meet : toDisplayList) {
            System.out.println("day: ".concat(displayDay(meet.day)).concat(" start time ") + meet.startTime + " end hour: " + meet.endTime + " priority " + meet.priority);
        }
    }

    static void displayAllTime(Calendar calendar) {
        System.out.println("podaj dzien");
        int day = takeIntInput();
        System.out.println("podaj godzine");
        int hour = takeIntInput();
        System.out.println("podaj minute");
        int minute = takeIntInput();
        ArrayList<Meeting> toDisplayList = calendar.getAllMeetingsByDayByHour(day, hour, minute);
        for (Meeting meet : toDisplayList) {
            System.out.println("day: ".concat(displayDay(meet.day)).concat(" start time ") + meet.startTime + " end hour: " + meet.endTime + " priority " + meet.priority);
        }
    }

    static void fillWithMeetings(Calendar calendar) {
        for (int i = 0; i < 7; i++) {
            Meeting tempObj = new Meeting("opis", 2, 7+i, 10+2*i, 11+i, 15+2*i, 1);
            calendar.addMeetingWithObject(2, tempObj);
        }
        for (int i = 0; i < 3; i++) {
            Meeting tempObj = new Meeting("opis2", 2, 9+i, 20+2*i, 13+i, 25+2*i, 2);
            calendar.addMeetingWithObject(2, tempObj);
        }
        for (int i = 4; i < 7; i++) {
            Meeting tempObj = new Meeting("opis3", 2, 10+i, 25+2*i, 14+i, 35+2*i, 0);
            calendar.addMeetingWithObject(2, tempObj);
        }
    }


    static boolean switchMenu(int num, Calendar calendarHandler, boolean programController) {
        Scanner sc= new Scanner(System.in);
        switch(num) {
            case(1) -> addMeeting(sc, calendarHandler);
            case(2) -> removeMeeting(calendarHandler);
            case(3) -> displayAll(calendarHandler);
            case(4) -> displayAllPriority(calendarHandler);
            case(5) -> displayAllTime(calendarHandler);
            case(6) -> fillWithMeetings(calendarHandler);
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
        System.out.println("menu: 1 - dodaj spotkanie, 2 - usun spotkanie, 3 - wyswietl z dnia, 4 - po priorytecie, 5 - po czasie rozpoczecia, 6 - wygeneruj spotkania (dzien 2)");
        while(programController) {
            System.out.println("wybierz opcje:");
            int num = takeIntInput();
            if (!switchMenu(num, calendarHandler, programController)) {
                programController = false;
            }
        }

    }
}
//dodatkowa metoda w klasie main i opcja do menu
//9.6 : dodac 7 roznych spotkan do kalendarza do 1 dnia, spotkania inne,