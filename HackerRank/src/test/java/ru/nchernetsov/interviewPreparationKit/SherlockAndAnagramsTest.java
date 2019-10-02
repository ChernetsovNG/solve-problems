package ru.nchernetsov.interviewPreparationKit;

import org.junit.Test;
import ru.nchernetsov.interviewPreparationKit.SherlockAndAnagrams;

import static org.assertj.core.api.Assertions.assertThat;

public class SherlockAndAnagramsTest {

    @Test
    public void test1() {
        assertThat(SherlockAndAnagrams.sherlockAndAnagrams("abba")).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(SherlockAndAnagrams.sherlockAndAnagrams("abcd")).isEqualTo(0);
    }

    @Test
    public void test3() {
        assertThat(SherlockAndAnagrams.sherlockAndAnagrams("ifailuhkqq")).isEqualTo(3);
    }

    @Test
    public void test4() {
        assertThat(SherlockAndAnagrams.sherlockAndAnagrams("kkkk")).isEqualTo(10);
    }

    @Test
    public void test5() {
        assertThat(SherlockAndAnagrams.sherlockAndAnagrams("cdcd")).isEqualTo(5);
    }

    @Test
    public void test6() {
        assertThat(SherlockAndAnagrams.sherlockAndAnagrams("aa")).isEqualTo(1);
    }
}
