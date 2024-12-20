package org.example;

class BTNode<E> {
    private E data;
    private BTNode<E> left, right;

    public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight) {
        data = initialData;
        left = initialLeft;
        right = initialRight;
    }

    public E getData() {
        return data;
    }

    public BTNode<E> getLeft() {
        return left;
    }

    public BTNode<E> getRight() {
        return right;
    }

    public void setData(E newData) {
        data = newData;
    }

    public void setLeft(BTNode<E> newLeft) {
        left = newLeft;
    }

    public void setRight(BTNode<E> newRight) {
        right = newRight;
    }

    public void print(int depth) {
        int i;

        for (i = 1; i <= depth; i++)
            System.out.print("    ");
        System.out.println(data);

        if (left != null)
            left.print(depth + 1);
        else if (right != null) {
            for (i = 1; i <= depth + 1; i++)
                System.out.print("    ");
            System.out.println("--");
        }

        if (right != null)
            right.print(depth + 1);
        else if (left != null) {
            for (i = 1; i <= depth + 1; i++)
                System.out.print("    ");
            System.out.println("--");
        }
    }

    public static <E> long treeSize(BTNode<E> root) {
        if (root == null)
            return 0;
        else
            return 1 + treeSize(root.left) + treeSize(root.right);
    }

    // O(n) time complexity
    public static <E> BTNode<E> getLeftmost(BTNode<E> start) {
        if (start.left == null) {
            return start;
        }

        return getLeftmost(start.left);
    }
}
