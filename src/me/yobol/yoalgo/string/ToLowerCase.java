package me.yobol.yoalgo.string;

/**
 * Description：
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 * Example 1:
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * Input: "here"
 * Output: "here"
 * Example 3:
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class ToLowerCase {

    private String toLowerCase(String str) {
        if (str == null) return null;
        char[] cs = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if ('A' <= cs[i] && cs[i] <= 'Z') {
                cs[i] += 32;
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        ToLowerCase tlc = new ToLowerCase();
        System.out.print(tlc.toLowerCase("Hello!"));
    }
}
