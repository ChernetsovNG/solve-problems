package ru.nchernetsov.interviewPreparationKit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        long res = 0L;
        int len = arr.size();
        Map<Long, Integer> left = new HashMap<>();
        Map<Long, Integer> rigth = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Long elem = arr.get(i);
            rigth.merge(elem, 1, Integer::sum);
        }
        for (int i = 0; i < len; i++) {
            Long elem = arr.get(i);
            Long r1 = elem / r;
            Long r2 = elem * r;
            rigth.put(elem, Math.max(rigth.getOrDefault(elem, 0) - 1, 0));
            Integer c1 = left.get(r1);
            Integer c2 = rigth.get(r2);
            if (c1 != null && c2 != null) {
                res += Long.valueOf(c1) * Long.valueOf(c2);
            }
            left.put(elem, left.getOrDefault(elem, 0) + 1);
        }
        return res;
    }

    static long nRealization(List<Long> arr, long r) {
        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (long elem : arr) {
            long key = elem / r;
            if (counter.containsKey(key) && elem % r == 0) {
                count += counter.get(key);
            }
            if (potential.containsKey(key) && elem % r == 0) {
                long c = potential.get(key);
                counter.put(elem, counter.getOrDefault(elem, 0L) + c);
            }
            // Every number can be the start of a triplet
            potential.put(elem, potential.getOrDefault(elem, 0L) + 1);
        }
        return count;
    }

    static long n2Realization(List<Long> arr, long r) {
        long res = 0L;
        int len = arr.size();
        // за O(n^2) составляем словарь: индекс ->
        // (число + сколько раз оно встечается правее этого индекса)
        Map<Integer, Map<Long, Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(i, new HashMap<>());
            for (int j = i + 1; j < len; j++) {
                Long elem = arr.get(j);
                map.get(i).merge(elem, 1, Integer::sum);
            }
        }
        // за O(n^2) вычисляем количество троек, образующих прогрессию
        for (int i = 0; i < len; i++) {
            Long elem1 = arr.get(i);
            long r1 = elem1 * r;
            long r2 = r1 * r;
            for (int j = i + 1; j < len; j++) {
                Long elem2 = arr.get(j);
                if (elem2 == r1) {
                    Map<Long, Integer> subMap = map.get(j);
                    Integer r2Count = subMap.get(r2);
                    if (r2Count != null && r2Count > 0) {
                        res += r2Count;
                    }
                }
            }
        }

        return res;
    }

    static long naiveRealization(List<Long> arr, long r) {
        long res = 0L;
        int len = arr.size();
        for (int i = 0; i < len; i++) {
            Long elem1 = arr.get(i);
            for (int j = i + 1; j < len; j++) {
                Long elem2 = arr.get(j);
                if (elem2 == elem1 * r) {
                    for (int k = j + 1; k < len; k++) {
                        Long elem3 = arr.get(k);
                        if (elem3 == elem2 * r) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
