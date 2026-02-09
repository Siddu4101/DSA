package org.example.neetcode150.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueExamples {
    private int[] arr = new int[5];
    private int front = 0;
    private int rare = 0;
    private int size = arr.length;

    public static void main(String[] args) {
        /*simple queue with array*/
        QueueExamples queueExamples = new QueueExamples();
        queueExamples.enqueue(0);
        queueExamples.enqueue(1);
        queueExamples.enqueue(2);
        queueExamples.enqueue(3);
        queueExamples.enqueue(4);
        queueExamples.enqueue(5);

        queueExamples.printQueue();

        queueExamples.dequeue();
        queueExamples.dequeue();

        queueExamples.printQueue();

    }

    /*add an element to the queue*/
    public void enqueue(int num) {
        if (rare <= size - 1) {
            arr[rare] = num;
            if (rare < size - 1)
                rare++;
        } else
            throw new IndexOutOfBoundsException("Queue is already full");
    }

    /*delete element from the queue*/
    public void dequeue() {
        if (front == rare)
            throw new NoSuchElementException("no elements to delete from the queue");
        for (int i = 1; i < rare; i++) {
            arr[i - 1] = arr[i];
        }
        arr[rare] = 0;
        if (rare > front)
            rare--;
    }

    /*print queue*/
    public void printQueue() {
        System.out.println("QUEUE: " + Arrays.toString(arr));
    }
}
