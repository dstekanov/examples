package com.examples.stream.source;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.List.*;

public class Example02 {

    private List<List<String>> input = of(of("a", "b", "c"), of("x", "y"), of("1", "2", "3"));

    @Test
    void cartesianProduce() {
        Stream<String> stream = input.get(0).stream().flatMap(a ->
                input.get(1).stream().flatMap(b ->
                        input.get(2).stream().map(c -> a + b + c)));
        stream.forEach(System.out::println);
    }

    @Test
    void functionalStyle() {
        Supplier<Stream<String>> s = input.stream()
                // Stream<List<String>>
                .<Supplier<Stream<String>>>map(list -> list::stream)
                // Stream<Supplier<Stream<String>>>
                .reduce((sup1, sup2) -> () -> sup1.get()
                .flatMap(e1 -> sup2.get().map(e2 -> e1 + e2)))
                // Optional<Supplier<Stream<String>>>
                .orElse(() -> Stream.of(""));

        s.get().forEach(System.out::println);
    }
}
