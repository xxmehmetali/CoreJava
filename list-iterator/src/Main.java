import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {


        // İterator sadece ileri hareket edebilir ( hasNext() )
        // ListIterator ileri ve geri hareket edebilir ( hasNext() , hasPrevious() )

        List<String> langs = Arrays.asList("c","c++", "c#", "java", "python");
        ListIterator listIterator = langs.listIterator();
        // aynı işleve gelen satır aşağıda
        // ListIterator<String> listIterator = langs.listIterator();

        //ileri yazdırma
        while(listIterator.hasNext())
            System.out.println(listIterator.next());

        //tersten yazdırma
        while(listIterator.hasPrevious())
            System.out.println(listIterator.previous());

    }
}
