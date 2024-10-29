package org.example;

import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        LinkedStack<Position3D> stack = new LinkedStack<>();

        stack.push(new Position3D());
        stack.push(new Position3D());
        stack.push(new Position3D());

        while (!stack.isEmpty()) {
            Position3D obj = stack.pop();
            System.out.println("[" + obj.getX() + ", " + obj.getY() + ", " + obj.getZ() + "]");
        }

        try { // This will throw an EmptyStackException
            stack.peek();
        } catch (EmptyStackException e) {
            System.out.println(e);
        }

        // Test using StackIterator
        stack.push(new Position3D());
        stack.push(new Position3D());
        stack.push(new Position3D());

        StackIterator<Position3D> it = stack.getIterator();

        while (it.hasNext()) {
            Position3D obj = it.next();
            System.out.println("[" + obj.getX() + ", " + obj.getY() + ", " + obj.getZ() + "]");
        }

        try {
            stack.peek();
        } catch (EmptyStackException e) {
            System.out.println(e);
        }
    }
}

/*
 * Stack status:
 *
 * [Position3D]
 * [Position3D -> Position3D]
 * [Position3D -> Position3D -> Position3D]
 * [Position3D -> Position3D]
 * [Position3D]
 */