/**
 * Alexander Yauchler | CS26000-02 | Homework 2
 */

package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        LinkedBag<Diamond> diamondBag = new LinkedBag<>();
        System.out.println("Current bag size: " + diamondBag.size());

        // Deserialize Diamonds File
        DiamondArrayBag serBag = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Diamonds.ser"))) {
            serBag = (DiamondArrayBag) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Add elements from bag
        for (int i = 0; i < serBag.size(); i++) {
            diamondBag.add(serBag.data[i]);
        }

        // Test bag size
        System.out.println("Current bag size: " + diamondBag.size());
        diamondBag.printAll();

        // Reference object for remove()
        Diamond d1 = new Diamond("h5845g", 4.1, "VS1", 'S', "rose");
        Diamond d2 = new Diamond("7fh583", 1.6, "I1", 'E', "lozenge");

        diamondBag.remove(d1); // Remove element with count > 1 (decrement in list)
        System.out.println("Current bag size: " + diamondBag.size());
        diamondBag.printAll();

        diamondBag.remove(d2); // Remove element with count == 1 (completely remove from list)
        System.out.println("Current bag size: " + diamondBag.size());
        diamondBag.printAll();
    }
}