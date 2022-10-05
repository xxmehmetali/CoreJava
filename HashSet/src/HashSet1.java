import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSet1 {

    public void doHashSet1(){

        // HashSet ler unique key ler içerir. 2 kere aynı değeri koyamayız. Küme gibi düşünülebilir.


        // declaration
        // methods : addAll(..)

        Set<String> set1 = new HashSet<>(Arrays.asList("c", "c++", "java", "python"));
        System.out.println(set1);   // [c++, python, c, java]

        set1.add("java");
        System.out.println(set1);   // [c++, python, c, java]
        //  2.kez (duplicate) ekleme yapmaz

        Set<String> set2 = new HashSet<>(Arrays.asList("ruby","c#"));

        set1.addAll(set2);
        System.out.println(set1); // [c#, c++, python, c, java, ruby]




    }
}
