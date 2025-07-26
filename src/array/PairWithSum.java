package array;

import java.util.HashSet;

public class PairWithSum {
    public void findAllPairs(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        boolean found = false;

        for (int num : nums) {
            int complement = target - num;
            if (set.contains(complement)) {
                System.out.println("Found pair: " + num + " + " + complement + " = " + target);
                found = true;
            }
            set.add(num);
        }
        if (!found) {
            System.out.println("No pairs found with sum " + target);
        }
    }

    public static void main(String[] args) {
        PairWithSum obj = new PairWithSum();
        int[] arr = {1, 4, 7, 9, 12, 3, 13};
        int target = 16;
        obj.findAllPairs(arr, target);
    }
}
