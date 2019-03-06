package me.yobol.yoalgo.bit;

public class NumOf1 {

    public int NumOf1(int n) {
        int ctn = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ctn += 1;
            }
            n >>>= 1;
        }
        return ctn;
    }

    public static void main(String[] args) {
        NumOf1 s = new NumOf1();
        System.out.println(s.NumOf1(-31));
    }
}
