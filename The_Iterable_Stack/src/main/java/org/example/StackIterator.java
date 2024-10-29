package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

class StackIterator<E> implements Iterator<E> {
    private Node<E> current;

    public StackIterator(Node<E> head) {
        current = head;
    }

    public boolean hasNext() {
        return (current != null);
    }

    public E next() {
        E answer;
        if (!hasNext())
            throw new NoSuchElementException("The stack is empty");
        answer = current.getData();
        current = current.getLink();
        return answer;
    }

    public void remove() {
        throw new UnsupportedOperationException("You are not allowed to remove an element from the stack !");
    }
}