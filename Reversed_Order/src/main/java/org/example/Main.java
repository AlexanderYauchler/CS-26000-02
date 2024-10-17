package org.example;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        String[] myLine = {"Hello", "from", "the", "other", "side!", "ᓚᘏᗢ"};

        // Reverse by word
        ArrayStack<String> stack = new ArrayStack<>();
        for (String s : myLine)
            stack.push(s);
        String fullStr = stack.toString();

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        // Reverse by character
        ArrayStack<Character> charStack = new ArrayStack<>();
        for (int i = 0; i < fullStr.length(); i++) {
            charStack.push(fullStr.charAt(i));
        }

        while (!charStack.isEmpty()) {
            System.out.print(charStack.pop());
        }
        System.out.println();

        // Test equals() override
        ArrayStack<String> testStack = new ArrayStack<>();
        for (String s : myLine)
            testStack.push(s);
        System.out.println("Stack = testStack? " + stack.equals(testStack));

        // Test static equals() & clone()
        stack = testStack.clone();
        System.out.println("Stack = testStack? " + ArrayStack.equals(stack, testStack));
    }
}

/* O(n) time complexity
 *
 * Stack contents:
 * []
 * [Hello]
 * [Hello, from]
 * [Hello, from, the]
 * [Hello, from, the, other]
 * [Hello, from, the, other, side!]
 * [Hello, from, the, other]
 * [Hello, from, the]
 * [Hello, from]
 * [Hello]
 * []
 */