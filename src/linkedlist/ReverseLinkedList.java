package linkedlist;

public class ReverseLinkedList {

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
     * Approach 1: Iterative (Using three pointers)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // store next node
            curr.next = prev;          // reverse link
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        return prev; // new head
    }

    /**
     * Approach 2: Recursive
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) (recursion stack)
     */
    public ListNode reverseRecursive(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseRecursive(head.next);

        head.next.next = head; // reverse the link
        head.next = null;      // break original link

        return newHead;
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
        ReverseLinkedList solution = new ReverseLinkedList();

        // Create list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);

        // Iterative reverse
        head = solution.reverseIterative(head);
        System.out.println("\nReversed (Iterative):");
        printList(head);

        // Recursive reverse (reverse back)
        head = solution.reverseRecursive(head);
        System.out.println("\nReversed Back (Recursive):");
        printList(head);
    }
}
