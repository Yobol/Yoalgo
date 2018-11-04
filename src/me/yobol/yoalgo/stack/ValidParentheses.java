package me.yobol.yoalgo.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Description:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * Input: "(]"
 * Output: false
 * Example 4:
 * Input: "([)]"
 * Output: false
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    private Map<Character, Character> mappings;

    public ValidParentheses() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i++) {
            Character c = s.charAt(i);
            // If the current character is closing bracket, pop the top element of stack
            if (this.mappings.containsKey(c)) {
                // Get the top element of stack, if the stack is empty, set a dummy value of '#'.
                Character top = stack.isEmpty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (top != this.mappings.get(c)) {
                    return false;
                }

            } else { // the current character is opening bracket
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is the invalid expression.
        return stack.isEmpty();
    }

    /**
     * If we encounter an opening bracket(circle,square or curly),
     * then we wish encounter its corresponding bracket when bracket we encounter isn't opening
     * (so we push its corresponding bracket into stack rather than itself).
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();

        String target = "";
        System.out.println(vp.isValid2(target)); // true

        target = "()";
        System.out.println(vp.isValid2(target)); // true

        target = "()[]{}";
        System.out.println(vp.isValid2(target)); // true

        target = "(]";
        System.out.println(vp.isValid2(target)); // false

        target = "([)]";
        System.out.println(vp.isValid2(target)); // false

        target = "{[]}";
        System.out.println(vp.isValid2(target)); //true
    }
}
