package ru.nchernetsov.interviewPreparationKit;

import java.util.Arrays;

public class FraudulentActivityNotifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int nCount = 0;
        int n = expenditure.length;
        int[] trailing = new int[d];
        for (int i = d; i < n; i++) {
            for (int j = i - d; j < i; j++) {
                trailing[j + d - i] = expenditure[j];
            }
            double m = median(trailing);
            if (expenditure[i] >= 2 * m) {
                nCount++;
            }
        }
        return nCount;
    }

    private static double median(int[] a) {
        Arrays.sort(a);
        int len = a.length;
        double m;
        if (len % 2 == 1) {
            m = a[(len - 1) / 2] * 1.0;
        } else {
            m = (a[(len - 1) / 2] + a[len / 2]) / 2.0;
        }
        return m;
    }
}
