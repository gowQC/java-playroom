// runtime of O(n^2)
// checks each index with adjacent index, determines if they need to be swapped, then moves to next pair of indeces to check

public class BubbleSortDemo {
    public static void bubbleSortAscending(int[] arr) {
        for(int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // ascending order
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDescending(int[] arr) {
        for(int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // descending order
                if(arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        

        int arr[] = {9, 1, 8, 2, 7, 3, 6, 4, 5};

        bubbleSortAscending(arr);
        for(int i: arr) {
            System.out.println(i);
        }

        System.out.println("==============");

        bubbleSortDescending(arr);
        for(int i: arr) {
            System.out.println(i);
        }
    }
}