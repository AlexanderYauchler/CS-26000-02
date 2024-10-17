package org.example;

public class Node <E extends Comparable<E>> {
    private E data;
    private Node<E> link;

    public Node(E initialData, Node<E> initialLink) {
        data = initialData;
        link = initialLink;
    }

    public void setData(E newData) {
        data = newData;
    }

    public E getData() {
        return data;
    }

    public Node<E> getLink() {
        return link;
    }

    public void setLink(Node<E> newLink) {
        link = newLink;
    }

    public static <E extends Comparable<E>> Node<E> listSearch(Node<E> head, E target) {
        Node<E> cursor;

        for (cursor = head; cursor != null; cursor = cursor.link)
            if (target.compareTo(cursor.data) == 0)
                return cursor;

        return null;
    }

    // O(N) Complexity
    public static <E extends Comparable<E>> Node<E> listPosition(Node<E> head, int position) {
        Node<E> cursor;
        int i;

        if (position <= 0)
            throw new IllegalArgumentException("position is not positive");
        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++)
            cursor = cursor.link;

        return cursor;
    }
}

