package LeetCode;

// 58. Length of Last Word

/**
 <a href="https://leetcode.com/problems/length-of-last-word/description/">...</a>
 */

public class _58 {
    public static void main(String[] args) {
//        String s = "Hello World";
//        String s = "   fly me   to   the moon  ";
        String s = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        String trimmedStr = s.trim();
        String lastWord = trimmedStr.substring(trimmedStr.lastIndexOf(" ") + 1);
        return lastWord.length();
    }
}
