package ru.nchernetsov.interviewPreparationKit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        long res = 0L;
        int len = arr.size();
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Long elem1 = arr.get(i);
            for (int j = i + 1; j < len; j++) {
                Long elem2 = arr.get(j);
                map.merge(elem2, 1, Integer::sum);
            }
            long elem2 = elem1 * r;
            long elem3 = elem2 * r;
            Integer elem2Count = map.get(elem2);
            Integer elem3Count = map.get(elem3);
            if (elem2Count != null && elem3Count != null) {
                if (elem2Count > 1 && elem3Count > 1) {
                    res += elem2Count * (elem3Count - 1) / 2;
                } else if (elem2 != elem3) {
                    res += elem2Count * elem3Count;
                }
            }
            map.clear();
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
