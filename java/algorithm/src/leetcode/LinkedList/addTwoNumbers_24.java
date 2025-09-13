package leetcode.LinkedList;

public class addTwoNumbers_24 {
    public static void main(String[] args) {
        addTwoNumbers_24 sol = new addTwoNumbers_24();
        sol.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // TODO
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}