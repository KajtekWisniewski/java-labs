//klasy abstrakcyjne
//nie da sie powolywac fizycznych obiektów klas abstrakcyjnych
//w klasach abstrakcyjnych mozemy implemenetowac metody
//lub powolac metode jako metode abstrakcyjna

import java.util.ArrayList;
import java.util.function.*;

abstract class Animal {
    protected int age;
    public void eat() {
        System.out.println("anila is eating");
    }
    public abstract String getName();
}

class Swan extends Animal {
    public String getName() {
        return "Swan";
    }
}

//klasa dziedziczaca musi dostarczyc wszystkich implementacji metod abstrakcyjnych ktore nie zostały zaimpelemntowane w klasie abstrakcyjnej
//w javie mozna dziedziczyc z jednej klasy nadrzednej naraz

//interface
abstract interface canBurrow {
    public static final int MINIMUM_DEPTH = 2;
    public abstract int getMaximumDepth();
    //metoda domyslna w interfejsie to konkretne metody ktorych implementacje musimy dostarczyc w interfejsie
    public default double getTemperature() {
        return 10;
    }
}
//public static final keywords (assumed)
//public abstract keywords (assumed)
//w interfejsie abstract jest assumed nawet jak go nie napiszemy kompilator dodaje
//klasa moze implementowac wiele interfejsow

//sposob implementowania interfejsu
class FieldMouse implements canBurrow {
    public int getMaximumDepth() { //te metoda jest statyczna
        return 10;
    }
}

//lambdy

class Animal2 {
    private String name;
    private double height;
    private double weight;
    private double length;
    public Animal2(String name, double height, double weight, double length) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.length = length;
    }
    public double getHeight() { return height;}
    public double getWeight() { return weight;}
    public double getLength() { return height;}
    public String toString() {
        return "Animal name: " + name + ", height: " + height + ", weight + " + weight + ", length: " + length; //przyslanianie funkcji czy tez metody toString
    }
}

class MasalMara {

    private ArrayList<Animal2> natureReserve;
    public MasalMara() {
    natureReserve = new ArrayList<>(); }

    public void populateReserve() {
        natureReserve.add(new Animal2("lion", 110, 150, 210));
    }

    public ArrayList<Animal2> getAnimalsHigher(double height) {
        ArrayList<Animal2> animals = new ArrayList<>();
        for (Animal2 animal : natureReserve) {
            if (animal.getHeight() > height) animals.add(animal);
        }
        return animals;
    }

    public ArrayList<Animal2> getAnimalsHigherAndLonger(double height, double length) {
        ArrayList<Animal2> animals = new ArrayList<>();
        for (Animal2 animal : natureReserve) {
            if (animal.getHeight() > height && animal.getLength() > length) {
                animals.add(animal);
            }
        }
        return animals;
    }

    //tutaj mozemy wyslac wyrazenia lambda
    //jest to funkcja w pewien sposob generyczna, nie wiemy jak dokladnie sie wykona, nie ma ona implementacji w pewnym sensie

    public ArrayList<Animal2> getAnimals(Predicate<Animal2> check) {
        ArrayList<Animal2> animals = new ArrayList<>();
        for (Animal2 animal : natureReserve) {
            if (check.test(animal)) animals.add((animal));
        }
        return animals;
    }
    //przyklad uzycia lambdy
    //.getAnimals(a -> a.getHeight() > 120);
    //.getAnimals(a -> a.getHeight() > 80 && a.getLength() > 120);
    //przekazanie wyrazenia lambda jest to implementacja dynamiczna metody test w interfejsie predicate
}

//interfejsy funkcyjne, interfejsy z lambda
//java.util.function
//predicate
interface Predicate<T> {
    boolean test(T t);
}

//lambda syntad
//(Animal a) -> { return a.getHeight();}
//type is optional, return required in a block

//klasy dot czasu i dat
//LocalDate -> tylko data
//LocalTime -> tylko czas 
//LocalDateTime -> data i czas
//Period -> okres, zwiazany z datami, typu dni, miesiace, lata
//Duration -> okres, zwiazany z czasem, typu godzinami minutami itd

//Java to jezyk pass-by-value
//przekazuje przez wartosc; kopia wartosci jest tworzona i przekazywana do metody

public class NotatkiW4 {
    public static void main(String[] args) {
        String name = "Webby";
        speak(name);
        System.out.println(name); // webby, bo przekazujemy kopie referencji
    }
    public static void speak(String name) {
        name = "Sparky";
    }
}

//przeciazanie metod
//ta sama metoda (nazwa) ale rozne parametry
//public void fly(int NumMiles) {}
//public void fly(short numFeet) {}
//public boolean fly() {return True}

//method overloading example
class Fly {

    public void fly(int numMiles) {
        System.out.println("int");
    }

    public void fly(short numMiles) {
        System.out.println("short");
    }
}
//the call fly((short) 1); prints short
//the call fly(1) prints int
//java chooses the correct overloaded method in the following way:
//it looks for matching types and calls the appropiate method based on type
//checks in the following order: 
//1. exact match by type -> func(int i, int j)
//2. larger primitive type -> func(long i, long j)
//3. autoboxed type -> func(Integer i, Integer j)
//4. varargs func(int... nums)

//w przypadku typow referencyjnych zawsze mozemy skorzystac z przeciezonej metody z klasy wyzszej w hierarchii dziedziczenia
//metody przeciazone dla typow referencyjnych, jesli nie zostanie znaleziona odpowiednia w podrzednej 
//a jest zadeklarowana w nadrzednej, to zostanie wywolana ta z nadrzednej