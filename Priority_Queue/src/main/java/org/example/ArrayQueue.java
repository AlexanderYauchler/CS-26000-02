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

    public E peek() {
        if (manyItems == 0)
            throw new NoSuchElementException("Queue underflow");
        return data[front];
    }

    // O(1) time complexity
    public int size() {
        if (rear < front) {
            return (data.length - front) + (rear + 1);
        }

        if (rear > front) {
            return rear - front + 1;
        }

        return manyItems == 0 ? 0 : manyItems;
    }

    public void print() {
        System.out.print("[");

        int index = front;
        for (int i = 0; i < manyItems; i++) {
            System.out.print(data[index] + "\n");
            index = nextIndex(index + 1);
        }

        System.out.print("]");
    }

    @Override
    public ArrayQueue<E> clone() {
        try {
            ArrayQueue<E> cloned = (ArrayQueue<E>) super.clone();

            cloned.data = (E[]) new Object[data.length];
            System.arraycopy(this.data, 0, cloned.data, 0, this.data.length);

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }
}

