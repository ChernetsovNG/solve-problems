package ru.nchernetsov.interviewPreparationKit;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        char first = chars[0];
        char next = first == 'A' ? 'B' : 'A';
        for (int i = 1; i < chars.length; i++) {
            char ch = chars[i];
            if (ch != next) {
                count++;
            } else {
                next = ch == 'A' ? 'B' : 'A';
            }
        }
        return count;
    }
}
