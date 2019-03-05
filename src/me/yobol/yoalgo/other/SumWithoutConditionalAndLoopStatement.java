package me.yobol.yoalgo.other;

public class SumWithoutConditionalAndLoopStatement {

    public int shortCircuitSum(int n) {
        int result = n;
        boolean tmp = (result != 0) && (result += shortCircuitSum(n - 1)) > 0;
        return result;
    }

    public static void main(String[] args) {
        SumWithoutConditionalAndLoopStatement s = new SumWithoutConditionalAndLoopStatement();
        System.out.println(s.shortCircuitSum(5));
    }
}
