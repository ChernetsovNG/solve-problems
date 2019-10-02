package ru.nchernetsov.interviewPreparationKit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CountTripletsTest {

    @Test
    public void test1() {
        assertThat(CountTriplets.countTriplets(Arrays.asList(1L, 4L, 16L, 64L), 4)).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(CountTriplets.countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2)).isEqualTo(2);
    }

    @Test
    public void test3() {
        assertThat(CountTriplets.countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3)).isEqualTo(6);
    }

    @Test
    public void test4() {
        assertThat(CountTriplets.countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5)).isEqualTo(4);
    }

    @Test
    public void test5() {
        List<Long> list = Arrays.asList(1L, 1L, 1L);
        assertThat(CountTriplets.naiveRealization(list, 1)).isEqualTo(1);
        assertThat(CountTriplets.countTriplets(list, 1)).isEqualTo(1);
    }

    @Test
    public void test6() {
        List<Long> list = Arrays.asList(1L, 1L, 1L, 1L, 1L);
        assertThat(CountTriplets.naiveRealization(list, 1)).isEqualTo(10);
        assertThat(CountTriplets.countTriplets(list, 1)).isEqualTo(10);
    }

    @Test
    public void test7() {
        List<Long> list = LongStream.generate(() -> 1L)
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
        assertThat(CountTriplets.naiveRealization(list, 1)).isEqualTo(161700);
        assertThat(CountTriplets.countTriplets(list, 1)).isEqualTo(161700);
    }

    @Test
    public void test8() {
        List<Long> list = LongStream.generate(() -> 1237L)
                .limit(100000)
                .boxed()
                .collect(Collectors.toList());
        // assertThat(CountTriplets.naiveRealization(list, 1)).isEqualTo(166661666700000L);
        assertThat(CountTriplets.countTriplets(list, 1)).isEqualTo(166661666700000L);
    }
}
