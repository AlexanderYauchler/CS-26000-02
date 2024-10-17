package org.example;

import java.util.Random;

@SuppressWarnings("unckecked")
class ArrayBag<T extends Cloneable> {
    private Object[] data;
    private int manyItems;

    public ArrayBag() {
        final int INITIAL_CAPACITY = 2;
        manyItems = 0;
        data = new Object[INITIAL_CAPACITY];
    }

    // Overloaded constructor to copy an existing Position3DArrayBag
    public ArrayBag(ArrayBag<T> other) {
        this.manyItems = other.manyItems; // Copy the number of items
        this.data = new Object[other.data.length]; // Allocate new memory
        for (int i = 0; i < other.manyItems; i++)
            this.data[i] = other.data[i];
    }

    public void add(T element) {
        if (manyItems == data.length) {
            // Ensure twice as much space as we need.
            ensureCapacity((manyItems + 1) * 2);
        }
        data[manyItems] = element;
        manyItems++;
    }

    public void ensureCapacity(int minimumCapacity) {
        Object[] biggerArray;
        if (data.length < minimumCapacity) {
            biggerArray = new Object[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }
    
    public void addAll(ArrayBag<T> bag) {
        for (int i = 0; i < bag.manyItems; i++) {
            try {
                add((T) bag.data[i].getClass().getMethod("clone").invoke(bag.data[i]));
            } catch(Exception e) {
                add((T) bag.data[i]);
            }
        }
    }

    public int getCapacity() {
        return data.length;
    }

    public int size() {
        return manyItems;
    }

    public void trimToSize() {
        Object[] trimmedArray;
        if (data.length != manyItems) {
            trimmedArray = new Object[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }

    public Object grab() {
        if (manyItems == 0) {
            return null;
        }

        return data[new Random().nextInt(manyItems - 1)];
    }

    public static <T> ArrayBag<T> union(ArrayBag<T> bag1, ArrayBag<T> bag2) {
        ArrayBag<T> result = new ArrayBag<>();
        result.ensureCapacity(bag1.manyItems + bag2.manyItems);
        for (int i = 0; i < bag1.manyItems; i++)
            result.add((T) bag1.data[i]);
        for (int i = 0; i < bag2.manyItems; i++)
            result.add((T) bag2.data[i]);
        return result;
    }
}