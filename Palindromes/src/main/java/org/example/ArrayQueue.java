package org.example;

import java.util.NoSuchElementException;

class ArrayQueue<E> implements Cloneable {
    private E[] data;
    private int manyItems;
    private int front;
    private int rear;

    public ArrayQueue() {
        final int INITIAL_CAPACITY = 5;
        manyItems = 0;
        data = (E[]) new Object[INITIAL_CAPACITY];
    }

    public void add(E item) {
        if (manyItems == data.length)
            ensureCapacity(manyItems * 2 + 1);

        if (manyItems == 0) {
            front = 0;
            rear = 0;
        } else
            rear = nextIndex(rear);

        data[rear] = item;
        manyItems++;
    }

    public void ensureCapacity(int minimumCapacity) {
        E[] biggerArray;
        int n1, n2;
        if (data.length >= minimumCapacity)
            return;
        else if (manyItems == 0)
            data = (E[]) new Object[minimumCapacity];
        else if (front <= rear) {
            biggerArray = (E[]) new Object[minimumCapacity];
            System.arraycopy(data, front, biggerArray, front, manyItems);
            data = biggerArray;
        } else {
            biggerArray = (E[]) new Object[minimumCapacity];
            n1 = data.length - front;
            n2 = rear + 1;
            System.arraycopy(data, front, biggerArray, 0, n1);
            System.arraycopy(data, 0, biggerArray, n1, n2);
            front = 0;
            rear = manyItems - 1;
            data = biggerArray;
        }
    }

    public boolean isEmpty() {
        return (manyItems == 0);
    }

    private int nextIndex(int i) {
        if (++i == data.length)
            return 0;
        else
            return i;
    }

    public E remove() {
        E answer;
        if (manyItems == 0)
            throw new NoSuchElementException("Queue underflow");
        answer = data[front];
        front = nextIndex(front);
        manyItems--;
        return answer;
    }

    // O(1) time complexity
    public int size() {
        return rear == front ? 0 : Math.abs(rear - front) + 1;
    }
}

