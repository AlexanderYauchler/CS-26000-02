package org.example;

import java.util.EmptyStackException;

class LinkedStack<E> implements Cloneable {
    private Node<E> top;

    private StackIterator<E> iterator;

    public LinkedStack() {
        top = null;
        iterator = null;
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
        top = new Node<>(item, top);
        iterator = new StackIterator<>(top);
    }

    public StackIterator<E> getIterator() {
        if (iterator == null)
            throw new EmptyStackException();

        return iterator;
    }
}
