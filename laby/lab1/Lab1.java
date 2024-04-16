package programowanieof.laby.lab1;

import java.util.Scanner;


//Kajetan Wiśniewski
//Lab1 wersja1

// public class Lab1 {

//     static int takeIntInput() {
//         Scanner myScanner = new Scanner(System.in);
//         boolean inputController = true;
//         while(inputController) {
//             try {
//                 String firstInput = myScanner.nextLine();
//                 int intInput = Integer.parseInt(firstInput);
//                 myScanner = null;
//                 inputController = false;
//                 return intInput;
//             } catch (NumberFormatException error) {
//                 System.out.println("Wartosc musi byc liczba");
//             }
//         }
//         return 1;
//     }

//     static long calculateSum(int lowerLimit, int upperLimit) {
//         long sum = 0;
//         for (int i = lowerLimit; i <= upperLimit; i++) {
//             sum = sum + i;
//         }
//         return sum;
//     }

//     public static void main(String[] args) {
//         boolean programController = true;
//         System.out.println("To jest program do wyliczania sumy liczb z zakresu sprecyzowanego przez użytkownika");
         
//         while(programController) {
            
//             System.out.println("Podaj liczbe rozpoczynajaca zakres");
//             int lowerLimit = takeIntInput();
//             System.out.println("Podaj liczbe konczaca zakres");
//             int upperLimit = takeIntInput();
//             if (upperLimit > lowerLimit) {
//                 long sumOfNumbers = calculateSum(lowerLimit, upperLimit);
//                 System.out.println("Suma wszystkich liczb z zakresu od " + lowerLimit + " do " + upperLimit + " wynosi " + sumOfNumbers);
//             } else {
//                 System.out.println("Liczba z gornego zakresu musi byc wieksza od liczby z dolnego zakresu");
//             }
            
//             System.out.println("Jesli chcesz wyjsc z programu wpisz 0, w przeciwnym razie wpisz dowolna inna liczbe aby kontynuowac");
//             int doWeContinue = takeIntInput();
//             if (doWeContinue == 0) {
//                 System.out.println("program zakonczony");
//                 programController = false;
//             }
//         }
//     }
// }

//utworzyc druga klase, moze nazywac sie obliczenia
//przeniesc do tej klasy metode liczaca sume z zakresu liczb
//m abyc pierwsza metoda w klasie obliczenia
//druga metoda static (obie static)
//druga metoda ma wyliczac 2^n
//w klasie glownej wykorzystac te metody

//wersja z klasa obliczenia
public class Lab1 {

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
        return 1;
    }

    public static void main(String[] args) {
        boolean programController = true;
        System.out.println("To jest program do wyliczania sumy liczb z zakresu sprecyzowanego przez użytkownika");
         
        while(programController) {
            
            System.out.println("Podaj liczbe rozpoczynajaca zakres");
            int lowerLimit = takeIntInput();
            System.out.println("Podaj liczbe konczaca zakres");
            int upperLimit = takeIntInput();
            if (upperLimit > lowerLimit) {
                long sumOfNumbers = Calculations.calculateSum(lowerLimit, upperLimit);
                System.out.println("Suma wszystkich liczb z zakresu od " + lowerLimit + " do " + upperLimit + " wynosi " + sumOfNumbers);
            } else {
                System.out.println("Liczba z gornego zakresu musi byc wieksza od liczby z dolnego zakresu");
            }
            long twoToNth = Calculations.twoToNth(lowerLimit, 2);
            System.out.println("2^" + lowerLimit + " = " + twoToNth + " Jesli chcesz wyjsc z programu wpisz 0, w przeciwnym razie wpisz dowolna inna liczbe aby kontynuowac");
            int doWeContinue = takeIntInput();
            if (doWeContinue == 0) {
                System.out.println("program zakonczony");
                programController = false;
            }
        }
    }
}