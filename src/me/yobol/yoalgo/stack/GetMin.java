package me.yobol.yoalgo.stack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class GetMin {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int n) {
        if (this.minStack.isEmpty()) {
            this.minStack.push(n);
        } else if (n <= this.minStack.peek()) {
            this.minStack.push(n);
        }
        this.dataStack.push(n);
    }

    public int pop() {
        if (this.dataStack.isEmpty()) throw new RuntimeException("Your stack is empty!");
        int res = this.dataStack.pop();
        if (res == this.minStack.peek()) {
            this.minStack.pop();
        }
        return res;
    }

    public int getMin() {
        if (this.minStack.isEmpty()) throw new RuntimeException("Your stack is empty!");
        return this.minStack.peek();
    }

    public static void main(String[] args) {
        GetMin s = new GetMin();
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(4);
        s.push(5);
        System.out.println(s.getMin());
    }
}
