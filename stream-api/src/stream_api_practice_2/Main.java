package stream_api_practice_2;

import stream_api_practice_2.domain.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        sortByProperty();
        getAverageAge();
        getFirstNameLengthWithUser();
        getUserWithFirstNameLenght();
        isAllUsersAgeGreaterThanSMT();
        isAnyOneFromUSA();
        groupByNationalityFirstNameLastName();
        evenAndOddAgedOnes();
        nameCounts();
        flatMap1();
        findMaxAndSecondMax();
        findMaxAndMinOfIntList();
        getMaxCharacterString();
    }


    public static void sortByProperty() {
        List<User> users = getUsers();
        users.stream()
                .sorted(
                        Comparator.comparing(User::getAge)
                                .thenComparing(User::getFirstName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void getAverageAge() {
        List<User> users = getUsers();

        double averageAge = users.stream()
                .mapToInt(User::getAge)
                .summaryStatistics()
                .getAverage();

        System.out.println(String.format("Average age : %f", averageAge));
    }

    public static void evenAndOddAgedOnes() {
        List<User> users = getUsers();
        Map<Boolean, List<User>> map = users.stream()
                .collect(Collectors.partitioningBy(user -> user.getAge() % 2 == 0));
        System.out.println("Even aged ones : " + map.get(true));
        System.out.println("Odd aged ones : " + map.get(false));
    }

    //buraya bak
 /*   public static void getTotalAge() {
        List<User> users = getUsers();
        System.out.println(
                users.stream()
                        .reduce(0, (int total, User user) -> total + user.getAge(), )
        );
    }
*/
    public static void reduce1() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(
                nums.stream()
                        .reduce(0, (acc, e) -> acc + e));
    }

    public static void wrongApproach() {
        //Mutable object
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        //double the even numbers and put it to a new list
        //that is a wrong approach

        List<Integer> doubledEvenNums = new ArrayList<>();

        //If this was a parallel stream, It would cause problems.
        //Because parallel stream is a concurrent environment multiple threads may access to doubledEvenNums object at the same time (race conditions)
        //So shared mutability is not OK. Sharing ok, Mutability is ok But combination is not.
        nums.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(doubledEvenNums::add);

        System.out.println(
                "Doubled even nums : " + doubledEvenNums
        );

    }

    public static void getFirstNameLengthWithUser() {
        List<User> users = getUsers();
        int maxChar = users.stream()
                .mapToInt(u -> u.getFirstName().length())
                .summaryStatistics()
                .getMax();

        System.out.println(String.format("Max character : %d", maxChar));
    }

    public static void nameCounts() {
        List<User> users = getUsers();
        //default counting() method return type is Long
        Map<String, Long> map = users.stream()
                .collect(Collectors.groupingBy(User::getFirstName, Collectors.counting()));

        //if you want to cast it to Integer
        Map<String, Integer> map2 = users.stream()
                .collect(
                        Collectors.groupingBy(
                                User::getFirstName,
                                Collectors.collectingAndThen( // collectingAndThen(collector, function)
                                        Collectors.counting(), v -> v.intValue() // Long::intValue
                                )));

        System.out.println("Name : Count ==> " + map);
        System.out.println("Name : Count ==> " + map2);
    }

    public static void isAllUsersAgeGreaterThanSMT() {
        List<User> users = getUsers();
        final int EXPECTED_AGE = 25;
        System.out.println(
                "All user's age is greater than " + EXPECTED_AGE + " ? ==> " +
                        users.stream()
                                .allMatch(u -> u.getAge() > EXPECTED_AGE)
        );
    }

    public static void isAnyOneFromUSA() {
        List<User> users = getUsers();
        System.out.println(
                "Is there anyone from USA? ==> " +
                        users.stream()
                                .anyMatch(u -> Nationality.USA.equals(u.getNationality()))
        );
    }

    public static void groupByNationality() {
        List<User> users = getUsers();
        Map<Nationality, List<User>> map = users.stream()
                .collect(
                        Collectors.groupingBy(User::getNationality)); // Nationality : User
        System.out.println(
                "Grouped by nationality : " + map

        );
    }

    //customized version of groupByNationality. Value part is changed.
    public static void groupByNationalityFirstNameLastName() {
        List<User> users = getUsers();
        Map<Nationality, List<String>> map = users.stream()
                .collect(
                        Collectors.groupingBy(
                                User::getNationality,   // KEY
                                Collectors.mapping(     // VALUE
                                        u -> u.getFirstName() + " " + u.getLastName(),
                                        Collectors.toList())
                        )
                );
        System.out.println(
                "Grouped by nationality : " + map

        );
    }

    public static void getUserWithFirstNameLenght() {
        List<User> users = getUsers();
        Map<User, Integer> userFirstNameMap = users.stream()
                .collect(
                        Collectors.toMap(u -> u, u -> u.getFirstName().length()));
        userFirstNameMap.forEach((user1, integer) -> System.out.println("Max char : " + integer + " || User : " + user1));
    }

    public static void flatMap1() {
        List<List<String>> phoneNumsMultipleLayer = List.of(
                List.of("5355444570", "5301100991"),
                List.of("5319992345", "5391108765"),
                List.of("5318882345", "53377708765")
        );

        List<String> phoneNums = phoneNumsMultipleLayer.stream()
                .flatMap(p -> p.stream()) // yada List::stream
                .collect(Collectors.toList());

        System.out.println("Phone Numbers flatten : " + phoneNums);
    }

    public static void findMaxAndSecondMax() {
        List<Integer> nums = List.of(1, 2, 3, 78, 5, 67, 55, 34);
        System.out.println("Nums before : " + nums);
        nums = nums.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList());
        System.out.println("Max : " + nums.get(0) + " || Max2 : " + nums.get(1) + " || all : " + nums);
    }

    public static void findMaxAndMinOfIntList() {
        List<Integer> nums = List.of(1, 2, 3, 78, 5, 67, 55, 34);
        System.out.println("findMaxOfIntList() => Nums before : " + nums);
        IntSummaryStatistics intSummaryStatistics = nums.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        int max = intSummaryStatistics.getMax();
        int min = intSummaryStatistics.getMin();
        double average = intSummaryStatistics.getAverage();
        int count = (int) intSummaryStatistics.getCount();

        StringBuilder sb = new StringBuilder();
        String result = sb.append("findMaxAndMinOfIntList() => ")
                .append("|| Max value : " + max)
                .append("|| Min : " + min)
                .append("|| Average : " + average)
                .append("|| Count : " + count)
                .toString();

        System.out.println(result);
    }

    public static void getMaxCharacterString(){
        System.out.print("getMaxCharacterString() ==> ");
        List<String> names = List.of("Ali", "Veli", "Cuma", "Tülay", "Cumalettin");
        String longestName = names.stream()
                .reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2)
                .orElse("NoNameFound");
        int longestNamesx = Integer.parseInt(names.stream()
                .reduce(String.valueOf(0), (name1, name2) -> String.valueOf(name1.length() > name2.length() ? name1.length() : name2.length())));
        System.out.println("xasd : " + longestNamesx);
        System.out.println(longestName);
    }

    //BURAYA DÖB
    //https://www.youtube.com/watch?v=ePJrt5-G8eM&ab_channel=JavaTechie
    //02 34 00
    public static void findMaxAndSecondMaxWithReducer() {
//        List<Integer> nums = List.of(1, 2, 3, 78, 5, 67, 55, 34);
//        System.out.println("Nums before : " + nums);
//        nums = nums.stream()
//                .collect();
//        System.out.println("Max : " + nums.get(0) + " || Max2 : " + nums.get(1) + " || all : " + nums);
    }

    //maxby minby araştır
/*    public static void getUserThatHasMaxCharacterOfFirstName() {
        List<User> users = getUsers();
        String firstNameThatHasMaxChar =
                users.stream()
                        .collect(Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(e -> e.getFirstName().length()))

                        ));
    }*/

    public static List<User> getUsers() {
        return Arrays.asList(
                new User(1, "Ali", "Karadağ", 23, Nationality.TURKEY),
                new User(5, "Tiffany", "Wicknosia", 57, Nationality.SCOTLAND),
                new User(3, "John", "Wick", 47, Nationality.USA),
                new User(2, "Tülay", "Çelenk", 22, Nationality.TURKEY),
                new User(4, "Adam", "Andora", 53, Nationality.ENGLAND),
                new User(6, "David", "Beckham", 22, Nationality.USA),
                new User(6, "Ali", "Kara", 22, Nationality.USA),
                new User(6, "Tülay", "Çele", 22, Nationality.USA)
        );
    }

    public void waysOfCreatingStream() {
        //1
        Collection collection = Arrays.asList();
        Stream streamFromCollection = collection.stream();

        //2
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Stream streamFromArrays = (Stream) Arrays.stream(arr);

        //3
        Stream streamFromStreamBuilder = Stream.builder()
                .add(1)
                .add(2)
                .build();
    }

    public enum Nationality {
        TURKEY,
        USA,
        ENGLAND,
        SCOTLAND
    }

}
