package ru.nchernetsov.interviewPreparationKit.MinimumSwaps2;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> elemIndex = new TreeMap<>();
        Map<Integer, Integer> indexElem = new TreeMap<>();
        boolean[] checked = new boolean[len];
        for (int index = 0; index < arr.length; index++) {
            int elem = arr[index];
            elemIndex.put(elem, index);
            indexElem.put(index, elem);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : elemIndex.entrySet()) {
            Integer elem = entry.getKey();
            Integer index = entry.getValue();
            int needIndex = needIndex(elem);
            if (checked[needIndex] || index == needIndex) {
                continue;
            }
            int count = 0;
            Integer nextElem = indexElem.get(needIndex);
            while (!checked[needIndex(nextElem)]) {
                checked[needIndex(nextElem)] = true;
                nextElem = indexElem.get(needIndex(nextElem));
                count++;
            }
            result += (count - 1);
        }
        return result;
    }

    private static int needIndex(int elem) {
        return elem - 1;
    }
}
