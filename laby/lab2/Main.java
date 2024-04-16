package programowanieof.laby.lab2;

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

    static double takeDoubleInput() {
        Scanner myScanner = new Scanner(System.in);
        boolean inputController = true;
        while(inputController) {
            try {
                String firstInput = myScanner.nextLine();
                double intInput = Double.parseDouble(firstInput);
                myScanner = null;
                inputController = false;
                return intInput;
            } catch (NumberFormatException error) {
                System.out.println("Wartosc musi byc liczba zmiennoprzecinkowa");
            }
        }
        return 0;
    }

    static boolean switchMenu(int num, Cylinder cylinderHandler, boolean programController) {
        switch(num) {
            case(1) -> System.out.println("promien podstawy walca: " + cylinderHandler.getBaseRadius() + " wysokosc walca: " + cylinderHandler.getHeight());
            case(2) -> {
                System.out.println("podaj promien");
                double radius = takeDoubleInput();
                if (radius <= 0) {
                    System.out.println("wartosc nie moze byc ujemna");
                } else {
                    cylinderHandler.setBaseRadius(radius);
                    System.out.println("promien ustawiony na " + cylinderHandler.getBaseRadius());
                }
            }
            case(3) -> {
                System.out.println("podaj wysokosc");
                double height = takeDoubleInput();
                if (height <= 0) {
                    System.out.println("wartosc nie moze byc ujemna");
                } else {
                    cylinderHandler.setHeight(height);
                    System.out.println("wysokosc ustawiona na " + cylinderHandler.getHeight());
                }
            }
            case(4) -> System.out.println(cylinderHandler.checkIfValuesArePositive() ? "objetosc wynosi: " + cylinderHandler.calculateVolume() : "wartosci walca musza byc powyzej zera");
            case(5) -> System.out.println(cylinderHandler.checkIfValuesArePositive() ? "pole podstawy: " + cylinderHandler.calculateBaseSurfaceArea() + " pole boczne: " + cylinderHandler.calculateLateralSufaceArea() + " pole calkowite: " + cylinderHandler.calculateTotalSurfaceArea() : "wartosci walca musza byc powyzej zera");
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
        Cylinder cylinderHandler = new Cylinder();
        
        System.out.println("To jest program do wyliczania pol i objetosci walca");
        System.out.println("Wybierz jedna z opcji:");
        System.out.println("1 - Wyswietlenie wartosci promienia podstawy i wysokosci");
        System.out.println("2 - Ustawienie wartosci promienia podstawy");
        System.out.println("3 - Ustawienie wartosci wysokosci walca");
        System.out.println("4 - Wyliczenie objetosci walca");
        System.out.println("5 - Wyliczenie pola powierzchni, bocznego, powierzchni calkowitej");
        System.out.println("Dowolna inna liczba (np. 0) - wyjscie z programu");

        while(programController) {

            System.out.println("wybierz opcje");
            int num = takeIntInput();
            if (!switchMenu(num, cylinderHandler, programController)) {
                programController = false;
            }
           
        }
    }
}
