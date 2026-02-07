package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Approach 1: Brute Force
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Approach 2: HashMap
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result1 = test.twoSumBruteForce(nums, target);
        System.out.println("Brute Force: [" + result1[0] + ", " + result1[1] + "]");

        int[] result2 = test.twoSumHashMap(nums, target);
        System.out.println("HashMap (Optimal): [" + result2[0] + ", " + result2[1] + "]");
    }
}
