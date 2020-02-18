package com.examples.stream.intermediate;

import java.util.function.Function;
import java.util.stream.Stream;

public class Example01 {

    public static <T, TT> Function<T, Stream<TT>> select(Class<TT> clazz) {
        return e -> clazz.isInstance(e) ? Stream.of(clazz.cast(e)) : null;
    }

}
