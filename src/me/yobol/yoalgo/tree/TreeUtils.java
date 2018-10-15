package me.yobol.yoalgo.tree;

import java.util.List;

public class TreeUtils {

    /**
     * print list contains lists that contain integers
     *  [
     *      [3],
     *      [9,20],
     *      [15,7]
     * ]
     * @param outer
     */
    public static void print(List<List<Integer>> outer) {
        System.out.println("[");
        int outerSize = outer.size();
        for (List<Integer> inner : outer) {
            int innerSize = inner.size();
            System.out.print("\t[");
            for (Integer i : inner) {
                System.out.print(i);
                if (--innerSize > 0)
                    System.out.print(",");
            }
            System.out.print("]");
            if (--outerSize > 0){
                System.out.println(",");
            }else {
                System.out.println();
            }
        }
        System.out.println("]");
    }
}
