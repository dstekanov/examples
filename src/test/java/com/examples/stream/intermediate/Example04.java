package com.examples.stream.intermediate;

import one.util.streamex.StreamEx;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class Example04 {
    private List<Map<String, Integer>> listMap = List.of(
            Map.of("a", 1, "b", 2),
            Map.of("a", 3, "d", 4, "e", 5),
            Map.of("a", 5, "b", 6, "e", 7)
    );

    @Test
    void convertListMapToMapList() {
        Map<String, List<Integer>> mapList = listMap.stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(groupingBy(Map.Entry::getKey,
                        mapping(Map.Entry::getValue,
                                toList())));

        // [ {a=1, b=2}, {e=5, a=3, d=4}, {e=7, a=5, b=6} ]
        System.out.println(listMap);
        // { a=[1, 3, 5], b=[2, 6], d=[4], e=[5, 7] }
        System.out.println(mapList);
    }

    @Test
    void streamExExample() {
        Map<String, List<Integer>> mapList = StreamEx.of(listMap)
                .flatMapToEntry(m -> m)
                .grouping();

        // [ {a=1, b=2}, {e=5, a=3, d=4}, {e=7, a=5, b=6} ]
        System.out.println(listMap);
        // { a=[1, 3, 5], b=[2, 6], d=[4], e=[5, 7] }
        System.out.println(mapList);
    }

}
