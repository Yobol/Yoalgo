package me.yobol.yoalgo.stack;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 注意：这两个序列的长度是相等的。
 */
public class HasPopOrder {

    public boolean hasPopOrder(int[] pushOrder, int[] popOrder) {
        Stack<Integer> stack = new Stack<>();
        int push = 0;
        int pop = 0;
        int n = pushOrder.length;
        while (pop < n) {
            if (push < n && pushOrder[push] == popOrder[pop]) {
                push++;
                pop++;
            } else {
                if (stack.isEmpty()) {
                    stack.push(pushOrder[push++]);
                } else if (stack.peek() == popOrder[pop]) {
                    pop++;
                    stack.pop();
                } else if (push < n){
                    stack.push(pushOrder[push++]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HasPopOrder s = new HasPopOrder();
        int[] pushOrder = {1, 2, 3, 4, 5};
//        int[] popOrder = {1, 2, 3, 4, 5}; // true
        int[] popOrder = {4, 3, 5, 1, 2}; // false
//        int[] popOrder = {4, 5, 3, 2, 1}; // true
        System.out.println(s.hasPopOrder(pushOrder, popOrder));
    }
}
