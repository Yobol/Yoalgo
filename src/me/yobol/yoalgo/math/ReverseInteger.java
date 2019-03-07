package me.yobol.yoalgo.math;

/**
 * Description:
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.x
 */
public class ReverseInteger {

    /**
     * -123 % 10 = -3
     *
     * @param x  a int value to be reversed
     * @return the reversed value of the input
     */
    public int reverse1(int x) {
        long resultant = 0;
        //int sign = x >= 0 ? 1 : -1;
        //x = Math.abs(x);
        while (x != 0) {
            resultant = resultant * 10 +  x % 10;
            if (resultant < Integer.MIN_VALUE || resultant > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        //resultant *= sign;
        return (int)resultant;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int a = 123;
        System.out.println(ri.reverse1(a));
        int b = -123;
        System.out.println(ri.reverse1(b));
        int c = 0;
        System.out.println(ri.reverse1(c));
        int d = 1534236469;
        System.out.println(ri.reverse1(d));
    }
}
