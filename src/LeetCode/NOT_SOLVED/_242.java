package LeetCode.NOT_SOLVED;

// 242. Valid Anagram

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/description/?envType=problem-list-v2&envId=sorting">...</a>
 */

public class _242 {
    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.isEmpty()) return true;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        if (Arrays.equals(sArr, tArr)) return true;

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) return false;
        }

        return true;
    }

    public static boolean isAnagramEfficient(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26]; // Assuming lowercase English letters

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
