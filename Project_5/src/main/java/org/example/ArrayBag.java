package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class ArrayBag<E extends Comparable<E>> implements Cloneable {
    private E[ ] data;
    private int manyItems;

    public ArrayBag( ) {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = (E[]) new Comparable[INITIAL_CAPACITY];
    }

    public void add(E element){
        if (manyItems == data.length)
            ensureCapacity((manyItems + 1)*2);
        data[manyItems] = element;
        manyItems++;
    }

    public void ensureCapacity(int minimumCapacity) {
        E biggerArray[ ];
        if (data.length < minimumCapacity) {
            biggerArray = (E[]) new Comparable[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }

    public int countOccurrences(E target){
        int answer =0, index;
        for (index = 0; index < manyItems; index++)
            if (target.equals(data[index]))
                answer++;
        return answer;
    }

    public int getCapacity( ) {
        return data.length;
    }

    public int search(E target) {
        for (int i = 0; i < manyItems; i++) {
            if (target.equals(data[i]))
                return i;
        }

        return -1;
    }

    public int binarySearch(E target) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid] == target) {
                return mid;
            }

            if (data[mid].compareTo(target) < 0) {
                left = mid + 1;
                continue;
            }

            right = mid - 1;
        }

        return -1;
    }

    public void sort() {
        E tempArray[] = Arrays.copyOfRange(data, 0, manyItems);
        Arrays.sort(tempArray, new GenericComparator<>());
        data = tempArray;
    }

    public int size( ) {
        return manyItems;
    }
}
