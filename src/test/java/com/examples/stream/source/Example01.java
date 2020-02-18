package com.examples.stream.source;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example01 {

    public static <T> Stream<IndexedValue<T>> withIndices(List<T> list) {
        return IntStream.range(0, list.size())
                .mapToObj(idx -> new IndexedValue<>(idx, list.get(idx)));
    }

    static class IndexedValue<T> {
        public final int index;
        public final T value;

        public IndexedValue(int index, T value) {
            this.index = index;
            this.value = value;
        }
    }

    @Test
    void testWithIndices() {
        List<String> strings = List.of("Zero", "One", "Two", "Three", "Four");
        Stream<IndexedValue<String>> listWithIndices = withIndices(strings);
        listWithIndices
                .forEach(it -> System.out.println(it.index + ":" + it.value));
    }
}
