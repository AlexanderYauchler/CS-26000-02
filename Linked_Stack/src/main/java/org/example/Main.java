package org.example;

public class Main {
    public static void main(String[] args) {
        String s = "radar";
        LinkedStack<Character> myStack = new LinkedStack<Character>();
        System.out.println(s);

        // Build string into stack
        for (int i = 0; i < s.length(); i++)
            myStack.push(s.charAt(i));

        // Test display()
        myStack.display();

        // Test size()
        System.out.println("Stack Size vs Word Size: " + myStack.size() + " vs " + s.length());

        // Create flipped stack
        LinkedStack<Character> flipped = myStack.flip();
        LinkedStack<Character> flipped2 = flipped.flip();

        // Build stack into string
        StringBuilder myWord = new StringBuilder();
        while (!myStack.isEmpty())
            myWord.append(myStack.pop());
        System.out.println(myWord);

        // Test flipped stack
        StringBuilder flippedWord = new StringBuilder();
        while (!flipped2.isEmpty())
            flippedWord.append(flipped2.pop());

        System.out.println("Flipped : " + flippedWord);

        // Build new stack
        for (int i = 0; i < s.length(); i++)
            myStack.push(s.charAt(i));

        flipped = myStack.flip();

        // Test equals()
        System.out.println("Original == Flipped: " + LinkedStack.equals(myStack, flipped));
    }
}