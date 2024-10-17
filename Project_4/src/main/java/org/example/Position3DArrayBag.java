package org.example;

class Position3DArrayBag
{
    private Position3D[ ] data;
    private int manyItems;

    public Position3DArrayBag( )
    {
        final int INITIAL_CAPACITY = 2;
        manyItems = 0;
        data = new Position3D[INITIAL_CAPACITY];
    }
    // Overloaded constructor to copy an existing Position3DArrayBag
    public Position3DArrayBag(Position3DArrayBag other) {
        this.manyItems = other.manyItems; // Copy the number of items
        this.data = new Position3D[other.data.length]; // Allocate new memory
        for (int i = 0; i < other.manyItems; i++)
            this.data[i] = new Position3D(other.data[i]);
    }
    public void add(Position3D element) {
        if (manyItems == data.length) {
            // Ensure twice as much space as we need.
            ensureCapacity((manyItems + 1)*2);
        }
        data[manyItems] = element;
        manyItems++;
    }
    public void ensureCapacity(int minimumCapacity) {
        Position3D[ ] biggerArray;
        if (data.length < minimumCapacity) {
            biggerArray = new Position3D[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }
    public int getCapacity( ) {
        return data.length;
    }
    public int size( ) {
        return manyItems;
    }
    public void trimToSize( ) {
        Position3D[ ] trimmedArray;
        if (data.length != manyItems) {
            trimmedArray = new Position3D[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }
    public static Position3DArrayBag union(Position3DArrayBag bag1, Position3DArrayBag
            bag2) {
        Position3DArrayBag result = new Position3DArrayBag();
        result.ensureCapacity(bag1.manyItems + bag2.manyItems);
        for (int i = 0; i < bag1.manyItems; i++)
            result.add(new Position3D(bag1.data[i]));
        for (int i = 0; i < bag2.manyItems; i++)
            result.add(new Position3D(bag2.data[i]));
        return result;
    }
}