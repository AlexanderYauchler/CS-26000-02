package org.example;

import java.util.EmptyStackException;

class ArrayStack<E> implements Cloneable {
    private E[] data;
    private int manyItems;

    public ArrayStack() {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = (E[]) new Object[INITIAL_CAPACITY];
    }

    public ArrayStack(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException
                    ("initialCapacity too small " + initialCapacity);
        manyItems = 0;
        data = (E[]) new Object[initialCapacity];
    }

    public void ensureCapacity(int minimumCapacity) {
        E biggerArray[];

        if (data.length < minimumCapacity) {
            biggerArray = (E[]) new Object[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }

    public boolean isEmpty() {
        return (manyItems == 0);
    }

    public E pop() {
        if (manyItems == 0)
            throw new EmptyStackException();
        return data[--manyItems];
    }

    public void push(E item) {
        if (manyItems == data.length) {
            ensureCapacity(manyItems * 2 + 1);
        }
        data[manyItems] = item;
        manyItems++;
    }

    public int size() {
        return manyItems;
    }

    // O(n) time complexity
    public String toString() {
        String str = "";
        for (int i = 0; i < manyItems; i++) { str += data[i].toString() + " "; }
        return str;
    }
}