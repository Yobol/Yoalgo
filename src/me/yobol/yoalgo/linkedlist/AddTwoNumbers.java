package me.yobol.yoalgo.linkedlist;

import me.yobol.yoalgo.basic.ListNode;

/**
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0), current = header;
        int currentSum = 0;
        while (l1 != null && l2 != null) {
            currentSum = l1.val + l2.val + currentSum / 10;
            current.next = new ListNode(currentSum - 10 * (currentSum / 10));

            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }

        while (l1 != null) {
            currentSum = l1.val + currentSum / 10;
            l1.val = currentSum - 10 * (currentSum / 10);
            current.next = l1;

            l1 = l1.next;
            current = current.next;
        }
        while (l2 != null) {
            currentSum = l2.val + currentSum / 10;
            l2.val = currentSum - 10 * (currentSum / 10);
            current.next = l2;

            l2 = l2.next;
            current = current.next;
        }
        if (currentSum >= 10) {
            current.next = new ListNode(1);
        }
        return header.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0), current = header;
        int currentDigit = 0;

        while (l1 != null || l2 != null || currentDigit != 0) {
            if (l1 != null) {
                currentDigit += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                currentDigit += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(currentDigit % 10);
            currentDigit /= 10;
            current = current.next;
        }

        return header.next;

    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(9);
        //l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);
        ListNode resultant = atn.addTwoNumbers2(l1, l2);
        while (resultant != null) {
            System.out.print(resultant.val);
            resultant = resultant.next;
        }

    }
}
