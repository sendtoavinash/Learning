package com.avi.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombination {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> numPad = new HashMap<>();
        numPad.put('2', "abc");
        numPad.put('3', "def");
        numPad.put('4', "ghi");
        numPad.put('5', "jkl");
        numPad.put('6', "mno");
        numPad.put('7', "pqrs");
        numPad.put('8', "tuv");
        numPad.put('9', "wxyz");




        return result;
    }
}
