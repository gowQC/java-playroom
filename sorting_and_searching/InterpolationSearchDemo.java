// improvement of binary search based on "uniformly" distributed data
// "guesses" where a value might be based on calculated probe results
// if probe is incorrect, search area is narrowed, and a new probe is calculated

// average time complexity: O(log(log(n)))
// worst case time complexity: O(n) 

public class InterpolationSearchDemo {

    private static int interpolationSearch(int[] arr, int value) {
        int high = arr.length - 1;
        int low = 0;

        while(value >= arr[low] && value <= arr[high] && low <= high) {
            int probe = low + (high - low) * (value - arr[low]) / (arr[high] - arr[low]);
            System.out.println("Probe: " + probe);
            if(arr[probe]  == value) {
                return probe;
            }
            else if(arr[probe] < value) {
                low = probe + 1;
            }
            else {
                high = probe - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int easy[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int easyIndex = interpolationSearch(easy, 8);
        if(easyIndex != -1) {
            System.out.println("Element found at index: " + easyIndex);
        }
        else {
            System.out.println("Element not found.");
        }
        
        System.out.println("============");
        
        int hard[] = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        int hardIndex = interpolationSearch(hard, 256);
        if(hardIndex != -1) {
            System.out.println("Element found at index: " + hardIndex);
        }
        else {
            System.out.println("Element not found.");
        }

        

        

        
    }
}