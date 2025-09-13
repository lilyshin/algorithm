package leetcode.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class middleOfTheLinkedList_876 {
    public static void main(String[] args) {
        middleOfTheLinkedList_876 sol = new middleOfTheLinkedList_876();
        sol.middleNode(new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        List<ListNode> list = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            list.add(cur);
        }

        return list.get(list.size() / 2);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
