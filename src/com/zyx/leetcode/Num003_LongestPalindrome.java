package com.zyx.leetcode;

/**
 * LeetCode 005 最长回文字符串
 * tag:字符串，模拟
 * 
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 输入：s = "babad"
 * 输出："bab"
 */
public class Num003_LongestPalindrome{
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String res = "";
        int i = 1;
        while (i < s.length()) {
            int l = i - 1;
            int r = i + 1;
            String oddRes = getPalindrome(s, l, r);
            res = oddRes.length() > res.length() ? oddRes : res;

            l = i - 1;
            r = i;
            String evenRes = getPalindrome(s, l, r);
            res = evenRes.length() > res.length() ? evenRes : res;   
            i++;
        }

        return res;
    }

    private static String getPalindrome(String s, int l, int r) {
        String res = "";
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (res.length() < (r - l + 1)) {
                res = s.substring(l, r + 1);
            }
            l--; r++;
        }
        return res;
    }

    public static String longestPalindrome1(String s) {
        if (s.length() == 1) {
            return s;
        }
        String res = "";
        int i = 1;
        while (i < s.length()) {
            int l = i - 1;
            int r = i + 1;
            String oddRes = getPalindrome1(s, l, r);
            res = oddRes.length() > res.length() ? oddRes : res;

            l = i - 1;
            r = i;
            String evenRes = getPalindrome1(s, l, r);
            res = evenRes.length() > res.length() ? evenRes : res;   
            i++;
        }

        return res;
    }

    /**
     * 优化获取回文串方法
     * @param s
     * @param l
     * @param r
     * @return
     */
    private static String getPalindrome1(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return s.substring(l + 1, r);
    }    

    public static void main(String[] args) {
        String s = "babbcabc";
        String res = longestPalindrome(s);
        String res1 = longestPalindrome1(s);
        System.out.println(res);
        System.out.println(res1);
    }
}
