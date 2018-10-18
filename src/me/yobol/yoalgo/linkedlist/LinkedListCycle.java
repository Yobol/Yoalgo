package me.yobol.yoalgo.linkedlist;

import me.yobol.yoalgo.basic.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode p = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle llc = new LinkedListCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;

        System.out.println(llc.hasCycle(head));
    }
}
