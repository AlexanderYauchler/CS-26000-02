package org.example;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Position3DArrayBag myBag = new Position3DArrayBag();

        System.out.println("Current Capacity: " + myBag.getCapacity());

        myBag.add(new Position3D(10, 10, 10));
        myBag.add(new Position3D(20, 20, 20));
        myBag.add(new Position3D(10, 10, 10));

        // Test trimToSize()
        System.out.println("Current Capacity: " + myBag.getCapacity());
        myBag.trimToSize();
        System.out.println("Current Capacity: " + myBag.getCapacity());

        // Test union()
        Position3DArrayBag bagA = new Position3DArrayBag();
        bagA.add(new Position3D());
        bagA.add(new Position3D());
        bagA.add(new Position3D());
        System.out.println("BagA Capacity: " + bagA.getCapacity());

        // Test copy contructor
        Position3DArrayBag bagB = new Position3DArrayBag(bagA);
        System.out.println("BagB Capacity: " + bagB.getCapacity());

        Position3DArrayBag bagC = Position3DArrayBag.union(bagA, bagB);
        System.out.println("BagC Capacity: " + bagC.getCapacity());
    }
}