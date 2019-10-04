package ru.nchernetsov.interviewPreparationKit;

public class FraudulentActivityNotifications {

    private static final int K = 201;

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int nCount = 0;

        int n = expenditure.length;

        int[] trailing = new int[d];
        int[] c = new int[K];
        int[] medianArr = new int[d];

        for (int i = 0; i < d; i++) {
            trailing[i] = expenditure[i];
        }

        double m;
        for (int i = d; i < n; i++) {
            if (i == d) {
                for (int j = 0; j < d; j++) {
                    c[trailing[j]] += 1;
                }
            } else {
                c[trailing[0]] -= 1;
                c[expenditure[i - 1]] += 1;
                trailing[0] = expenditure[i - d];
            }

            // вычисляем медиану
            int b = 0;
            for (int elem = 0; elem < K; elem++) {
                int count = c[elem];
                for (int f = 0; f < count; f++) {
                    medianArr[b++] = elem;
                }
            }
            if (d % 2 == 1) {
                m = medianArr[(d - 1) / 2] * 1.0;
            } else {
                m = 0.5 * (medianArr[(d - 1) / 2] + medianArr[d / 2]);
            }

            if (expenditure[i] >= 2 * m) {
                nCount++;
            }
        }
        return nCount;
    }
}
