package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Position3D> numbers = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            numbers.add(new Position3D());
        }

        System.out.println("First Element: " + numbers.get(0).toString());
        System.out.println("Last Element: " + numbers.get(numbers.size() - 1).toString());

        numbers.remove(1);

        boolean containsOrigin = numbers.contains(new Position3D(0, 0, 0));
        if (!containsOrigin) {
            numbers.add(1, new Position3D(0, 0, 0));
        }

        System.out.println("Size of Array: " + numbers.size());

        Collections.sort(numbers);
        System.out.println("Farthest point from origin: " + numbers.get(0).toString());
    }
}