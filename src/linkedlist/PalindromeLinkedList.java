package linkedlist;

import java.util.Stack;

public class PalindromeLinkedList {

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
     * Approach 1: Using Stack
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isPalindromeUsingStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;
        while (current != null) {
            if (current.val != stack.pop()) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    /**
     * Approach 2: Reverse Second Half
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isPalindromeOptimal(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        // Step 3: Compare both halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    /**
     * Helper method to reverse linked list
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
        PalindromeLinkedList solution = new PalindromeLinkedList();

        // Palindrome list: 1 -> 2 -> 2 -> 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        printList(head1);
        System.out.println("Using Stack: " +
                solution.isPalindromeUsingStack(head1)); // true
        System.out.println("Optimal: " +
                solution.isPalindromeOptimal(head1)); // true

        // Not palindrome: 1 -> 2 -> 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        printList(head2);
        System.out.println("Using Stack: " +
                solution.isPalindromeUsingStack(head2)); // false
        System.out.println("Optimal: " +
                solution.isPalindromeOptimal(head2)); // false
    }
}
