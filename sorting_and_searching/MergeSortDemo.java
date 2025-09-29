// recursivce function that divides array into 2 sub arrays, and then divides again and again
// stops when all sub arrays have a size of 1
// then we merge with helper function accepting left, right, and original sub arrays. puts them back into original array in order
// time complexity of O(n log n)
// uses O(n) space complexity 

public class MergeSortDemo {

    public static void mergeSort(int[] arr) {
        int length = arr.length;

        if(length <= 1) { // base case
            return;
        }

        int middle = length/2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];

        int i = 0; // left array
        int j = 0; // right array

        for(; i < length; i++) {
            if(i < middle) {
                leftArr[i] = arr[i];
            }
            else {
                rightArr[j] = arr[i];
                j++;
            }
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);
    }

    public static void merge(int[] leftArr, int[] rightArr, int[] arr) {
        int leftSize = arr.length/2;
        int rightSize = arr.length - leftSize;
        int i = 0, l = 0, r = 0; // indices

        // check conditions for merging
        while(l < leftSize && r < rightSize) {
            if(leftArr[l] < rightArr[r]) {
                arr[i] = leftArr[l];
                i++;
                l++;
            }
            else {
                arr[i] = rightArr[r];
                i++;
                r++;
            }
        }
        while(l < leftSize) {
                arr[i] = leftArr[l];
                i++;
                l++;
        }
        while(r < rightSize) {
            arr[i] = rightArr[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 7, 8, 5, 4, 2, 6, 1};
        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+ " ");
        }
    }
}