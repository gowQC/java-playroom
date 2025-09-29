import java.util.Stack;

public class StackDemo {
    public static void main (String[] args) {
        // stack = LIFO data structure >> last in, first out
        Stack<String> myStack = new Stack<String>();

        // push = adds to top of stack
        myStack.push("Minecraft");
        myStack.push("Borderlands 4");
        myStack.push("Borderlands 3");
        myStack.push("Borderlands 2");

        // true or false if empty
        System.out.println(myStack.empty());
        System.out.println(myStack);

        // pop = removes whatevers at top of stack (can cause exception on empty stack)
        myStack.pop();
        // can assign pop value, but can use peek method to see top of stack instead of popping it
        // String gameName = myStack.pop();
        String gameName = myStack.peek();
        System.out.println(gameName);

        // search = finds position of item (not 0-indexed, starts with 1)
        System.out.println(myStack);
        System.out.println("Minecraft's position in the stack is: " + myStack.search("Minecraft"));
        System.out.println("Borderlands 3's position in the stack is: " + myStack.search("Borderlands 3"));
        System.out.println("A game not in a stack at all will hold a value of: " + myStack.search("Overwatch 2")); // -1 for unfound values
    }
}