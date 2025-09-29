// slow for larger datasets, ideal for small to mid-sized datasets
public class LinearSearchDemo {
    private static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        int[] arr = {9, 1, 8, 2, 7, 3, 6, 4, 5};

        // int index = linearSearch(arr, 1);
        System.out.println(linearSearch(arr, 6));
    }   

    
}