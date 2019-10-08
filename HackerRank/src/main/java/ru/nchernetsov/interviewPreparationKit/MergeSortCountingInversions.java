package ru.nchernetsov.interviewPreparationKit;

public class MergeSortCountingInversions {

    static long countInversions(int[] arr) {
        return naiveRealization(arr);
    }

    // реализация за O(n x log(n))
    private static long mergeInversions(int[] arr) {
        return 0L;
    }

    static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int leftStart, int rightEnd, int[] temp) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(arr, leftStart, middle, temp);
        mergeSort(arr, middle + 1, rightEnd, temp);
        mergeHalves(arr, leftStart, rightEnd, temp);
    }

    private static void mergeHalves(int[] arr, int leftStart, int rightEnd, int[] temp) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);

        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }

    // реализация за O(n^2)
    private static long naiveRealization(int[] arr) {
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
