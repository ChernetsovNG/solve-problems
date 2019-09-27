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
            if (checked[elem - 1] || index == elem - 1) {
                continue;
            }
            int count = 0;
            Integer nextElem = indexElem.get(elem - 1);
            while (!checked[nextElem - 1]) {
                checked[nextElem - 1] = true;
                nextElem = indexElem.get(nextElem - 1);
                count++;
            }
            result += (count - 1);
        }
        return result;
    }
}
