import java.util.Arrays;

public class BinarySearchDemo {

    // our own binary search
    private static int binarySearch(int[] arr, int target) {

        // creating our range
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int middle = low + (high - low) / 2;
            int value = arr[middle];

            if(value < target) {
                low = middle + 1;
            }
            else if(value > target) {
                high = middle - 1;
            }
            else { // target found
                return middle;
            }
        }

        return -1; // target not found, sentinal value of -1
    }

    public static void main (String[] args) {
        int arr[] = new int[100];
        int target = 99;

        // just to fill array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int index = binarySearch(arr, target);

        System.out.println(index);
    }
}