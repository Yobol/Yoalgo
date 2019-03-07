package me.yobol.yoalgo.linkedlist;

import me.yobol.yoalgo.basic.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;

        ListNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }

        if (k <= 0) {
            cur = head;
            while (k++ != 0) {
                cur = cur.next;
            }
            return cur;
        }
        return null;
    }

    /**
     * 两个指针，先让第一个指针和第二个指针都指向头结点，
     * 然后再让第一个指针走k-1步，到达第k个节点。
     * 然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了
     */
    public ListNode findKthToTail1(ListNode head, int k) {
        if (head == null || k < 1) return null;
        ListNode right = head, left = head;
        // 让right向后移动k - 1个位置
        while (k-- > 1) {
            right = right.next;
        }
        if (right == null) return null;
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        return left;
    }

    public static void main(String[] args) {
        FindKthToTail s = new FindKthToTail();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(s.findKthToTail1(head, 2).val);
    }
}
