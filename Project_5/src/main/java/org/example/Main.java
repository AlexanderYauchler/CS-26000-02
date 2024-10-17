package org.example;

public class Main {
    public static void main(String[] args) {
        ArrayBag<Integer> myBag = new ArrayBag<>();

        myBag.add(9);
        myBag.add(3);
        myBag.add(4);
        myBag.add(1);
        myBag.add(2);
        myBag.add(6);
        myBag.add(7);
        myBag.add(5);
        myBag.add(8);

        System.out.println("There are "+ myBag.countOccurrences(3)+ " copies.");
        System.out.println("There are "+ myBag.countOccurrences(30)+ " copies.");
        System.out.println("Current size: " + myBag.size());

        // Test search()
        System.out.println("Object 30 is at position: " + myBag.search(30));
        System.out.println("Object 3 is at position: " + myBag.search(3));

        // Test binarySearch()
        myBag.sort(); // Requires sorted array
        System.out.println("Object 30 is at position: " + myBag.binarySearch(30));
        System.out.println("Object 3 is at position: " + myBag.binarySearch(3));
    }
}