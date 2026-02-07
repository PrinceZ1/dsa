package array;

public class MoveZeroes {

    /**
     * Approach 1: Brute Force
     * For every zero, shift elements to the left
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    static class BruteForce {

        public void moveZeroes(int[] nums) {
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    for (int j = i; j < n - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    nums[n - 1] = 0;
                    i--; // re-check current index
                    n--;
                }
            }
        }
    }

    /**
     * Approach 2: Two Pass
     * First pass: copy non-zero elements
     * Second pass: fill remaining with zero
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static class TwoPass {

        public void moveZeroes(int[] nums) {
            int index = 0;

            // Copy non-zero elements
            for (int num : nums) {
                if (num != 0) {
                    nums[index++] = num;
                }
            }

            // Fill remaining with zero
            while (index < nums.length) {
                nums[index++] = 0;
            }
        }
    }

    /**
     * Approach 3: One Pass
     * Use two pointers and swap
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static class OnePassOptimal {

        public void moveZeroes(int[] nums) {
            int slow = 0;

            for (int fast = 0; fast < nums.length; fast++) {
                if (nums[fast] != 0) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                    slow++;
                }
            }
        }
    }

    private static void printArray(int[] nums) {
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr1 = {0, 1, 0, 3, 12};
        new BruteForce().moveZeroes(arr1);
        System.out.println("Brute Force:");
        printArray(arr1); // [1, 3, 12, 0, 0]

        int[] arr2 = {0, 1, 0, 3, 12};
        new TwoPass().moveZeroes(arr2);
        System.out.println("\nTwo Pass:");
        printArray(arr2); // [1, 3, 12, 0, 0]

        int[] arr3 = {0, 1, 0, 3, 12};
        new OnePassOptimal().moveZeroes(arr3);
        System.out.println("\nOne Pass Optimal:");
        printArray(arr3); // [1, 3, 12, 0, 0]
    }
}
