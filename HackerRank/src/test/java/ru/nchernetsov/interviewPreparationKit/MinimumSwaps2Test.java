package ru.nchernetsov.interviewPreparationKit;

import org.junit.Test;
import ru.nchernetsov.interviewPreparationKit.MinimumSwaps2;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumSwaps2Test {

    @Test
    public void test1() {
        int minimumSwaps = MinimumSwaps2.minimumSwaps(new int[]{4, 3, 1, 2});
        assertThat(minimumSwaps).isEqualTo(3);
    }

    @Test
    public void test2() {
        int minimumSwaps = MinimumSwaps2.minimumSwaps(new int[]{2, 3, 4, 1, 5});
        assertThat(minimumSwaps).isEqualTo(3);
    }

    @Test
    public void test3() {
        int minimumSwaps = MinimumSwaps2.minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7});
        assertThat(minimumSwaps).isEqualTo(3);
    }
}
