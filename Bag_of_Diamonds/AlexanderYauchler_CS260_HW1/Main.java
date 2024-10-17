package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        DiamondArrayBag DBag1 = new DiamondArrayBag();

        DBag1.add(new Diamond("h5845g", 4.1, "VS1", 'S', "rose"));
        DBag1.add(new Diamond("h5845g", 4.1, "VS1", 'S', "rose"));
        DBag1.add(new Diamond("h5845g", 4.1, "VS1", 'S', "rose"));
        DBag1.add(new Diamond("7fh583", 1.6, "I1", 'E', "lozenge"));
        DBag1.add(new Diamond("f454df", 2.2, "FL", 'T', "pear"));
        DBag1.add(new Diamond("34645n", 3.0, "VVS1", 'Z', "lozenge"));
        DBag1.add(new Diamond("b23476", 1.2, "VVS2", 'X', "brilliant"));
        DBag1.add(new Diamond("88452m", 2.6, "I3", 'D', "pear"));


        // Test copy constructor and intersection()
        DiamondArrayBag DBag2 = new DiamondArrayBag(DBag1);
        DiamondArrayBag DBag3 = DiamondArrayBag.intersection(DBag1, DBag2);

        // Test trimToSize() : Cuts to size
        System.out.println("Bag3 Size: " + DBag3.size());
        DBag3.trimToSize(3);
        System.out.println("Bag3 Size: " + DBag3.size());

        // Serialize object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Diamonds.ser"))) {
            out.writeObject(DBag3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Deserialize Object
        DiamondArrayBag serBag = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Diamonds.ser"))) {
            serBag = (DiamondArrayBag) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Count occurrences of first diamond
        Diamond first = serBag.data[0];
        int count = 1;

        for(int i =0; i < serBag.size() - 1; i++) {
            if(serBag.data[i].equals(first)){
                count++;
            }
        }

        System.out.println("There are " + count + " occurrences of the first diamond!");
        serBag.remove(first);

        // If we attempt to remove the diamond again then we would be return the same array,
        // as the object supplied to remove() is not in the target array
    }
}