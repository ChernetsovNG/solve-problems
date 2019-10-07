package ru.nchernetsov.interviewPreparationKit;

public class MergeSortCountingInversions {

    static long countInversions(int[] arr) {
        long invCount = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    invCount++;
                }
            }
        }
        return invCount;
    }
}
