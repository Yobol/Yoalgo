package me.yobol.yoalgo.hashtable;

/**
 * Description
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in Sis a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 * Note:
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int result = 0;
        for (char c : J.toCharArray()) {
            for (char s : S.toCharArray()) {
                if (c == s) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        JewelsAndStones js = new JewelsAndStones();
        System.out.println(js.numJewelsInStones("aA", "aAAbbbb"));
    }
}
