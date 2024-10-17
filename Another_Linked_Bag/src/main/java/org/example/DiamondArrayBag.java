/**
 * Alexander Yauchler | CS26000-02 | Homework 2
 */

package org.example;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DiamondArrayBag implements Cloneable, Serializable {
    public Diamond[] data;
    private int manyItems;

    public DiamondArrayBag() {
        final int INITIAL_CAPACITY = 2;
        manyItems = 0;
        data = new Diamond[INITIAL_CAPACITY];
    }

    public DiamondArrayBag(DiamondArrayBag bag) throws CloneNotSupportedException {
        this.data = new Diamond[bag.getCapacity()];
        this.manyItems = bag.manyItems;

        for (int i = 0; i < bag.manyItems; i++) {
            this.data[i] = bag.data[i].clone();
        }
    }

    public static DiamondArrayBag union(DiamondArrayBag bag1, DiamondArrayBag bag2) throws CloneNotSupportedException {
        DiamondArrayBag newBag = new DiamondArrayBag();

        newBag.data = new Diamond[bag1.manyItems + bag2.manyItems];

        for (int i = 0; i < bag1.manyItems; i++) {
            newBag.data[i] = bag1.data[i].clone();
        }

        for (int i = 0; i < bag2.manyItems; i++) {
            newBag.data[bag1.manyItems + i] = bag2.data[i].clone();
        }

        return newBag;
    }

    public void trimToSize(int size) {
        if (size > data.length) { return; } // Invalid input

        data = Arrays.copyOfRange(data, 0, size);
        manyItems = Math.min(size, manyItems); // Calculate new manyItems
    }

    public int size() {
        return manyItems;
    }

    @Override
    public DiamondArrayBag clone() throws CloneNotSupportedException {
        DiamondArrayBag cloneBag = new DiamondArrayBag();

        for (Diamond datum : data) {
            cloneBag.add(datum.clone());
        }

        return cloneBag;
    }

    public void add(Diamond element) throws CloneNotSupportedException {
        if (manyItems == data.length)
            ensureCapacity((manyItems + 1)*2);
        data[manyItems] = element.clone();
        manyItems++;
    }

    public void remove(Diamond element) {
        if (!this.contains(element)) { return; } // Object is not in array

        Diamond[] newArr = new Diamond[data.length - 1];

        for (int i = 0, j = 0; i < data.length; i++) {
            if (data[i].equals(element)) { continue; }
            newArr[j] = data[i];
            j++;
        }

        data = newArr;
    }

    public String toString() {
        String str = "";

        for (Diamond obj : data) {
            str += obj.toString() + "\n";
        }

        return str;
    }

    // This function uses the retainAll() function supplied by the HashMap class to
    // find all collisions in the maps, then return them as an array.
    public static DiamondArrayBag intersection(DiamondArrayBag bagA, DiamondArrayBag bagB) {
        Set<Diamond> s1 = new HashSet<>(Arrays.asList(bagA.data));
        s1.retainAll(Arrays.asList(bagB.data));

        DiamondArrayBag newBag = new DiamondArrayBag();
        newBag.data = s1.toArray(new Diamond[0]);

        return newBag;
    }

    public boolean contains(Diamond element) {
        return Arrays.asList(data).contains(element);
    }

    public void ensureCapacity(int minimumCapacity) {
        Diamond[ ] biggerArray;
        if (data.length < minimumCapacity)
        {
            biggerArray = new Diamond[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }

    public int getCapacity( ) {
        return data.length;
    }

    public void trimToSize( ) {
        Diamond[ ] trimmedArray;
        if (data.length != manyItems) {
            trimmedArray = new Diamond[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }
}