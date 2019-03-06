package me.yobol.yoalgo.stack;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class ImplementQueueUsing2Stacks {

    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public void push(int node) {
        pushStack.push(node);
    }

    public int pop() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

        return popStack.pop();
    }

    public static void main(String[] args) {
        ImplementQueueUsing2Stacks s = new ImplementQueueUsing2Stacks();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
