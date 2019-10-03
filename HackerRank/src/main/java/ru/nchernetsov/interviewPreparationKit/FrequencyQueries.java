package ru.nchernetsov.interviewPreparationKit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numberCountMap = new HashMap<>(queries.size());
        Map<Integer, Integer> countsCountMap = new HashMap<>(queries.size());
        for (int[] query : queries) {
            Integer operation = query[0];
            Integer number = query[1];
            if (operation.equals(1)) {
                insert(number, numberCountMap, countsCountMap);
            } else if (operation.equals(2)) {
                delete(number, numberCountMap, countsCountMap);
            } else if (operation.equals(3)) {
                Integer countsCount = countsCountMap.get(number);
                if (countsCount != null && countsCount > 0) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }
        return result;
    }

    private static void insert(Integer number, Map<Integer, Integer> numberCountMap, Map<Integer, Integer> countsCountMap) {
        Integer prevCount;
        Integer newCount;
        if (!numberCountMap.containsKey(number)) {
            prevCount = null;
            newCount = 1;
            numberCountMap.put(number, newCount);
        } else {
            prevCount = numberCountMap.get(number);
            newCount = prevCount + 1;
            numberCountMap.put(number, newCount);
        }
        if (prevCount != null) {
            countsCountMap.put(prevCount, Math.max(countsCountMap.getOrDefault(prevCount, 0) - 1, 0));
        }
        countsCountMap.put(newCount, countsCountMap.getOrDefault(newCount, 0) + 1);
    }

    private static void delete(Integer number, Map<Integer, Integer> numberCountMap, Map<Integer, Integer> countsCountMap) {
        if (numberCountMap.containsKey(number)) {
            Integer prevCount = numberCountMap.get(number);
            Integer newCount = prevCount - 1;
            if (newCount > 0) {
                numberCountMap.put(number, newCount);
            } else {
                numberCountMap.remove(number);
            }
            countsCountMap.put(prevCount, Math.max(countsCountMap.getOrDefault(prevCount, 0) - 1, 0));
            if (newCount > 0) {
                countsCountMap.put(newCount, countsCountMap.getOrDefault(newCount, 0) + 1);
            }
        }
    }
}
