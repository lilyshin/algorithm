package leetcode.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedList_83 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList_83 sol = new RemoveDuplicatesFromSortedList_83();
        sol.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}