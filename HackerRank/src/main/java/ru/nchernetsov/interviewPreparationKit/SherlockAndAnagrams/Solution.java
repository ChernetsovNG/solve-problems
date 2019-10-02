package ru.nchernetsov.interviewPreparationKit.SherlockAndAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final int A_CHAR_CODE = 'a';
    private static final int ALPHABET_LEN = 26;

    static int sherlockAndAnagrams(String s) {
        int len = s.length();
        // ключ - хеш-код от сигнатуры строки, значение - кол-во подстрок с такой сигнатурой
        Map<Integer, Integer> signatures = new HashMap<>();
        // цикл по всем подстрокам s
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String substr = s.substring(i, j + 1);
                int signature = signature(substr);
                signatures.merge(signature, 1, Integer::sum);
            }
        }
        int overallCount = 0;
        for (Integer count : signatures.values()) {
            overallCount += count * (count - 1) / 2;
        }
        return overallCount;
    }

    static int sherlockAndAnagrams2(String s) {
        int overallCount = 0;
        int len = s.length();
        int substrLen = 1;
        while (substrLen < len) {
            int toIndex = len - substrLen + 1;
            for (int i = 0; i < toIndex; i++) {
                String substr1 = s.substring(i, i + substrLen);
                for (int j = i + 1; j < toIndex; j++) {
                    String substr2 = s.substring(j, j + substrLen);
                    if (areAnagrams(substr1, substr2)) {
                        overallCount++;
                    }
                }
            }
            substrLen++;
        }
        return overallCount;
    }

    private static int signature(String str) {
        int[] signature = new int[ALPHABET_LEN];
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            int chIndex = (int) ch - A_CHAR_CODE;
            signature[chIndex] += 1;
        }
        return Arrays.hashCode(signature);
    }

    private static boolean areAnagrams(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        if (n1 != n2) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < n1; i++) {
            if (chars1[i] != chars2[i])
                return false;
        }

        return true;
    }
}
