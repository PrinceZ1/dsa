package array;

import java.util.Arrays;

public class ShuffleTheArray {
    public int[] shuffle (int[] nums, int n){
        int l = nums.length;
        int[] ans = new int[l];

        for(int i=0; i<n; i++){
            ans[2*i] = nums[i];
            ans[2*i+1] = nums[i+n];
        }
        return ans;
    }

    public static void main(String[] args) {
        ShuffleTheArray test = new ShuffleTheArray();
        int[] arr = {2,5,1,3,4,7};
        int n = 3;

        System.out.println(Arrays.toString(test.shuffle(arr, n)));
    }
}
