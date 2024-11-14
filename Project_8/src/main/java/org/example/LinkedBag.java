package org.example;

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

    // O(n) time complexity
    public void addBefore(E add, E target) {
        Node<E> current = head;
        Node<E> prev = null;

        // Empty list
        if (manyNodes == 0) {
            throw new NullPointerException();
        }

        // Start of list
        if (head.getData().equals(target)) {
            add(add);
            return;
        }

        Node<E> addNode = new Node<>(add, null);
        do {
            if (prev != null && current.getData().equals(target)) {
                addNode.setLink(current);
                manyNodes++;
                prev.setLink(addNode);
                return;
            }

            prev = current;
            current = current.getLink();
        } while (current != null);

        // Target node does not exist
        throw new NullPointerException();
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

    public void print() {
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.getData() + " ");
            current = current.getLink();
        }
    }

    // O(n) time complexity
    public boolean equals(LinkedBag<E> otherBag) {
        if (this.manyNodes != otherBag.manyNodes) {
            return false;
        }

        Node<E> current = head;
        Node<E> currentB = otherBag.head;

        while (current != null) {
            if (!current.getData().equals(currentB.getData())) {
                return false;
            }

            current = current.getLink();
            currentB = currentB.getLink();
        }

        return true;
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

