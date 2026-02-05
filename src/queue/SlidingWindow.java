package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Sliding Window Algorithm using Queue
 */
public class SlidingWindow {

    /**
     * Approach 1: Fixed Size Sliding Window
     *
     * Example:
     * arr = [1, 2, 3, 4, 5], k = 3
     * Windows:
     *  [1,2,3] -> 6
     *  [2,3,4] -> 9
     *  [3,4,5] -> 12
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    static class WindowSum {

        public void printWindowSum(int[] arr, int k) {
            if (arr == null || k <= 0 || k > arr.length) {
                return;
            }

            Queue<Integer> queue = new LinkedList<>();
            int windowSum = 0;

            for (int i = 0; i < arr.length; i++) {

                queue.offer(arr[i]);
                windowSum += arr[i];

                // Maintain window size
                if (queue.size() > k) {
                    windowSum -= queue.poll();
                }

                // Print sum when window is full
                if (queue.size() == k) {
                    System.out.println(windowSum);
                }
            }
        }
    }

    /**
     * Approach 2: Sliding Window Maximum
     **
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    static class WindowMaximum {

        public void printWindowMax(int[] arr, int k) {
            if (arr == null || k <= 0 || k > arr.length) {
                return;
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < arr.length; i++) {

                // Remove indices out of current window
                while (!queue.isEmpty() && queue.peek() <= i - k) {
                    queue.poll();
                }

                // Remove smaller elements (not useful)
                while (!queue.isEmpty() && arr[queue.peek()] < arr[i]) {
                    queue.poll();
                }

                queue.offer(i);

                // Window is ready
                if (i >= k - 1) {
                    System.out.println(arr[queue.peek()]);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println("Sliding Window Sum:");
        new WindowSum().printWindowSum(arr, k);
        // 3, -1, 1, 5, 14, 16

        System.out.println("\nSliding Window Maximum:");
        new WindowMaximum().printWindowMax(arr, k);
        // 3, 3, 5, 5, 6, 7
    }
}
