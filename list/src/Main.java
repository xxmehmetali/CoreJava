import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//        List<String> fruits = new ArrayList<>();
//        fruits.add("apple");
//        fruits.add("banana");
//        fruits.add("mango");
//        fruits.add("orange");

        // hızlı liste tanımlama
        List<String> langs = Arrays.asList("c","c++","c#","java","python");

        // 1.yöntem
        for(int i = 0 ; i<langs.size() ; i++)
            System.out.println(langs.get(i));

        // 2.yöntem
        for(String lang : langs)
            System.out.println(lang);

        // 3.yöntem
        // mantığına bak
        for (Iterator iterator = langs.iterator(); iterator.hasNext();) {
            String lang = (String) iterator.next();
            System.out.println(lang);

        }

        Iterator iterator = langs.iterator();
        while (iterator.hasNext())
            System.out.println((String) iterator.next());



        // JAVA 8+
        // v1
        langs.stream().forEach(lang -> System.out.println(lang));
        // v2
        langs.forEach(lang-> System.out.println(lang));
        // v3
        langs.forEach(System.out::println);




    }
}
