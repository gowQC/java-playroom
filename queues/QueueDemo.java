import java.util.Queue;
import java.util.LinkedList;

public class QueueDemo {
    public static void main (String[] args) {
        // FIF0 - first in, first out. like waiting on a line
        // Queue is an interface (a template), not a class, so we need a class that implements Queue
        Queue<String> queue = new LinkedList<String>();

        queue.offer("Karen"); // add to tail end of Queue
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");

        System.out.println(queue.peek()); // checks who is in first in the Queue
        queue.poll(); // "pops" first in the queue

        System.out.println(queue);
        
        // the Queue interface extends the Collections class, so it is also has access to Collections methods
        System.out.println(queue.isEmpty()); // returns true if empty, false otherwise
        System.out.println(queue.size()); // gets the size of the queue
        System.out.println(queue.contains("Harold")); // checks if queue has certain element
        
        // Queue's are used in LinkedLists, PriorityQueues, and Breadth-first search algorithms 
    }
}
