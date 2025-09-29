public class GreedyAlgorithmDemo {

    public static void greedyAlgorithm(int[] arr) {

        // base cases
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        int incl = arr[0]; // max sum including current element
        int excl = 0; // max sum excluding current element

        for (int i = 1; i < arr.length; i++) {
            int newIncl = excl + arr[i];          // include current
            int newExcl = Math.max(incl, excl);   // exclude current

            incl = newIncl;
            excl = newExcl;
        }

        return Math.max(incl, excl);

    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 5, 10, 7};
        System.out.println(greedyAlgorithm(arr));
    }
}