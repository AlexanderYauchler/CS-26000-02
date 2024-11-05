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
        for (int i = 0; i < manyItems; i++) {
            str += data[i].toString() + " ";
        }
        return str;
    }

    @Override
    public boolean equals(Object compare) {
        if (compare.getClass() != this.getClass()) {
            throw new ClassCastException();
        }

        ArrayStack<E> stack = (ArrayStack<E>) compare;

        if (this.size() != stack.size()) {
            return false;
        }

        for (int i = 0; i < this.manyItems; i++) {
            if (!this.data[i].equals(stack.data[i])) {
                return false;
            }
        }

        return true;
    }

    public static <E> boolean equals(ArrayStack<E> stack1, ArrayStack<E> stack2) {
        if (stack1.size() != stack2.size()) {
            return false;
        }

        for (int i = 0; i < stack1.manyItems; i++) {
            if (!stack1.data[i].equals(stack2.data[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ArrayStack<E> clone() {
        try {
            ArrayStack<E> clone = (ArrayStack<E>) super.clone();

            clone.data = this.data;
            clone.manyItems = this.manyItems;

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}