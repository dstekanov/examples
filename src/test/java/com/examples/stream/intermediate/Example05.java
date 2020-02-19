package com.examples.stream.intermediate;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Example05 {

    @Test
    void checkIfInputElementsAreUnique() {
        boolean result = Stream.of("5", "1", "3", "6", "8", "0", "2", "5")
                .allMatch(ConcurrentHashMap.newKeySet()::add); // Predicate should be stateless

        System.out.println(result); // false
    }

}
