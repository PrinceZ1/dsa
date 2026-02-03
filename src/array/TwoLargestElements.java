package array;

import java.util.Arrays;

public class TwoLargestElements {

    /**
     * Approach 1: Sorting
     * --------------------------------
     * Sort the array and pick the last two elements.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) (ignoring sorting space)
     *
     * This approach is simple but NOT optimal
     * because sorting is unnecessary.
     */
    public int[] findTwoLargestBySorting(int[] arr) {
        Arrays.sort(arr);
        return new int[]{arr[arr.length - 1], arr[arr.length - 2]};
    }

    /**
     * Approach 2: Two separate traversals
     * --------------------------------
     * First traversal finds the largest element.
     * Second traversal finds the second largest element.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * This is better than sorting but still
     * requires two passes.
     */
    public int[] findTwoLargestTwoPass(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // First pass: find the largest
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }

        // Second pass: find the second largest
        for (int num : arr) {
            if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        return new int[]{largest, secondLargest};
    }

    /**
     * Approach 3: Single traversal (Optimal)
     * --------------------------------
     * Maintain two variables:
     * - first: the largest element so far
     * - second: the second largest element so far
     *
     * Update them while traversing the array only once.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * This is the optimal solution and
     * commonly expected in interviews.
     */
    public int[] findTwoLargestSinglePass(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        return new int[]{first, second};
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        TwoLargestElements test = new TwoLargestElements();
        int[] arr = {1, 5, 3, 8, 7, 9};

        int[] r1 = test.findTwoLargestBySorting(arr.clone());
        System.out.println("Sorting approach: " + r1[0] + ", " + r1[1]);

        int[] r2 = test.findTwoLargestTwoPass(arr);
        System.out.println("Two-pass approach: " + r2[0] + ", " + r2[1]);

        int[] r3 = test.findTwoLargestSinglePass(arr);
        System.out.println("Single-pass approach: " + r3[0] + ", " + r3[1]);
    }
}
