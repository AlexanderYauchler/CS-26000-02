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

        System.out.println();

        // Test addBefore()
        LinkedBag<Position3D> bagA = new LinkedBag<>();
        bagA.add(new Position3D(0, 0, 0));
        bagA.add(new Position3D(10, 10, 10));
        bagA.add(new Position3D(20, 20, 20));
        System.out.println("bagA Contents:");
        bagA.print();

        System.out.println();

        LinkedBag<Position3D> bagB = new LinkedBag<>();
        bagB.add(new Position3D(0, 0, 0));
        bagB.add(new Position3D(20, 20, 20));
        bagB.addBefore(new Position3D(10, 10, 10), new Position3D(0, 0, 0));
        System.out.println("bagB Contents:");
        bagB.print();

        // Test equals()
        System.out.println();
        System.out.println("bagA == bagB: " + bagA.equals(bagB));
    }
}