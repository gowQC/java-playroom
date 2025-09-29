import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main (String[] args) {
        // Priority Queue = FIFO data structure that serves elements with highest priority
        // first before elements with lower priority

        Queue<Double> llqueue = new LinkedList<>(); // queue as a linked list
        Queue<Double> pQueue = new PriorityQueue<>(); // our priority queue
        Queue<Double> reversePQueue = new PriorityQueue<>(Collections.reverseOrder()); // priority queue with default comparator that reverses order of contents

        System.out.println("========Linked List Queue========");

        llqueue.offer(3.0);
        llqueue.offer(2.5);
        llqueue.offer(4.0);
        llqueue.offer(1.5);
        llqueue.offer(2.0);

        // displays elements in FIFO order
        while(!llqueue.isEmpty()) {
            System.out.println(llqueue.poll());
        }

        System.out.println("========Priority Queue========");

        pQueue.offer(3.0);
        pQueue.offer(2.5);
        pQueue.offer(4.0);
        pQueue.offer(1.5);
        pQueue.offer(2.0);

        // displays in numeric value from least to greatest
        while(!pQueue.isEmpty()) {
            System.out.println(pQueue.poll());
        }

        System.out.println("========Reversed Priority Queue========");

        reversePQueue.offer(3.0);
        reversePQueue.offer(2.5);
        reversePQueue.offer(4.0);
        reversePQueue.offer(1.5);
        reversePQueue.offer(2.0);

        // displays in numeric value from greatest to least
        while(!reversePQueue.isEmpty()) {
            System.out.println(reversePQueue.poll());
        }
    }
}

