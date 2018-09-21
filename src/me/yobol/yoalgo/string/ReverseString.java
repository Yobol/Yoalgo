package me.yobol.yoalgo.string;

public class ReverseString {

    private String reverseString1(String s) {
        // StringBuilder
        //return new StringBuilder(s).reverse().toString();
        StringBuilder sb = new StringBuilder(s);
        int i;
        for (i = s.length() - 1;i >= 0;i--){
            sb.append(s.charAt(i));
        }
        return sb.substring(s.length());
    }

    /**
     * Two Pointers
     *
     * @param s
     * @return
     */
    private String reverseString2(String s) {
        if (s == null) return null;
        int i = 0,j = s.length() - 1;
        char[] cs = s.toCharArray();
        while(i < j){
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
            i++;
            j--;
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.print(rs.reverseString2("Hello"));
    }
}
