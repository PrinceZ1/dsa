package linkedlist;

public class MergeTwoSortedLists {

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
     * Approach 1: Iterative (Dummy Node)
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public ListNode mergeIterative(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    /**
     * Approach 2: Recursive
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m) (recursion stack)
     */
    public ListNode mergeRecursive(ListNode l1, ListNode l2) {
        // Base cases
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeRecursive(l1, l2.next);
            return l2;
        }
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
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // List 1: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // List 2: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.println("Merged (Iterative):");
        ListNode merged1 = solution.mergeIterative(l1, l2);
        printList(merged1); // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

        // Re-create lists for recursive test
        l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.println("\nMerged (Recursive):");
        ListNode merged2 = solution.mergeRecursive(l1, l2);
        printList(merged2);
    }
}
