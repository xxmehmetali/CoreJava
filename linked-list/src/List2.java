import java.util.Arrays;
import java.util.LinkedList;

public class List2 {

    public void doList2(){
        // methods : removeFirst() , removeLast() , remove(..) , clear()

        LinkedList<String> fruits = new LinkedList<>(Arrays.asList("apple","banana","mango","pineapple"));
        System.out.println(fruits); // [apple, banana, mango, pineapple]

        fruits.removeFirst();
        System.out.println(fruits); // [banana, mango, pineapple]

        fruits.removeLast();
        System.out.println(fruits); // [banana, mango]

        fruits.remove("banana");
        System.out.println(fruits); // [mango]

        fruits.clear();
        System.out.println(fruits); // []


    }
}
