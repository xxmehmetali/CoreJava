import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /*
            ArrayList arka planda array çalıştırır.
            arraylist.add(..) yaptığında 10 elemandan 11 elemana çıkarırken aslında bellekte 11 elemanlık
            yeni bir bellek bloğu ayırır ve 10 elemanlık diziyi 11 elemanlık diziye kopyalar. add fonksiyonuna
            verdiğimiz veriyide son indexe koyar.

            Linkedlist ise doubly linked listtir aslında. Previous ve Next nodeları vardır. Arraylistlerden
            daha hızlı çalışır ancak daha çok hafıza yer.
         */

        /*
            metodlar : add() , add(index, element) , addFirst() , addLast()
         */

        LinkedList<String> list = new LinkedList<>(Arrays.asList("a","b","c"));
        System.out.println(list);
        // çıktı : [a, b, c]

        // sona ekler
        list.add("x");
        System.out.println(list);
        //çıktı : [a, b, c, x]

        // 1.indexe ekler
        list.add(1, "y");
        System.out.println(list);
        //çıktı : [a, y, b, c, x]

        list.addFirst("0");
        System.out.println(list);
        //[0, a, y, b, c, x]
        list.addLast("99");
        System.out.println(list);
        //[0, a, y, b, c, x, 99]


        /*
            metodlar : get() , getFirst() , getLast()
         */

        System.out.println(list.getFirst()); // 0
        System.out.println(list.getLast());  // 99
        System.out.println(list.get(1));  // a

    }
}
