//package LeetCode;
//
//// 28. Find the Index of the First Occurrence in a String
//
///**
// <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/">...</a>
// */
//
//public class _28 {
//    public static void main(String[] args) {
//        String haystack = "sadbutsad";
//        String needle = "sad";
//        System.out.println(strStr(haystack, needle));
//    }
//
//    public static int strStr(String haystack, String needle) {
////        return haystack.indexOf(needle);
//
//        /*for (int i = 0; i < haystack.length(); i++) {
//            if (haystack.substring(i).startsWith(needle)) return i;
//        }
//
//        return -1;
//        */
//
//        int a = haystack.length();
//        int b = needle.length();
//        int ans = 0;
//        int pointer = 0;
//
//        if (haystack.equals(needle)) return 0;
//
//        for (int i = 0; i < a; i++) {
//
//            if (haystack.charAt(i) == needle.charAt(pointer)) {
//                if (pointer == 0) {
//                    ans = i;
//                }
//                pointer++;
//
//                if (pointer == b) return ans;
//            } else {
//                if (pointer > 0) i = ans;
//
//                pointer = 0;
//
//            }
//        }
//        return -1;
//    }
//}
