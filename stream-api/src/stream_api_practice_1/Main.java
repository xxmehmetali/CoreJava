package stream_api_practice_1;

import stream_api_practice_1.domain.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*

            1-)Stream api'yi kullanmak için [.stream()] ile objeyi stream objesine döndürürüz.
            2-)stream objesi üstünde
                    2.1) transformasyon yapılacak ise [.map()] kullanılır.
                    2.2) belli condition'lara uyacak olan elemanları seçecek isek [.filter(condition)] kullanılır.
            3-)return ederken [.collect(Collectors.toList());] ile return edilir.

            [.forEach()] void bir metoddur. [.map()] ise herhangi bir tipi return etmelidir.

         */


        upperCase("a","b","c","d"); // {"A","B","C","D"}
        getNamesLongerThan5Character("ali","veli","cuma","12345","123456","1234567"); // {"12345","123456","1234567"}
        getTotalNumbersOfCharacterOfLongerThank5Character("ali","veli","cuma","12345","123456","1234567"); // 18
        transform(createNestedStringList());
        getOldestPerson(createPersonList());
        getKidsNames(createPersonList());
        partitionAdults(createPersonList());
        groupByNationality2(createPersonList());
        namesToString(createPersonList());
        namesToString2(createPersonList());

        //tek sayıların başına e, çift sayıların başına o gelecek ve aralarında , olacak.
        //1.metodda ilk eleman hariç çalışıyor. Bunu kontrol et.
        getString(Arrays.asList(3,44,55,38));
        //2.metodda tamamen çalışıyor.
        getString2(Arrays.asList(3,44,55,38));
    }

    public static List<List<String>> createNestedStringList(){
        List<List<String>> nestedList = new ArrayList<>();
        for (int i = 97; i < 107; i+=2) {
            List<String> strList = new ArrayList<>();
            strList.add(String.valueOf((char)i));
            strList.add(String.valueOf((char)(i+1)));

            nestedList.add(strList);
        }
        return nestedList;
    }

    public static List<Person> createPersonList() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("tülay", 17 ,"usa"));
        people.add(new Person("ali",10,"turkey"));
        people.add(new Person("caner", 15, "turkey"));
        people.add(new Person("cemre", 25, "turkey"));
        people.add(new Person("ali", 9, "germany"));
        return people;
    }

    public static Collection<String> upperCase(String...names) {
        // names listesindeki her eleman için name adı verilir ve işlemler bunlar üstünden yapılır.
//        return Arrays.stream(names).map(name -> name.toUpperCase()).collect(Collectors.toList());

        // burda map metodu içerisinde her elemanın base classında bulunan metodları çalıştırabiliriz.
        return Arrays.stream(names).map(String::toUpperCase).collect(Collectors.toList());
    }

    public static Collection<String> getNamesLongerThan5Character(String...names) {
        return Arrays.stream(names).filter(name -> name.length() >= 5).collect(Collectors.toList());
    }

    public static int getTotalNumbersOfCharacterOfLongerThank5Character(String...names) {
        return Arrays.stream(names)         // stream<String>
                .filter(name -> name.length() >= 5)  // stream<String>
                .mapToInt(String::length)                 // stream<Integer>
                .sum();                     // Integer

            // .mapToInt(String::length)  kısmında içeride bir integer değer vermemiz gerek.


        /*
        Arrays.stream(names)         // stream<String>
                .filter(name -> name.length() >= 5)  // stream<String>
                .mapToInt(String::length).toArray()
         */
    }

    public static List<String> transform(List<List<String>> collection) {
        return collection.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static Person getOldestPerson(List<Person> people) {
//        stream_api_practice_1.domain.Person oldestPerson = new stream_api_practice_1.domain.Person("", 0);
//        for (stream_api_practice_1.domain.Person person : people) {
//            if (person.getAge() > oldestPerson.getAge()) {
//                oldestPerson = person;
//            }
//        }
//        return oldestPerson;

        // .max() ve .min() parametre olarak Comparator alırlar.
        return people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(null);
    }

    public static Set<String> getKidsNames(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.toSet());
    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        Map<Boolean, List<Person>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for (Person person : people) {
            map.get(person.getAge() >= 18).add(person);
        }
        return map;
    }

    public static Map<Boolean, List<Person>> partitionAdults2(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() >= 18, Collectors.toList()));
    }

    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        Map<String, List<Person>> map = new HashMap<>();
        for (Person person : people) {
            if (!map.containsKey(person.getNationality())) {
                map.put(person.getNationality(), new ArrayList<>());
            }
            map.get(person.getNationality()).add(person);
        }
        return map;
    }

    public static Map<String, List<Person>> groupByNationality2(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(person -> person.getNationality(), Collectors.toList()));
//        return people.stream()
//                .collect(Collectors.groupingBy(stream_api_practice_1.domain.Person::getNationality(), Collectors.toList()));
    }

    public static String namesToString(List<Person> people) {
        return new StringBuilder("Names: ").append(
                people.stream()
                        .map(Person::getName)
                        .collect(Collectors.joining(","))) // delimiter : ayraç
                .append(".").toString();
    }

    public static String namesToString2(List<Person> people) {
        return new StringBuilder("Names: ").append(
                        people.stream()
                                .map(Person::getName)
                                .reduce((i, i2) -> i + "," + i2)
                                .orElse(""))
                //
                .append(".").toString();
    }

    public static String getString(List<Integer> list) {
        return list.stream()
                .map(integer -> String.valueOf(integer))
                .reduce((i,i2) -> i + "," + (Integer.valueOf(i2) % 2 == 0 ? "e" + i2 : "o" + i2))
                .orElse("");
    }

    public static String getString2(List<Integer> list) {
        return list.stream()
                .map(integer -> {
                    return integer % 2 == 0 ? "e" + String.valueOf(integer) : "o" + String.valueOf(integer);
                })
                .collect(Collectors.joining(","));
    }


}
