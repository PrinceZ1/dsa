package array;

public class Rotate {
    public void Rotate(int[] arr, int k) {
        int n = arr.length;
        if(n==0 || k%n == 0){
            return;
        }
        k=k%n;
        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Rotate r = new Rotate();
        int[] arr = {1,2,3,4,5};
        int k = 2;
        r.Rotate(arr, k);
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
