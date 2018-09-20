package me.yobol.yoalgo.linkedlist;

import me.yobol.yoalgo.basic.ListNode;

import java.util.List;

/**
 * Description:
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    /**
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode resultant = new ListNode(0);
        ListNode temp = resultant;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null) temp.next = l2;
        if (l2 == null) temp.next = l1;
        return resultant.next;
    }

    private ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        //l2.next = new ListNode(3);
        //l2.next.next = new ListNode(4);
        ListNode resultant = mergeTwoSortedLists.mergeTwoListsRecursion(l1, l2);
        while (resultant != null) {
            System.out.print(resultant.val);
            if (resultant.next != null) {
                System.out.print("->");
            }
            resultant = resultant.next;
        }
    }
}
