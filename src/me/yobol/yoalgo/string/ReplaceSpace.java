package me.yobol.yoalgo.string;


/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        for (int i = 0; i < str.length(); i++) {
            System.out.println(i);
            if (str.charAt(i) == ' ') {
                str.replace(i, i + 1, "%20");
                i += 2;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace(new StringBuffer("We Are Happy")));
    }
}
