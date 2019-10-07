package ru.nchernetsov.interviewPreparationKit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortCountingInversionsTest {

    @Test
    public void test1() {
        int[] arr = {1, 1, 1, 2, 2};
        long countInversions = MergeSortCountingInversions.countInversions(arr);
        assertThat(countInversions).isEqualTo(0);
    }

    @Test
    public void test2() {
        int[] arr = {2, 1, 3, 1, 2};
        long countInversions = MergeSortCountingInversions.countInversions(arr);
        assertThat(countInversions).isEqualTo(4);
    }

    @Test
    public void test3() {
        int[] arr = {1, 5, 3, 7};
        long countInversions = MergeSortCountingInversions.countInversions(arr);
        assertThat(countInversions).isEqualTo(1);
    }

    @Test
    public void test4() {
        int[] arr = {7, 5, 3, 1};
        long countInversions = MergeSortCountingInversions.countInversions(arr);
        assertThat(countInversions).isEqualTo(6);
    }

    @Test
    public void test5() {
        int[] arr = {1, 3, 5, 7};
        long countInversions = MergeSortCountingInversions.countInversions(arr);
        assertThat(countInversions).isEqualTo(0);
    }

    @Test
    public void test6() {
        int[] arr = {3, 2, 1};
        long countInversions = MergeSortCountingInversions.countInversions(arr);
        assertThat(countInversions).isEqualTo(3);
    }
}
