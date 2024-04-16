//zakres 3 pierwsze wyklady
//12.04 test na wykladzie 10:10
//pytanie o dzialania na shortach i jaki typ danych zwroci wynik czy cos

public class NotatkiW3 {

}

//operatory
//moga byc pojedyncze, podwojne lub potrojne
//(type) -> operator rzutowania
//instance of

//casting primitve values
//jesli mamy zmienna wezszego typu mozemy ja przekonwertowac na szersza bez problemu short y = (short)20_591
//jesli chcemy zmienna szerszego typu zmienic na wezsza musimy jawnie ja rzutowac [operator (type)]

//jesli chcemy dodac do siebie 2 rozne typy java ma nastepujace zasady:
//1. wezszy zostanie autorozszerzony do szerszego typu i wynik zwroci jako szerszy
//2. jesli jeden z typow jest liczba calkowita a druga to zmiennoprzecinkowa, calkowita zostanie podniesiona do zmiennoprzecinkowej i wynik bedzie zmiennoprzecinkowy
//3. byte i short zostaja zawsze automatycznie podnoszone do typu int, nawet jak dodajemy 2 zmienne tego samego typu. aby zmienic typ wyniku na short nalezy uzyc rzutowania
//4. po wszystkich promocjach, typ wyniku bedzie taki jak typy do ktorych zostaly podniesione

//ternary operator (potrojny operator)
//boolExprs ? expr1 : expr2

//java ma for-each
//(datatype instance : collection) {}

//tablica dwuwymiarowa
//int[][] myComplexArray = {{5,5,2},{3,5,1}}
//for(int[] mySimpleArray : myComplexArray) {
//    for(int i : mySimpleArray) {
//         System.out.print(i)
//}
//}

//dwa sposoby na utworzenie stringa
//jezeli tworzymy obiekt tworzac po prostu lancuch znakow, to jezeli ma juz go w puli (zostal stworzony wczesniej taki sam ciag znakow) to utworzy tylko referencje
//String name = "Grupa 215IC"
//jezeli jawnie piszemy new string to zawsze utworzy nowy obiekt i przypisze referencje
//String name = new String("Grupa 215IC)"

//znak plusa przy stringach jest operatorem konkatenacji
//1 + 2 + "c" //"3c"

//obiekty klasy string sa niemutowalne
//String s = "1"
//s += "2"
//w tym przypadku powstaje nowy obiekt
//kazda operacja laczenia stringow tworzy nowy obiekt string

//musimy przypisac wynik do zmiennej aby go otrzymac .concat("2") == +
// s2.concat("3") gdzie s2 = "12" to wciaz "12". s3 = s2.concat("3") to "123"

//zestaw metod na Stringach
//length(), chartAt(index), indexOf(char), substring(), toLowerCase(), toUpperCase(), equals(String str), equalsIgnoreCase()  
//startsWith(), endsWith(), replace(), replaceAll(), contains(), trim(), strip(), stripLeading(), stripTrailing(), intern() => for string pools

//metody mozna chainowac
//String result = "AniMal".trim().toLowerCase().replace('a', 'A');

//klasa StringBuilder //nie bd na testach
//mutowalne, działamy cały czas na jednym obiekcie
//dobra praktyka jest na koniec tworzenie dzialan na StringBuilder wywolac metode .toString() i wysylanie takiego wyniku

//porownywanie wartosci typu String
//w zasadzie porowywane sa adresy referencji przy uzyciu operatora '=='
//nie uzywa sie go wiec do porownywania lancuchow znakow


//String x = new String("Hello World");
//String z = "Hello World";
//x.equals(z); // true
//toString();

//przeslanianie metod -> pomiedzy klasami
//przeciazanie -> w tej samej klasie

//tablice Array. tablice sa stale
//int[] numbers = new int[3] <- rozmiar tablicy
//int[] numAnimals;
//int[][] rectangleArray = new int[3][4];
//rectangleArray[0][2] = 15;
//int[][] diffSize = {{1,6}, {3,5,9,8}, {2,4,7}}; //tablice w tablicach sa co do zasady tablice postrzepione. liczba elementow w wymiarach moze byc rozna

//tablice ArrayList
//kolekcje dynamiczne, moga zmieniac rozmiar
//moga zawierac obiekty dowolnych klas
//ArrayList<String> list4 = newArrayList<String>(); 
//ArrayList<String> list5 = newArrayList<>(); 
//listy dla obiektów klasy string, zainicjowanie bez typu <> zawiera typ obiektowy
//ArrayList<Animal> listAnimal = newArrayList<Animal>();
//w kolekcji ArrayList przechowujemy tylko obiekty klas -> mozemy przechowywac liczby bo sa wrappery obiektow dla typow podstawowych typu Double double

//metody ArrayList
//add(), remove(), set(), isEmpty(), size(), clear(), contains()
//import java.util.ArrayList

//mechanizm autoboxing
//wrapper classes to klasy opakowujace typy podstawowe w obiekty
//Integer intWrapped = 1;  //Integer typ referencyjny
//int i = intWrapped; //intWrapped zostaje rozpakowane i przypisane do typu int, dzieje sie automatycznie

//jawne wykonanie tego co robi autoboxing:
//Integer intWrapped = Integer.valueOf(1) //zapakowanie we wrapper , wrapper class value
//int i = intWrapped.intValue() //rozpakowanie obiektu, converting back to primitive



//na zaj w pon
//static -> nie trzeba tworzyc obiektu
//metody zmiennych klasy
//teraz bedziemy powolywac obiekt, kontekst i stan obiektu na podstawie tej instancji