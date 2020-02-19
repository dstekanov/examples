package com.examples.stream.intermediate;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class Example03 {

    @Test
    void interruptStreamByPredicate() {

        Stream.of(1, 2, 3, -1, 4, 5, 6)
                .takeWhile(it -> it > 0)
                .forEach(System.out::println);
    }

}
