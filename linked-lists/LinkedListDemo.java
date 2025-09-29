import java.util.LinkedList;

public class LinkedListDemo {
    public static void main (String[] args) {
        // linkedlists store Nodes in 2 parts (data + address)
        LinkedList<String> llstack = new LinkedList<String>();
        LinkedList<String> llqueue = new LinkedList<String>();

        // these methods are used when treating linkedlist like a stack
        // adds element to the front/"head" of list, much like pushing onto a stack
        llstack.push("A");
        llstack.push("B");
        llstack.push("C");
        llstack.push("D");
        llstack.push("F"); // llstack = [F, D, C, B, A]
        llstack.pop(); // llstack = [D, C, B, A]
        System.out.println(llstack);

        // these methods are used when treating linkedlist like a queue
        // first-in, first-out (FIFO) principle
        llqueue.offer("A");
        llqueue.offer("B");
        llqueue.offer("C");
        llqueue.offer("D");
        llqueue.offer("F"); // llqueue = [A, B, C, D, F]
        llqueue.poll(); // llqueue = [B, C, D, F]
        System.out.println(llqueue);

        // linked lists excell at the insertion and deletion of nodes
        llstack.add(0, "E");
        System.out.println(llstack);
        llqueue.add(3, "E");
        System.out.println(llqueue);

        // gets first element of linkedlist
        System.out.println("First of llstack: " + llstack.peekFirst());
        System.out.println("First of llqueue: " + llqueue.peekFirst());

        // gets last element of linkedlist
        System.out.println("Last of llstack: " + llstack.peekLast());
        System.out.println("Last of llqueue: " + llqueue.peekLast());

        // other helpful adding methods
        llstack.addFirst("F");
        llstack.addLast("0");
        System.out.println(llstack);

        llqueue.addFirst("A");
        llqueue.addLast("G");
        System.out.println(llqueue);

        String first = llqueue.removeFirst();
        String last = llqueue.removeLast();
        System.out.println(first);
        System.out.println(llqueue);
        System.out.println(last);
    }
}