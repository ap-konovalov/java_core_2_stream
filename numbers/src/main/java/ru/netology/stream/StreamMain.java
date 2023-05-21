package main.java.ru.netology.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));
        intList.stream()
                .filter(x -> x > 0 && x % 2 != 1)
                .sorted()
                .forEach(System.out::println);
    }
}
