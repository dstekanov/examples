package com.examples.stream.intermediate;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class Example02 {

    public static <T> Predicate<T> distinct(long atLeast) {
        ConcurrentHashMap<T, Long> map = new ConcurrentHashMap<>();
        return t -> map.merge(t, 1L, Long::sum) == atLeast;
    }

    @Test
    void leaveValuesWhichAreRepeatedAtLeast3Times() {
        List<String> list = List.of("JPoint", "Joker", "JBreak", "JBreak", "JBreak", "Joker");

        list.stream().filter(distinct(3)).forEach(System.out::println);
    }

}
