//package LeetCode;
//
//// 67. Add Binary
//
///**
// <a href="https://leetcode.com/problems/add-binary/description/">...</a>
// */
//
//public class _67 {
//    public static void main(String[] args) {
//        String a = "11", b = "1";
//        System.out.println(addBinary(a, b));
//    }
//
//    public static String addBinary(String a, String b) {
//        StringBuilder result = new StringBuilder();
//        int i = a.length() - 1, j = b.length() - 1, carry = 0;
//
//        while (i >= 0 || j >= 0 || carry > 0) {
//            if (i >= 0) carry += a.charAt(i--) - '0';
//            if (j >= 0) carry += b.charAt(j--) - '0';
//            result.insert(0, carry % 2);
//            carry /= 2;
//        }
//
//        return result.toString();
//    }
//}
