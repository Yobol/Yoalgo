package me.yobol.yoalgo.linkedlist;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class PrintListFormTailToHead {

    public ArrayList<Integer> printListFormTailToHead(ListNode listNode) {

        ArrayList<Integer> array = new ArrayList<>();
        if (listNode == null) {
            return array;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = listNode;
        ListNode prev = dummy.next;
        ListNode cur = prev.next;

        while (cur != null) {
            prev.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = prev.next;
        }


        dummy = dummy.next;
        while (dummy != null) {
            array.add(dummy.val);
            dummy = dummy.next;
        }
        return array;
    }

    public static void main(String[] args) {
        PrintListFormTailToHead printListFormTailToHead = new PrintListFormTailToHead();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ArrayList<Integer> array = printListFormTailToHead.printListFormTailToHead(null);
        for (Integer i: array) {
            System.out.println(i);
        }
    }

}
