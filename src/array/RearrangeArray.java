package array;

import java.util.Arrays;

public class RearrangeArray {
    public void rearrange(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + (arr[arr[i]] % n) * n;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
    }

    public static void main(String[] args) {
        RearrangeArray obj = new RearrangeArray();
        int[] arr = {3, 2, 0, 1};
        obj.rearrange(arr);
        System.out.println("Rearranged array: " + Arrays.toString(arr));
    }
}
