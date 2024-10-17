package org.example;

public class Main {
    public static void main(String[] args) {
        Table phoneDir = new Table(8);

        phoneDir.put(2110, "Hope");
        phoneDir.put(4625, "Sophia");
        phoneDir.put(2433, "Claire");
        phoneDir.put(3545, "Friedrich");
        phoneDir.put(1100, "Leonardo");
        phoneDir.put(3363, "Layla");
        phoneDir.put(8927, "Astrid");
        phoneDir.put(8888, "Haruto");

        // Depict the final state of the table
        System.out.println("[2110] : " + phoneDir.get(2110));
        System.out.println("[4625] : " + phoneDir.get(4625));
        System.out.println("[2433] : " + phoneDir.get(2433));
        System.out.println("[3545] : " + phoneDir.get(3545));
        System.out.println("[1100] : " + phoneDir.get(1100));
        System.out.println("[3363] : " + phoneDir.get(3363));
        System.out.println("[8927] : " + phoneDir.get(8927));

        try {
            // This exceeds the limit of the table
            System.out.println("[8888] : " + phoneDir.get(8888));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test get(), takes 2 steps to find using findIndex() internally
        System.out.println("\nTable size : " + phoneDir.size());
        System.out.println("Extension 1100 : " + phoneDir.get(1100));

        // Test remove()
        phoneDir.remove(3545);
        System.out.println("\nRemoving entry 3545.\nTable size : " + phoneDir.size());
    }
}

/**
 * Hash code generation walkthrough
 *
 * "Hope" len(4)
 * 72*31^3 + 111*31^2 + 112*31^1 + 101*31^0
 * 2144952 + 106671 + 3472 + 101
 * 2255196 % 10
 * 6 % 4 = 2
 */