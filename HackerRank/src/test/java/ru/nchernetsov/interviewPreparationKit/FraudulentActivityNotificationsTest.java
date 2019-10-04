package ru.nchernetsov.interviewPreparationKit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FraudulentActivityNotificationsTest {

    @Test
    public void test1() {
        int[] expenditure = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
        int d = 5;
        int notifications = FraudulentActivityNotifications.activityNotifications(expenditure, d);
        assertThat(notifications).isEqualTo(2);
    }

    @Test
    public void test2() {
        int[] expenditure = new int[]{1, 2, 3, 4, 4};
        int d = 4;
        int notifications = FraudulentActivityNotifications.activityNotifications(expenditure, d);
        assertThat(notifications).isEqualTo(0);
    }

    @Test
    public void test3() {
        int[] expenditure = new int[]{10, 20, 30, 40, 50};
        int d = 3;
        int notifications = FraudulentActivityNotifications.activityNotifications(expenditure, d);
        assertThat(notifications).isEqualTo(1);
    }
}
