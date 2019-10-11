package ru.nchernetsov.interviewPreparationKit;

import java.util.*;

public class SherlockAndTheValidString {

    static String isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : chars) {
            countMap.merge(ch, 1, Integer::sum);
        }
        // 1. Все элементы имеют одну частоту
        Set<Integer> differentCounts = new HashSet<>(countMap.values());
        if (differentCounts.size() == 1) {
            return "YES";
        }
        List<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts);
        // 2. Все имеют одну частоту, а один элемент имеет частоту 1
        if (counts.get(0) == 1) {
            Set<Integer> nextElements = new HashSet<>(counts.subList(1, counts.size()));
            if (nextElements.size() == 1 && nextElements.iterator().next() > 1) {
                return "YES";
            }
        }
        // 3. Только один символ имеет частоту, на 1 больше, чем остальные
        Integer maxCount = counts.get(counts.size() - 1);
        Set<Integer> prevElements = new HashSet<>(counts.subList(0, counts.size() - 1));
        if (prevElements.size() == 1 && maxCount - prevElements.iterator().next() == 1) {
            return "YES";
        }
        return "NO";
    }
}
