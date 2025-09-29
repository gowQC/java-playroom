import java.util.Stack;

/**
 * Beginner Stack Problem: Balanced Parentheses
 * 
 * Problem Statement:
 * Given a string consisting only of the characters (, ), {, }, [ and ], determine if the input string is valid. A string is valid if:
 * 
 * Open brackets are closed by the same type of brackets.
 *
 * Open brackets are closed in the correct order.
 *
 * Every closing bracket has a corresponding previous open bracket.
 */

public class beginnerStackProblem {

    public static boolean myFunc(String input) {
        // base case - emptry String
        if (input.length() == 0) {
            return false;
        }

        Stack<Character> myStack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')' ) {
                if (myStack.peek() == '(') {
                    myStack.pop();
                }
            }
            else if (input.charAt(i) == ']' ) {
                if (myStack.peek() == '[') {
                    myStack.pop();
                }
            }
            else if (input.charAt(i) == '}' ) {
                if (myStack.peek() == '{') {
                    myStack.pop();
                }
            }
            else {
                myStack.push(input.charAt(i));
            }
        }
        return myStack.empty(); // we want it to be true (empty stack)
    }

    public static void main (String[] args) {
        System.out.println(myFunc("()")); // true
        System.out.println(myFunc("()[]{}")); // true
        System.out.println(myFunc("(]")); // false
        System.out.println(myFunc("([)]")); // false
        System.out.println(myFunc("{[]}")); // true
        System.out.println(myFunc("(((())))")); // true
        System.out.println(myFunc("")); // false
    }
}