package org.example;

public class Main {
    public static void main(String[] args) {
        String s = "baller";
        LinkedStack<Character> myStack = new LinkedStack<Character>();
        System.out.println(s);

        // Build string into stack
        for (int i = 0; i < s.length(); i++)
            myStack.push(s.charAt(i));

        // Create flipped stack
        LinkedStack<Character> flipped = myStack.flip();

        // Build stack into string
        StringBuilder myWord = new StringBuilder();
        while (!myStack.isEmpty())
            myWord.append(myStack.pop());
        System.out.println(myWord);

        // Text against original value
        System.out.println(s.equals(myWord.toString()));

        // Test flipped stack
        StringBuilder flippedWord = new StringBuilder();
        while (!flipped.isEmpty())
            flippedWord.append(flipped.pop());

        // Build new stacks
        for (int i = 0; i < s.length(); i++)
            myStack.push(s.charAt(i));

        flipped = myStack.flip();
        System.out.println("Flipped : " + flippedWord);

        // Test equals()
        System.out.println("Original == Flipped: " + LinkedStack.equals(myStack, flipped));
    }
}