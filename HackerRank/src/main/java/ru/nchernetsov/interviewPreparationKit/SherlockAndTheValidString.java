package ru.nchernetsov.interviewPreparationKit;

import java.util.Arrays;

public class SherlockAndTheValidString {

    private static final String YES = "YES";
    private static final String NO = "NO";

    static String isValid(String s) {
        if (s.isEmpty()) {
            return NO;
        }
        if (s.length() <= 3) {
            return YES;
        }

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        Arrays.sort(letters);
        int i = 0;
        while (letters[i] == 0) {
            i++;
        }

        //System.out.println(Arrays.toString(letters));
        int min = letters[i];   //the smallest frequency of some letter
        int max = letters[25]; // the largest frequency of some letter
        if (min == max) {
            return YES;
        } else {
            // remove one letter at higher frequency or the lower frequency
            if ((max - min == 1 && max > letters[24]) || (min == 1 && letters[i + 1] == max)) {
                return YES;
            }
        }
        return NO;
    }
}
