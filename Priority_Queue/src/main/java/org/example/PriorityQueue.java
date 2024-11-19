package org.example;

import java.util.Queue;

public class PriorityQueue <E> implements Cloneable {
    private ArrayQueue<E>[] queues;
    private int maxPriority = 0;
    private int size = 0;

    public PriorityQueue(int levels) {
        queues = (ArrayQueue<E>[]) new ArrayQueue[levels];

        for (int i = 0; i < levels; i++) {
            queues[i] = new ArrayQueue<>();
        }

        maxPriority = levels;
    }

    public void enqueue(E element, int priority) {
        if (priority < 0 || priority > maxPriority) {
            throw new IndexOutOfBoundsException();
        }

        queues[priority].add(element);
        size++;
    }

    public E dequeue() {
        for (int i = 0; i < maxPriority; i++) {
            if (queues[i].isEmpty()) {
                continue;
            }

            size--;
            return queues[i].remove();
        }

        throw new NullPointerException();
    }

    public E peek() {
        for (int i = 0; i < maxPriority; i++) {
            if (queues[i].isEmpty()) {
                continue;
            }

            return queues[i].peek();
        }

        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void showQueue() {
        System.out.print("{ ");

        for (int i = 0; i < maxPriority; i++) {
            if (queues[i].isEmpty()) { continue; }
            queues[i].print();
            System.out.println(", ");
        }

        System.out.println(" }");
    }

    @Override
    public PriorityQueue<E> clone() {
        try {
            PriorityQueue<E> cloned = (PriorityQueue<E>) super.clone();

            cloned.queues = (ArrayQueue<E>[]) new ArrayQueue[maxPriority];
            for (int i = 0; i < maxPriority; i++) {
                if (queues[i] != null) {
                    cloned.queues[i] = queues[i].clone();
                }
            }

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }
}
