package org.example;

class Node<E> {
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
}