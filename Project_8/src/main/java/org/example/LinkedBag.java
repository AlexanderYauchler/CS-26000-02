package org.example;

import java.sql.Array;
import java.util.*;

public class LinkedBag <E extends Comparable<E>> implements Cloneable {
    private Node<E> head;
    private int manyNodes;

    public LinkedBag() {
        head = null;
        manyNodes = 0;
    }

    public void add(E element) {
        head = new Node<>(element, head);
        manyNodes++;
    }

    public int countOccurrences(E target) {
        int answer = 0;
        Node<E> cursor;

        cursor = Node.listSearch(head, target);
        while (cursor != null) {
            answer++;
            cursor = cursor.getLink();
            cursor = Node.listSearch(cursor, target);
        }

        return answer;
    }

    public boolean remove(E target) {
        Node<E> targetNode = Node.listSearch(head, target);
        if (targetNode == null)
            return false;
        else {
            targetNode.setData(head.getData());
            head = head.getLink();
            manyNodes--;
            return true;
        }
    }

    public E grab() {
        return Node.listPosition(head, new Random().nextInt(manyNodes) + 1).getData();
    }

    public int size() {
        return manyNodes;
    }

    // O(2N) Time Complexity
    public void printReversed() {
        ArrayDeque<E> append = new ArrayDeque<>();

        Node<E> current = head;
        while (current != null) {
            append.addLast(current.getData());
            current = current.getLink();
        }

        for (E element : append) {
            System.out.println(element.toString() + " ");
        }
    }

    // O(2N) Time Complexity or O(N + M)
    public static <E extends Comparable<E>> LinkedBag<E> union(LinkedBag<E> bagA, LinkedBag<E> bagB) {
        LinkedBag<E> unionBag = new LinkedBag<>();

        Node<E> current = bagA.head;
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
}

