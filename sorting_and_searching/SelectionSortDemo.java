// time complexity of O(n^2)
// compares starting index data with adjacent index, then moves up to later indeces to record the min value
// after min is determined, starting index + 1 and sorting continues

public class SelectionSortDemo {

    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 3, 6, 4, 9, 8, 2};
        selectionSort(arr);

        for(int x: arr) {
            System.out.println(x);
        }
    }
}