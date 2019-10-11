package ru.nchernetsov.interviewPreparationKit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SherlockAndTheValidStringTest {

    @Test
    public void test1() {
        String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabc" +
                "fbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedce" +
                "decafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbc" +
                "aggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiac" +
                "cghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifa" +
                "fgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebcii" +
                "agacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieih" +
                "cichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbf" +
                "haddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfd" +
                "ehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbf" +
                "bifgidcafbfcd";
        String valid = SherlockAndTheValidString.isValid(s);
        assertThat(valid).isEqualTo("YES");
    }

    @Test
    public void test2() {
        String s = "abcdefghhgfedecba";
        String valid = SherlockAndTheValidString.isValid(s);
        assertThat(valid).isEqualTo("YES");
    }

    @Test
    public void test3() {
        String s = "aabbcd";
        String valid = SherlockAndTheValidString.isValid(s);
        assertThat(valid).isEqualTo("NO");
    }

    @Test
    public void test4() {
        String s = "aaaabbcc";
        String valid = SherlockAndTheValidString.isValid(s);
        assertThat(valid).isEqualTo("NO");
    }
}
