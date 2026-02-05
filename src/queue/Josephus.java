package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Josephus Problem using Queue
 *
 * Problem:
 * n people stand in a circle.
 * Every k-th person is eliminated until only one remains.
 */
public class Josephus {

    /**
     * Approach 1: Queue Simulation
     *
     * Idea:
     *  - Put all people (1..n) into a queue
     *  - Rotate (k-1) times by dequeue + enqueue
     *  - Dequeue the k-th person (eliminated)
     *
     * Time Complexity: O(n * k)
     * Space Complexity: O(n)
     */
    static class QueueSolution {

        public int findWinner(int n, int k) {
            if (n <= 0 || k <= 0) {
                return -1;
            }

            Queue<Integer> queue = new LinkedList<>();

            // Initialize people
            for (int i = 1; i <= n; i++) {
                queue.offer(i);
            }

            // Elimination process
            while (queue.size() > 1) {

                // Move first (k-1) people to the back
                for (int i = 1; i < k; i++) {
                    queue.offer(queue.poll());
                }

                // Eliminate k-th person
                queue.poll();
            }

            // Last remaining person
            return queue.peek();
        }
    }

    /**
     * Approach 2: Optimized for Understanding
     * Same logic, clearer steps for explanation
     */
    static class VerboseQueueSolution {

        public int findWinner(int n, int k) {
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                queue.offer(i);
            }

            int count = 1;

            while (queue.size() > 1) {
                int current = queue.poll();

                if (count == k) {
                    // Person eliminated
                    count = 1;
                } else {
                    queue.offer(current);
                    count++;
                }
            }

            return queue.peek();
        }
    }

    public static void main(String[] args) {

        int n = 7;
        int k = 3;

        QueueSolution solution1 = new QueueSolution();
        System.out.println("Winner (Queue Simulation): "
                + solution1.findWinner(n, k)); // 4

        VerboseQueueSolution solution2 = new VerboseQueueSolution();
        System.out.println("Winner (Verbose Simulation): "
                + solution2.findWinner(n, k)); // 4
    }
}
