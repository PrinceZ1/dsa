package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class MajorityElement {

    /**
     * Approach 1: Brute Force
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int majorityElementBruteForce(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * Approach 2: HashMap Counting
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }

    /**
     * Approach 3: Sorting
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) (ignoring sorting internals)
     */
    public int majorityElementSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Approach 4: Boyer-Moore Voting Algorithm (Optimal)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int majorityElementBoyerMoore(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Brute Force: " + test.majorityElementBruteForce(nums));
        System.out.println("HashMap: " + test.majorityElementHashMap(nums));
        System.out.println("Sorting: " + test.majorityElementSorting(nums));
        System.out.println("Boyer-Moore (Optimal): " + test.majorityElementBoyerMoore(nums));
    }
}
