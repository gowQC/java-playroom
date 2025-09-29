// uses more memory
// possible to run into StackOverflowError if method is called recursively too many times
// too many calls in the call stack

public class RecursionDemo {
    public static void callback(int x) {
        if(x > 1) {
            System.out.println("Calling " + x + ": going to " + (x-1) + " if possible.");
            callback(x-1);
        }
        else System.out.println("Done calling back.");
    }

    public static int factorial(int x) {
        if(x <= 1) return 1; // base case
        return x * factorial(x - 1);
    }

    public static int power(int x, int y) {
        if (x == 1 || y == 0) {
            return 1;
        }
        else if (y == 1) {
            return x;
        }
        return x * power(x, y-1);
    }
    
    public static void main(String[] args) {
        // simple example of recursion
        callback(9);
        System.out.println(factorial(4));
        System.out.println(power(-2, 3));
    }
}