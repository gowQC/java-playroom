/**
 * Intermediate Stack Problem: Min Stack
 * 
 * Problem Statement: 
 * Design a stack that supports the following operations in O(1) time:
 *    push(int x): Push element x onto the stack.
 *    pop(): Removes the element on top of the stack.
 *    top(): Get the top element.
 *    getMin(): Retrieve the minimum element in the stack.
 *
 * Requirements:
 * 
 * All operations should run in constant time.
 * You may not use built-in library functions that trivially give you the min of a collection each time (like Collections.min()).  
 */

public class intermediateStackProblem {

    public static void main (String[] args) {
    
        class Stack {
            int[] stackArray = new int[10]; // arbitrary array size - using 10 as a safe default
            int capacity = 0; // keeps track of top index (capacity - 1) - initialized to 0 representing empty stack
            int[] minArray = new int[10]; // will keep track of all minimum values
            int minCapacity = 0; // will keep track of most recent minimum in the stack

            void readArray() {
                System.out.print("[");
                for (int i = 0; i < stackArray.length; i++) {
                    System.out.print(stackArray[i]);
                    if (i < stackArray.length - 1) {  // add comma between elements
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }

            void push(int x) {
                stackArray[capacity] = x;
                capacity++;
                
                // if capacity is maxed, create new array with double capacity (does not always trigger, so not O(n) complexity)
                if (capacity == stackArray.length) {
                    int[] tempArray = new int[stackArray.length * 2]; // tempArray with double capacity
                    for (int i = 0; i < stackArray.length; i++) { 
                        tempArray[i] = stackArray[i];
                    }
                    stackArray = tempArray;
                }

                // if minArray empty (first condition), first value is minimum. added values cannot ever be a minimum unless they fulfill the second condition
                if (minCapacity == 0 || x <= minArray[minCapacity - 1]) {
                    minArray[minCapacity] = x;
                    minCapacity++;

                    // remake and double array if capacity is full
                    if (minCapacity == minArray.length) {
                        int[] tempArray = new int[minArray.length * 2];
                        for (int i = 0; i < minArray.length; i++) { 
                            tempArray[i] = minArray[i];
                        }
                        minArray = tempMinArray;
                    }
                }
            }

            void pop() {
                //base case - if stack is already empty
                if (capacity == 0) {
                    System.out.println("Cannot pop empty stack.");
                    return;
                }

                // no need to change the actual value
                // any data indexed higher than [capacity - 1] should be treated as junk data irrelevant to the stack
                int removed = stackArray[capacity - 1];
                capacity--;
                
                // same logic from above applies here
                if (removed == minArray[minCapacity - 1]) {
                    minCapacity--;
                }
            }

            int top() {
                return stackArray[capacity - 1];
            }

            int getMin() {
                // base case - throw exception if stack is empty 
                // but we can assume a problem constraint guarantees getMin calls will be made on non-empty stacks
                return minArray[minCapacity - 1];
            }
        }
        
        Stack myStack = new Stack();
        myStack.push(1);
        myStack.push(0);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.getMin());
    }
}