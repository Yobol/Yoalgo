package me.yobol.yoalgo.string;

public class ReverseString {


    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.print(rs.reverseString("Hello"));
    }
}
