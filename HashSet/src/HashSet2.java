import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSet2 {
    public void doHashSet2(){

        Set<Integer> nums = new HashSet<>();
        // fills nums up to 10
        for (int i = 1; i <= 10; i++) {
            nums.add(i);
        }
        nums.forEach(num -> System.out.print(num+" ")); // 1 2 3 4 5 6 7 8 9 10
        System.out.println();

        // satır içinde kullanılsada kaldırır ve boolean bir değer döndürür
        System.out.println(nums.remove(10));    // true
        nums.forEach(num -> System.out.print(num+" ")); // 1 2 3 4 5 6 7 8 9

        System.out.println();
        Set<Integer> evenNums = new HashSet<>(Arrays.asList(2,4,6,8));
        nums.removeAll(evenNums);
        nums.forEach(num -> System.out.print(num+" ")); // 1 3 5 7 9

        System.out.println();
        nums.clear();
        nums.forEach(num -> System.out.println(num)); // içi boş yazmaz




    }
}
