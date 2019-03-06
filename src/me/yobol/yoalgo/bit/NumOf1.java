package me.yobol.yoalgo.bit;

public class NumOf1 {

    public int NumOfOne1(int n) {
        int ctn = 0;
        while (n != 0) {
            ctn += n & 1;
            n >>>= 1;
        }
        return ctn;
    }

    public int NumOfOne2(int n) {
        int ctn = 0;
        while (n != 0) {
            // 抹除掉n最右边的1
            n &= (n - 1);
            ctn++;
        }
        return ctn;
    }

    public static void main(String[] args) {
        NumOf1 s = new NumOf1();
        System.out.println(s.NumOfOne1(-31));
    }
}
