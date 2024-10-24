package org.example;

import java.util.EmptyStackException;

class LinkedStack<E> implements Cloneable {
    private Node<E> top;

    public LinkedStack() {
        top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public E peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.getData();
    }

    public E pop() {
        E answer;

        if (top == null)
            throw new EmptyStackException();

        answer = top.getData();
        top = top.getLink();
        return answer;
    }

    public void push(E item) {
        top = new Node<E>(item, top);
    }

    public void display() {
        Node<E> current = top;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getLink();
        }
        System.out.println();
    }

    // O(n) time complexity
    public LinkedStack<E> flip() {
        LinkedStack<E> flipped = new LinkedStack<>();

        Node<E> cursor = top;
        while (cursor != null) {
            flipped.push(cursor.getData());
            cursor = cursor.getLink();
        }

        return flipped;
    }

    // O(n) time complexity
    public static <E> Boolean equals(LinkedStack<E> stack1, LinkedStack<E> stack2) {
        Node<E> cursor1 = stack1.top;
        Node<E> cursor2 = stack2.top;

        while (true) {
            // Size mismatch
            if (cursor1 == null ^ cursor2 == null) { return false; }

            // End of list
            if (cursor1 == null) { break; }

            // Data mismatch
            if (!cursor1.getData().equals(cursor2.getData())) { return false; }

            // Advance cursors
            cursor1 = cursor1.getLink();
            cursor2 = cursor2.getLink();
        }

        return true;
    }
}