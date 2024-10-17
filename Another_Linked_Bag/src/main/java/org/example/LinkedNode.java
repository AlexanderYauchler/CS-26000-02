/**
 * Alexander Yauchler | CS26000-02 | Homework 2
 */

package org.example;

public class LinkedNode<E extends Comparable<E> & Cloneable> {
    private E data;
    private LinkedNode<E> link;
    private int count;

    public LinkedNode(E initialData, LinkedNode<E> initialLink) {
        data = initialData;
        link = initialLink;
        count = 1;
    }

    public void setData(E newData) {
        data = newData;
    }

    public E getData() {
        return data;
    }

    public LinkedNode<E> getLink() {
        return link;
    }

    public int getCount() { return count; }

    public void increaseCount() { this.count++; }

    public void decreaseCount() { this.count--; }

    public void setCount(int val) {  this.count = val; }

    public void setLink(LinkedNode<E> newLink) {
        link = newLink;
    }

    public static <E extends Comparable<E> & Cloneable> LinkedNode<E> listSearch(LinkedNode<E> head, E target) {
        LinkedNode<E> cursor;

        for (cursor = head; cursor != null; cursor = cursor.link)
            if (target.compareTo(cursor.data) == 0)
                return cursor;

        return null;
    }

    public static <E extends Comparable<E> & Cloneable> LinkedNode<E> listPosition(LinkedNode<E> head, int position) {
        LinkedNode<E> cursor;
        int i;

        if (position <= 0)
            throw new IllegalArgumentException("position is not positive");
        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++)
            cursor = cursor.link;

        return cursor;
    }
}

