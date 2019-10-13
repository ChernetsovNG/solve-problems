package ru.nchernetsov.interviewPreparationKit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpecialStringAgainTest {

    @Test
    public void test1() {
        long count = SpecialStringAgain.substrCount(5, "asasd");
        assertThat(count).isEqualTo(7);
    }

    @Test
    public void test2() {
        long count = SpecialStringAgain.substrCount(7, "abcbaba");
        assertThat(count).isEqualTo(10);
    }

    @Test
    public void test3() {
        long count = SpecialStringAgain.substrCount(4, "aaaa");
        assertThat(count).isEqualTo(10);
    }
}
