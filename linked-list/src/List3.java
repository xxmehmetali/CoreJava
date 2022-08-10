import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class List3 {

    public void doList3(){
        // methods : indexOf(..) , lastIndexOf(..)
        /*
                indexof ilk karşılaştığının indexini verir
                lastIndexOf son karşılaştığının indexini verir
         */


        LinkedList<String> progLangs = new LinkedList<>(Arrays.asList("c", "c#", "java", "python","c#"));

        System.out.println(progLangs.indexOf("c")); // 0

        System.out.println(progLangs.indexOf("c#")); // 1
        System.out.println(progLangs.lastIndexOf("c#")); // 4


        // iteration
            //iterator
            //for each
            //simple for loop

        // iterator
        Iterator iterator = progLangs.iterator();
        while (iterator.hasNext())
            System.out.println("lang : " + iterator.next());

        // for each
        //1
        progLangs.forEach(progLang -> System.out.println("lang : " + progLang));
        //2
        progLangs.stream().forEach(progLang -> System.out.println("lang : " + progLang));

        // for
        for (String progLang : progLangs) {
            System.out.println("lang : "+ progLang);
        }






    }
}
