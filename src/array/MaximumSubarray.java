package array;

public class MaximumSubarray {

    /**
     * Approach 1: Brute Force
     * --------------------------------
     * Check the sum of every possible subarray.
     *
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public int maxSubArrayBruteForce(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currentSum = 0;
                for (int k = i; k <= j; k++) {
                    currentSum += arr[k];
                }
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    /**
     * Approach 2: Improved Brute Force (Prefix Sum)
     * --------------------------------
     * Use prefix sums to avoid recomputing subarray sums.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public int maxSubArrayPrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int currentSum = prefix[j] - prefix[i];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    /**
     * Approach 3: Kadane's Algorithm (Optimal)
     * --------------------------------
     * At each position, decide whether to:
     * - extend the previous subarray
     * - or start a new subarray from current element
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxSubArrayKadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        MaximumSubarray test = new MaximumSubarray();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Brute Force: " + test.maxSubArrayBruteForce(arr));
        System.out.println("Prefix Sum: " + test.maxSubArrayPrefixSum(arr));
        System.out.println("Kadane (Optimal): " + test.maxSubArrayKadane(arr));
    }
}
