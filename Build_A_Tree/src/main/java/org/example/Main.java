    package org.example;

public class Main {
    public static void main(String[] args) {
        BTNode<Integer> root = new BTNode<>(1, null, null);
        BTNode<Integer> curr;

        // First level
        root.setLeft(new BTNode<>(7, null, null));
        root.setRight(new BTNode<>(9, null, null));

        // Left branch third level
        curr = root.getLeft();
        curr.setLeft(new BTNode<>(33, null, null));
        curr.setRight(new BTNode<>(6, null, null));

        // Left branch fourth level
        curr = curr.getRight();
        curr.setLeft(new BTNode<>(5, null, null));
        curr.setRight(new BTNode<>(11, null, null));

        // Right branch third level
        curr = root.getRight();
        curr.setRight(new BTNode<>(9, null, null));

        // Right branch fourth level
        curr = curr.getRight();
        curr.setLeft(new BTNode<>(5, null, null));

        // Print tree linearly
        root.print(0);

        // Print tree size
        System.out.println("Tree Size: " + BTNode.treeSize(root));

        // Test getLeftmost()
        System.out.println("Leftmost Node: " + BTNode.getLeftmost(root).getData());
    }
}