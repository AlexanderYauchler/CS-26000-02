package org.example;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayBag<Position3D> myBag = new ArrayBag<>();

        System.out.println("Current Capacity: " + myBag.getCapacity());
        myBag.add(new Position3D(10, 10, 10));
        myBag.add(new Position3D(20, 20, 20));
        myBag.add(new Position3D(10, 10, 10));

        System.out.println("Current Capacity: " + myBag.getCapacity());
        myBag.trimToSize();
        System.out.println("Current Capacity: " + myBag.getCapacity());
        System.out.println("Current size: " + myBag.size());
        ArrayBag<Position3D> copiedBag = new ArrayBag<>(myBag);

        copiedBag.add(new Position3D(40, 40, 40));
        System.out.println("Copied bag Size: " + copiedBag.size());
        System.out.println("Copied Bag Capacity: " + copiedBag.getCapacity());

        ArrayBag<Position3D> unionBag = ArrayBag.union(myBag, copiedBag);
        System.out.println("Union Bag Size: " + unionBag.size());
        System.out.println("Union Bag Capacity: " + unionBag.getCapacity());

        unionBag.add(new Position3D());
        unionBag.add(new Position3D());
        unionBag.add(new Position3D());
        System.out.println("Grab Random Element: " + unionBag.grab());
        System.out.println("Grab Random Element: " + unionBag.grab());

        ArrayBag<Position3D> bagA = new ArrayBag<>();
        bagA.add(new Position3D());
        bagA.add(new Position3D());
        bagA.add(new Position3D());

        ArrayBag<Position3D> bagB = new ArrayBag<>();
        bagB.add(new Position3D());
        bagB.add(new Position3D());
        bagB.add(new Position3D());

        System.out.println("bagA Size: " + bagA.size());
        System.out.println("bagB Size: " + bagB.size());
        bagA.addAll(bagB);
        System.out.println("bagA Size: " + bagA.size());
    }
}