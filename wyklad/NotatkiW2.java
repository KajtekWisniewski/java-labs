//java 21
//pakiety
//package declarations and imports

//klasy grupujemy w bibliotekach, pakietach
//pakiety sa po to aby nie bylo tez konfliktow z nazewnictwem lub korzystaniem z wielu
//klas ktore robia to samo ale moga byc zaimplementowane inaczej

//identyfikatory pisane sa w konwencji CamelCase
//to importuje pojedyncza klase random
import java.util.Random;
//import java.util.* // imports java.iutil.Random alongside with other classes from package util
// podpakiety nie sa importowane

public class NotatkiW2 {

}

class ImportExample {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10));
    }
}

//pakiet java.lang jest zawsze dostepny i automatycznie importowany
//w tym pakiecie jest klasa System

//tworzenie pakietu i importowanie klasy do innego pakietu

//te 3 linijki powinny byc w innym pliku
// package packageA;

// public class classA {

// }

//a to plik do ktorego importujemy nasza klase

// package packageB;

// import packageA.ClassA;

// public class classB {
//     public static void main(String[] args) {
//         ClassA a; //zmienna referencyjna ktora przechowuje obiekty klasy a ale nie ma zadnego obiektu klasy a poniewaz nie ma "new"
//         system.out.println("Got it")
//     }
// 

//pic skrot, kolejnosc w ktorej sformulowania sie powinny znalezc
//package -> import -> class

//package declaration ; not required
// import statement ; not req
// class declaration ; required
//field declarations ; not req
// method declarations ; not req

//package structure;     //package
//import java.util.*;     //import
//public class Cat {    //class
    //double weight;   //fiels
    //double height;
    //public double getWeight() { //methods
        //return weight;
//    }
//}

//jesli pominiemy modifykator dosepu to bedzie oznaczalo poziom dostepu package private, domyslnie package private aby zmienic nalezy jawnie to zrobic
//private
//package private
//protected
//public - zewszad

//tylko jedna klasa w pliku moze miec modyfikator Public
// reszta musi byc package private

// typy danych
// bool t/f
// byte 8bit int 123
// short 16bit int 123
// int 32bit int 123
// long 64bit int 123L
//float 32-bit floating point 123.45f
// double 64bit floating point 123.456
//char 16bit unicode 'a'
//z malej litery to typ podstawowy a nie typ referencyjny
//jak cos napiszemy traktowane jest to jako typ int
//a zmiennoprzecinkowe jest interpretowane jako double
//w javie nie ma wbudowanego unsigned int czyli zawsze mamy zakresy od - do +

//int numberOfStudents;
//numberOfStudents = 52;

//zmienna referencyjna
//java.util.Date today; - mozemy przypisywac do zmiennej dane typu klasy Date
//String greeting; - mozemy przypisywac do zmiennej dane typu String

//zmienne referencyjne moga miec przypisany null
//zmienne podstawowe z przypisana wartoscia null spowoduja compile error

//konwencje nazwenictwa
// CamelCase dla nazewnictwa klas
// lowerCamelCase for variable, method, package names
// snake_case uppercase for constants (static final) THIS_IS_A_CONSTANT - przy deklaracji stalej uzywamy static final
// snake_case with uppercase letters for enum values (wartosci wyliczeniowych)
// eg. Color.RED, color.DARK_GRAY

//metode main mozna wykorzystac nie powolujac obiektu klasy

//keywordy w javie

//this -> odwoluje sie do obiektu tej klasy
//super -> odwolujemy sie do obiektu tej klasy ale wskazujemy obiekty ktore wystepuja w klasie nadrzednej
//instanceof , instancja klasy inaczej obiekt

//switch case
//abstract , klasy i metody abstrakchyjne
//interface
//implements

//extends rozszerza klase

//tworzenie obiektów
//nazwa konstruktora jest tozsama z nazwa klasy
//nie jest okreslony typ zwracany

//przykład konstruktora
//konstruktor sluzy do inicjalizacji obiektu z parametrami
class Phone {
    private String number;

    public Phone(String number) {
        this.number = number;
    }
}

//zmiennie instancji i zmienne klasy sa domyslnie inicjowane, domyslne wartosci to
//boolean -> false
//byte, short, int, long -> 0
//float, double -> 0.0
//char -> '\u0000' (NUL)
//object references -> null

//zmienne lokalne za to nie maja domyslnych wartosci

class Mouse {
    static int maxLength = 5; //zmienna klasy
    private int length; //zmienna instancji

    public void grow(int inches) { //zmienna lokalna dla grow, parametr wejsciowy metody
        if (length < maxLength) {
            int newSize = length + inches; // zmienna lokalna
            length = newSize;
        }
    }
}

//garbage collector

class Scope {
    public static void main(String[] args) {
        String one, two;
        one = new String("a"); //obiekt
        two = new String("b"); //obiekt
        one = two; //obie zmiennie wskazuja teraz na obiekt "b". zadna na "a". teraz garbage collector jest zainteresowany tym obiektem "a"
        String three = one; //zmienna referencyjna
        one = null;
    }
}