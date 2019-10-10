package ru.nchernetsov.interviewPreparationKit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlternatingCharactersTest {

    @Test
    public void test1() {
        int res = AlternatingCharacters.alternatingCharacters("AAAA");
        assertThat(res).isEqualTo(3);
    }

    @Test
    public void test2() {
        int res = AlternatingCharacters.alternatingCharacters("BBBBB");
        assertThat(res).isEqualTo(4);
    }

    @Test
    public void test3() {
        int res = AlternatingCharacters.alternatingCharacters("ABABABAB");
        assertThat(res).isEqualTo(0);
    }

    @Test
    public void test4() {
        int res = AlternatingCharacters.alternatingCharacters("BABABA");
        assertThat(res).isEqualTo(0);
    }

    @Test
    public void test5() {
        int res = AlternatingCharacters.alternatingCharacters("AAABBB");
        assertThat(res).isEqualTo(4);
    }
}
