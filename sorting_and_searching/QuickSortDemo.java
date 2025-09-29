public class QuickSortDemo {

    private static void quickSort(int[] arr, int start, int end) {
        if(end <= start) return; // base case

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for(int j = start; j <= end - 1; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }

    public static void main(String[] args) {
        int arr[] = {8, 2, 5, 3, 9, 4, 7, 6, 1};
        quickSort(arr, 0, arr.length - 1);

        for(int x: arr) {
            System.out.println(x + " ");
        }    
    }
}