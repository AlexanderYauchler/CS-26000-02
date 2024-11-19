package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Diamond> pQueue = new PriorityQueue<>(4);

        // Deserialize Diamonds File
        DiamondArrayBag serBag = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Diamonds.ser"))) {
            serBag = (DiamondArrayBag) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Add elements from bag
        for (int i = 0; i < serBag.size(); i++) {
            pQueue.enqueue(serBag.data[i], new Random().nextInt(4));
        }

        // Display queue
        pQueue.showQueue();

        // Test clone() & dequeue()
        PriorityQueue<Diamond> pClone = pQueue.clone();
        pQueue.dequeue();

        // Peek on both
        System.out.println(pQueue.peek());
        System.out.println(pClone.peek());

        // Test sizes before printing
        System.out.println("pQueue size : " + pQueue.size());
        System.out.println("pClone size : " + pClone.size());

        System.out.print("pQueue : [ ");
        for (int i = 0; i < pQueue.size(); i++) {
            System.out.print(pQueue.dequeue());
        }
        System.out.println(" ]");

        // Print all elements
        System.out.print("pClone : [ ");
        for (int i = 0; i < pClone.size(); i++) {
            System.out.print(pClone.dequeue());
        }
        System.out.println(" ]");

        // Test sizes after printing
        System.out.println("pQueue size : " + pQueue.size());
        System.out.println("pClone size : " + pClone.size());

        // The queues are emptied while printing due to the use of dequeue()
        // Which modifies the state of the queue
    }
}