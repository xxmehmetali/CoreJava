import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSet3 {

    public void doHashSet3(){
        Set<Integer> nums = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        // filter ile condition ekleyip kullanabildik
        nums.stream().filter(num -> num%2!=0).forEach(num -> System.out.print(num+ " ")); // 1 3 5 7 9

        System.out.println();

        nums.add(2);
        System.out.println(nums);   // 2 zaten var olduğu için bir daha 2 yi eklemez
                                    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    }
}
