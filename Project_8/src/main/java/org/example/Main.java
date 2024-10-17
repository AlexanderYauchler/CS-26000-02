package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nTesting for Position3DLinkedBag :");

        LinkedBag<Position3D> posBagA = new LinkedBag<>();
        System.out.println("Current bagA size: " + posBagA.size());

        // Initial state
        posBagA.add(new Position3D(100, 100, 100));
        posBagA.add(new Position3D(150, 150, 150));
        posBagA.add(new Position3D(210, 210, 210));

        // Test countOccurrences()
        System.out.println("There are " + posBagA.countOccurrences(new Position3D(100, 100, 100)) + " copies.");
        System.out.println("There are " + posBagA.countOccurrences(new Position3D(400, 400, 400)) + " copies.");

        // Test remove()
        posBagA.remove(new Position3D(100, 100, 100));
        System.out.println("Current bagA size: " + posBagA.size());

        // Test grab()
        System.out.println("Grab result: " + posBagA.grab());

        // Test union()
        LinkedBag<Position3D> posBagB = new LinkedBag<>();
        posBagB.add(new Position3D(100, 100, 100));
        posBagB.add(new Position3D(200, 150, 150));
        posBagB.add(new Position3D(300, 210, 210));

        System.out.println("Current bagB size: " + posBagB.size());
        System.out.println("Current bagA size: " + posBagA.size());

        LinkedBag<Position3D> unionBag = LinkedBag.union(posBagA, posBagB);
        System.out.println("Current unionBag size: " + unionBag.size());

        // Test printReversed()
        posBagB.printReversed();
    }
}