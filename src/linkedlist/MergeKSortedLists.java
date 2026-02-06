package linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedLists {

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
     * Approach 1: Brute Force (Collect & Sort)
     *
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public ListNode mergeBruteForce(ListNode[] lists) {
        java.util.List<Integer> values = new java.util.ArrayList<>();

        for (ListNode head : lists) {
            while (head != null) {
                values.add(head.val);
                head = head.next;
            }
        }

        if (values.isEmpty()) return null;

        values.sort(Integer::compareTo);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    /**
     * Approach 2: Min Heap (Priority Queue)
     *
     * Time Complexity: O(N log k)
     * Space Complexity: O(k)
     */
    public ListNode mergeUsingHeap(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    /**
     * Approach 3: Divide and Conquer
     *
     * Time Complexity: O(N log k)
     * Space Complexity: O(1)
     */
    public ListNode mergeDivideAndConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    /**
     * Helper: Merge two sorted lists
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
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
        MergeKSortedLists solution = new MergeKSortedLists();

        // Create lists:
        // [1 -> 4 -> 5]
        // [1 -> 3 -> 4]
        // [2 -> 6]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        System.out.println("Merge using Min Heap:");
        printList(solution.mergeUsingHeap(lists));

        // Re-create lists for divide & conquer
        lists = new ListNode[]{
                new ListNode(1),
                new ListNode(1),
                new ListNode(2)
        };
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2].next = new ListNode(6);

        System.out.println("\nMerge using Divide & Conquer:");
        printList(solution.mergeDivideAndConquer(lists));
    }
}
