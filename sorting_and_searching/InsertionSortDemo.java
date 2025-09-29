// compares elements to the left of an index and it will shift elements to the right to make room to insert a value
// time complexity of O(n^2)
// decent small data sets, bad with large data sets
// less steps than bubble sort, best case scenario of O(n) compared to selection sort's O(n^2)

public class InsertionSortDemo {
    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {6, 1, 7, 4, 2, 9, 8, 5, 3};
        insertionSort(arr);
        
        for (int x: arr) {
            System.out.println(x);
        }
    }
}