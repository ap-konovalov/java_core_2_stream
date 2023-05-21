package main.java.ru.netology.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://github.com/netology-code/jd-homeworks/blob/master/streams/task1/README.md
public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));
        intList.removeIf(n -> n < 0);
        intList.removeIf(n -> n % 2 == 1);
        intList.sort(Comparator.comparingInt(Integer::valueOf));
        System.out.println(intList);
    }
}