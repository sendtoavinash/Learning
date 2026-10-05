package com.avi.dsa2.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Blind 75 - String #6: Valid Parentheses
 * ------------------------------------------------------------------
 * Problem:
 *   Given a string of just '()[]{}', determine if the brackets are balanced:
 *   every opener is closed by the matching type in the correct order.
 *
 * Example:
 *   "()[]{}" -> true
 *   "(]"     -> false
 *   "([)]"   -> false
 *
 * Approach (stack):
 *   Push every opening bracket. On a closing bracket, the top of the stack must
 *   be its matching opener; if the stack is empty or the top does not match,
 *   it is invalid. At the end the stack must be empty (no unclosed openers).
 *   A stack naturally enforces the "most recently opened is first to close"
 *   ordering.
 *
 * Complexity:
 *   Time  O(n), Space O(n).
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': stack.push(')'); break;
                case '[': stack.push(']'); break;
                case '{': stack.push('}'); break;
                default: // a closing bracket
                    if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]"));     // false
        System.out.println(isValid("([)]"));   // false
        System.out.println(isValid("{[]}"));   // true
    }
}
