package org.example;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

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

    public static class StackIterator<E> implements Iterator<E> {
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
}
