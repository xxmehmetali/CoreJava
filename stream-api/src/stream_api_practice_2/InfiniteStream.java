package stream_api_practice_2;

import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String[] args) {
        doOperation();
    }

    public static void doOperation() {
        int sum = Stream.iterate(0, e -> e + 1)
                .filter(e -> e % 2 == 0)
                .filter(e -> Math.sqrt(e) > 20)
                .mapToInt(e -> e * 2)
                .limit(10)
                .sum();
        System.out.println(sum);
    }

}
