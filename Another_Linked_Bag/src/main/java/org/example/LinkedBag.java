/**
 * Alexander Yauchler | CS26000-02 | Homework 2
 */

package org.example;

import java.util.*;

public class LinkedBag <E extends Comparable<E> & Cloneable> implements Cloneable {
    private LinkedNode<E> head;
    private int manyNodes;

    public LinkedBag() {
        head = null;
        manyNodes = 0;
    }

    public void add(E element) {
        // Null element
        if (element == null) {
            throw new NullPointerException();
        }

        // Empty list
        if (manyNodes == 0) {
            head = new LinkedNode<>(element, head);
            manyNodes++;
            return;
        }

        LinkedNode<E> cursor = head;
        LinkedNode<E> prev = null;

        while (true) {
            // Data is new, append at head
            if (cursor == null) {
                head = new LinkedNode<>(element, head);
                manyNodes++;
                return;
            }

            // Check if data is already in list
            if (element.compareTo(cursor.getData()) == 0) {
                cursor.increaseCount();
                manyNodes++;

                // Check for correct positioning
                if (prev != null) {
                    // Correct positioning, end of list
                    if (cursor.getLink() == null && prev.getCount() <= cursor.getCount()) {
                        return;
                    }

                    // Correct positioning
                    if (prev.getCount() <= cursor.getCount() && cursor.getLink().getCount() >= cursor.getCount()) {
                        return;
                    }

                    // Remove from list for repositioning
                    prev.setLink(cursor.getLink());
                    break;
                }
            }

            prev = cursor;
            cursor = cursor.getLink();
        }

        // Smaller than head count, replace head
        if (head.getCount() >= cursor.getCount()) {
            cursor.setLink(head);
            head = cursor;
            manyNodes++;
            return;
        }

        LinkedNode<E> nodeRef = cursor;

        // Place element in correct position
        cursor = head;
        while (true) {
            if(cursor == null) { break; }

            // Found correct position
            if (cursor.getCount() <= nodeRef.getCount() && cursor.getLink().getCount() >= nodeRef.getCount()) {
                nodeRef.setLink(cursor.getLink());
                cursor.setLink(nodeRef);
                break;
            }

            cursor = cursor.getLink();
        }

        manyNodes++;
    }

    public int countOccurrences(E target) {
        LinkedNode<E> cursor;

        cursor = LinkedNode.listSearch(head, target);
        if (cursor == null) {
            throw new NullPointerException();
        }

        return cursor.getCount();
    }

    public void remove(E target) {
        LinkedNode<E> cursor = head;
        LinkedNode<E> prev = null;



        while (true) {
            if (cursor == null) { break; }

            if (target.compareTo(cursor.getData()) == 0) {
                cursor.decreaseCount();
                if (cursor.getCount() > 0) { break; }

                // Head node
                if (prev == null) {
                    head = head.getLink();
                    return;
                }

                // Last node
                if (cursor.getLink() == null) {
                    prev.setLink(null);
                    return;
                }

                prev.setLink(cursor.getLink());
            }

            prev = cursor;
            cursor = cursor.getLink();
        }
    }

    public E grab(int index) {
        if (index < 0 || index > manyNodes) {
            throw new IndexOutOfBoundsException();
        }

        return LinkedNode.listPosition(head, index).getData();
    }

    public int size() {
        return manyNodes;
    }

    // This function uses the retainAll() function supplied by the Set class to
    // find all collisions in the data arrays, then build them into a LinkedBag.
    public static <E extends Comparable<E> & Cloneable> LinkedBag<E> intersection(LinkedBag<E> bagA, LinkedBag<E> bagB) {
        Set<E> s1 = new HashSet<>(bagA.toList());
        s1.retainAll(bagB.toList());

        LinkedBag<E> newBag = new LinkedBag<>();
        s1.forEach(newBag::add);

        return newBag;
    }

    // Converts the internal linked list into an ArrayList object
    // Used by intersection()
    private List<E> toList() {
        ArrayList<E> list = new ArrayList<>();

        LinkedNode<E> current = head;
        while (current != null) {
            list.add(current.getData());
            current = current.getLink();
        }

        return list;
    }

    public void printAll() {
        LinkedNode<E> current = head;
        while (current != null) {
            System.out.print(current.getCount() + "-");
            current = current.getLink();
        }

        System.out.println("|");
    }

    public static <E extends Comparable<E> & Cloneable> LinkedBag<E> union(LinkedBag<E> bagA, LinkedBag<E> bagB) {
        LinkedBag<E> unionBag = new LinkedBag<>();

        LinkedNode<E> current = bagA.head;
        while (current != null) {
            unionBag.add(current.getData());
            current = current.getLink();
        }

        current = bagB.head;
        while (current != null) {
            unionBag.add(current.getData());
            current = current.getLink();
        }

        return unionBag;
    }

//    @Override
//    public LinkedBag<E> clone() {
//        LinkedBag<E> clone = new LinkedBag<>();
//        for (LinkedNode<E> current = head; current != null; current = current.getLink()) {
//            clone.add(current.getData(), current.getCount());
//        }
//        return clone;
//    }
}

