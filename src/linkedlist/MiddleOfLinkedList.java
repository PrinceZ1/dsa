package linkedlist;

public class MiddleOfLinkedList {

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
     * Approach 1: Two Pass Solution
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode middleTwoPass(ListNode head) {
        int count = 0;
        ListNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        int mid = count / 2;
        current = head;

        for (int i = 0; i < mid; i++) {
            current = current.next;
        }

        return current;
    }

    /**
     * Approach 2: Fast and Slow Pointers
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode middleFastSlow(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MiddleOfLinkedList solution = new MiddleOfLinkedList();

        // Create list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        System.out.println("\nMiddle (Two Pass):");
        System.out.println(solution.middleTwoPass(head).val); // 3

        System.out.println("\nMiddle (Fast & Slow):");
        System.out.println(solution.middleFastSlow(head).val); // 3
    }
}
