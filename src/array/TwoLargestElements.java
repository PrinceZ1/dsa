package array;

public class TwoLargestElements {
    public int[] findTwoLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > first){
                second = first;
                first = num;
            } else if(num > second && num != first){
                second = num;
            }
        }
        return new int[]{first, second};
    }

    public static void main(String[] args) {
        TwoLargestElements test = new TwoLargestElements();
        int[] arr = {1,5,3,8,7,9};
        int[] result = test.findTwoLargest(arr);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
