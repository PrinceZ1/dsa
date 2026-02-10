package array;

import java.util.Arrays;

public class SetMismatch {

    /**
     * Approach: Math + Visited Array
     * --------------------------------
     * - Find the duplicated number using a boolean array
     * - Compute the missing number using sum formula
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) (ignoring output array)
     */
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];

        int duplicate = -1;
        int sum = 0;

        for (int num : nums) {
            if (seen[num]) {
                duplicate = num;
            }
            seen[num] = true;
            sum += num;
        }

        int expectedSum = n * (n + 1) / 2;
        int missing = expectedSum - (sum - duplicate);

        return new int[]{duplicate, missing};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
        // Output: [2, 3]
    }
}
