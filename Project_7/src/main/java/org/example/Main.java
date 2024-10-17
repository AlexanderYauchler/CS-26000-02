package org.example;

public class Main {
    public static void main(String[] args) {
        IntLinkedBag myBag = new IntLinkedBag();
        System.out.println("Current size: " + myBag.size());

        // Initial state
        myBag.add(100);
        myBag.add(150);
        myBag.add(100);
        myBag.add(120);
        myBag.add(200);
        myBag.add(310);

        // Test countOccurrences()
        System.out.println("There are " + myBag.countOccurrences(100) + " copies.");
        System.out.println("There are " + myBag.countOccurrences(400) + " copies.");

        // Test remove()
        myBag.remove(100);
        System.out.println("Current size: " + myBag.size());

        // Test grab()
        System.out.println("Grab result: " + myBag.grab());


        // Test Position3DLinkedBag
        System.out.println("\nTesting for Position3DLinkedBag :");

        Position3DLinkedBag posBag = new Position3DLinkedBag();
        System.out.println("Current size: " + posBag.size());

        // Initial state
        posBag.add(new Position3D(100, 100, 100));
        posBag.add(new Position3D(150, 150, 150));
        posBag.add(new Position3D(100, 100, 100));
        posBag.add(new Position3D(120, 120, 120));
        posBag.add(new Position3D(300, 300, 300));
        posBag.add(new Position3D(210, 210, 210));

        // Test countOccurrences()
        System.out.println("There are " + posBag.countOccurrences(new Position3D(100, 100, 100)) + " copies.");
        System.out.println("There are " + posBag.countOccurrences(new Position3D(400, 400, 400)) + " copies.");

        // Test remove()
        posBag.remove(new Position3D(100, 100, 100));
        System.out.println("Current size: " + posBag.size());

        // Test grab()
        System.out.println("Grab result: " + posBag.grab());
    }
}

/*
 * Program state:
 *
 * Initial state    100 -> 150 -> 100
 * remove(100)      150 -> 100
 */