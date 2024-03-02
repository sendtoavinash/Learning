package com.avi.dsa;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        String s = "A man, a =plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(0, s));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (rev == x || x == rev / 10);
    }

    public static boolean isPalindrome(String s) {
//        String s = String.valueOf(s);
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) return false;
        }
        return true;
    }

    ///////// Recursion
    static boolean isPalindrome(int i, String s) {

        if (i >= s.length() / 2) return true;

        if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return isPalindrome(i + 1, s);
    }
}


