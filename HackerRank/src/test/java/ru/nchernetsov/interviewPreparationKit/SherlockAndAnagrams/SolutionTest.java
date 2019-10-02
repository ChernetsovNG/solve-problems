package ru.nchernetsov.interviewPreparationKit.SherlockAndAnagrams;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void test1() {
        assertThat(Solution.sherlockAndAnagrams("abba")).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(Solution.sherlockAndAnagrams("abcd")).isEqualTo(0);
    }

    @Test
    public void test3() {
        assertThat(Solution.sherlockAndAnagrams("ifailuhkqq")).isEqualTo(3);
    }

    @Test
    public void test4() {
        assertThat(Solution.sherlockAndAnagrams("kkkk")).isEqualTo(10);
    }

    @Test
    public void test5() {
        assertThat(Solution.sherlockAndAnagrams("cdcd")).isEqualTo(5);
    }

    @Test
    public void test6() {
        assertThat(Solution.sherlockAndAnagrams("aa")).isEqualTo(1);
    }
}
