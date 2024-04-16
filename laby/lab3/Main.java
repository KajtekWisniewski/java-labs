package programowanieof.laby.lab3;

import java.util.Scanner;

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

    static boolean isValidDouble(double number) {
        double fractionalPart = number % 1;
        
        if (fractionalPart == 0 || fractionalPart == 0.5) {
            return true;
        } else {
            return false;
        }
    }

    static double takeGradeDoubleInput() {
        Scanner myScanner = new Scanner(System.in);
        boolean inputController = true;
        while(inputController) {
            try {
                String firstInput = myScanner.nextLine();
                double gradeInput = Double.parseDouble(firstInput);
                if (gradeInput >= 2 && gradeInput <= 5 && isValidDouble(gradeInput)) {
                    myScanner = null;
                    inputController = false;
                    return gradeInput;
                } else {
                    System.out.println("Wartosc oceny musi byc z przedzialu miedzy 2 a 5 i liczba calkowita lub konczaca sie na .5");
                }
                
            } catch (NumberFormatException error) {
                System.out.println("Wartosc musi byc liczba zmiennoprzecinkowa");
            }
        }
        return 0;
    }

    static void addGradeOption(GradeList gradeListHandler) {
        System.out.println("podaj ocene");
        double grade = takeGradeDoubleInput();
        gradeListHandler.addGrade(grade);
        System.out.println("dodano ocene");
    }

    static double roundOff(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    static boolean switchMenu(int num, GradeList gradeListHandler, boolean programController) {
        switch(num) {
            case(1) -> addGradeOption(gradeListHandler);
            case(2) -> System.out.println(gradeListHandler.checkEmptiness() ? "lista ocen jest pusta" : "srednia ocen: " + roundOff(gradeListHandler.calculateAverage()));
            case(3) -> System.out.println(gradeListHandler.checkEmptiness() ? "lista ocen jest pusta" : "maksymalna ocena: " + gradeListHandler.findMaximum());
            case(4) -> System.out.println(gradeListHandler.checkEmptiness() ? "lista ocen jest pusta" : "minimalna ocena: " + gradeListHandler.findMinimum());
            default -> {
                System.out.println("koniec programu");
                programController = false;
                return programController;
            }
        }
        return programController;
    }

    static void displayMenuOptions() {
        System.out.println("To jest program obslugujacy oceny studenta");
        System.out.println("Wybierz jedna z opcji:");
        System.out.println("1 - Dodanie nowej oceny");
        System.out.println("2 - Sprawdzenie sredniej ocen");
        System.out.println("3 - Sprawdzenie najwyzszej oceny");
        System.out.println("4 - Sprawdzenie najnizszej oceny");
        System.out.println("Dowolna inna liczba (np. 0) - wyjscie z programu");
    }

    public static void main(String[] args) {
        
        boolean programController = true;
        GradeList cylinderHandler = new GradeList();
        displayMenuOptions();

        while(programController) {

            System.out.println("wybierz opcje");
            int num = takeIntInput();
            if (!switchMenu(num, cylinderHandler, programController)) {
                programController = false;
            }
           
        }
    }
}
