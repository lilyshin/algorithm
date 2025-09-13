package leetcode.LinkedList;

public class SwapNodesInPairs_24 {
    public static void main(String[] args) {
        SwapNodesInPairs_24 sol = new SwapNodesInPairs_24();
        sol.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = head.next;
        // TODO
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