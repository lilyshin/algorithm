package leetcode.LinkedList;

public class linkedListCycle_141 {
    public static void main(String[] args) {
        linkedListCycle_141 sol = new linkedListCycle_141();
    }

//    3,2,0,-4
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head.next;      // 2
        ListNode fast = head.next.next; // 0

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; next = null; }
    }
}
