package com.avi.dsa2.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Blind 75 - String #10: Encode and Decode Strings
 * ------------------------------------------------------------------
 * Problem:
 *   Design encode/decode so a list of strings can be serialized to a single
 *   string and parsed back. The strings may contain ANY character, including
 *   whatever delimiter you might pick.
 *
 * Example:
 *   ["lint","code","love","you"] -> "4#lint4#code4#love3#you" -> original list
 *
 * Approach (length-prefix framing):
 *   A plain separator fails because the data itself could contain it. Instead
 *   prefix each string with its length and a sentinel: "<len>#<string>". To
 *   decode, read digits until '#', that tells us exactly how many following
 *   characters belong to this string, so no character is ever ambiguous.
 *
 * Complexity:
 *   Time  O(total characters) for both encode and decode, Space O(n).
 */
public class EncodeDecodeStrings {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') j++;      // read the length prefix
            int length = Integer.parseInt(s.substring(i, j));
            String str = s.substring(j + 1, j + 1 + length);
            result.add(str);
            i = j + 1 + length;                  // jump past this record
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> input = List.of("lint", "code", "love", "you");
        String encoded = encode(input);
        System.out.println(encoded);           // 4#lint4#code4#love3#you
        System.out.println(decode(encoded));   // [lint, code, love, you]

        // works even when strings contain '#' and digits
        List<String> tricky = List.of("12#ab", "");
        System.out.println(decode(encode(tricky))); // [12#ab, ]
    }
}
