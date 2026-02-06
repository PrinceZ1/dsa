package linkedlist;

import java.util.HashSet;

public class LinkedListCycle {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Approach 1: HashSet
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean hasCycleUsingHashSet(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();

        ListNode current = head;
        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }

        return false;
    }

    /**
     * Approach 2: Fast and Slow Pointers (Floyd's Cycle Detection)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean hasCycleFastSlow(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // Create list: 1 -> 2 -> 3 -> 4 -> (points back to 2)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next; // cycle

        System.out.println("Has cycle (HashSet): " +
                solution.hasCycleUsingHashSet(head)); // true

        System.out.println("Has cycle (Fast & Slow): " +
                solution.hasCycleFastSlow(head)); // true

        // Create list without cycle: 1 -> 2 -> 3 -> null
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println("\nHas cycle (Fast & Slow): " +
                solution.hasCycleFastSlow(head2)); // false
    }
}
