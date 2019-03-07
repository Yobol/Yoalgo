package me.yobol.yoalgo.math;

public class FastPower {

    public double power(double base, int exponent) {
        if (exponent == 0) return 1;

        if (exponent < 0) {
            if (base == 0) throw new RuntimeException("分母不能为0");
            base = 1.0 / base;
            exponent = -exponent;
        }
        double result = 1.0;

        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        FastPower fastPower = new FastPower();
        System.out.println(fastPower.power(2.0, -3));
    }
}
