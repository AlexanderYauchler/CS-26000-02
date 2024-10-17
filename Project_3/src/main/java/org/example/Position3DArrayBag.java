package org.example;

public class Position3DArrayBag {
    private Position3D[] data;
    private int manyItems;

    public Position3DArrayBag() {
        final int INITIAL_CAPACITY = 2;
        manyItems = 0;
        data = new Position3D[INITIAL_CAPACITY];
    }

    public Position3DArrayBag(Position3DArrayBag bag) throws CloneNotSupportedException {
        this.data = new Position3D[bag.getCapacity()];
        this.manyItems = bag.manyItems;

        for (int i = 0; i < bag.manyItems; i++) {
            this.data[i] = bag.data[i].clone();
        }
    }

    public static Position3DArrayBag union(Position3DArrayBag bag1, Position3DArrayBag bag2) throws CloneNotSupportedException {
        Position3DArrayBag newBag = new Position3DArrayBag();

        newBag.data = new Position3D[bag1.manyItems + bag2.manyItems];

        for (int i = 0; i < bag1.manyItems; i++) {
            newBag.data[i] = bag1.data[i].clone();
        }

        for (int i = 0; i < bag2.manyItems; i++) {
            newBag.data[bag1.manyItems + i] = bag2.data[i].clone();
        }

        return newBag;
    }

    public void add(Position3D element) throws CloneNotSupportedException {
        if (manyItems == data.length)
            ensureCapacity((manyItems + 1)*2);
        data[manyItems] = element.clone();
        manyItems++;
    }

    public void ensureCapacity(int minimumCapacity) {
        Position3D[ ] biggerArray;
        if (data.length < minimumCapacity)
        {
            biggerArray = new Position3D[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }

    public int getCapacity( ) {
        return data.length;
    }

    public void trimToSize( ) {
        Position3D[ ] trimmedArray;
        if (data.length != manyItems) {
            trimmedArray = new Position3D[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }
}