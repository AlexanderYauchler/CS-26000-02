package org.example;

import java.util.Random;

class Position3D implements Comparable {
    private double x;
    private double y;
    private double z;

    public Position3D() {
        Random rand = new Random();
        this.x = rand.nextInt(100);
        this.y = rand.nextInt(100);
        this.z = rand.nextInt(100);
    }

    public Position3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() { return x; }
    public void setX(double x) {this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }
    public double distanceTo(Position3D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double dz = this.z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    @Override
    public String toString() {
        return String.format("(x=%.2f, y=%.2f, z=%.2f)", x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Position3D posObj = (Position3D) obj;

        return (this.x == posObj.x && this.y == posObj.y && this.z == posObj.z);
    }

    @Override
    public Position3D clone() throws CloneNotSupportedException {
        return new Position3D(this.x, this.y, this.z);
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        if (o.getClass() != this.getClass()) {
            throw new ClassCastException();
        }

        Position3D posObj = (Position3D) o;

        double thisDist = this.distanceTo(new Position3D(0.0, 0.0, 0.0));
        double objDist = posObj.distanceTo(new Position3D(0.0, 0.0, 0.0));

        if (thisDist > objDist) { return -1; }
        if (thisDist == objDist) { return 0; }
        if (thisDist < objDist) { return 1; }

        return 0;
    }
}

public class MyMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Position3D point1 = new Position3D(1.0, 2.0, 3.0);
        Position3D point2 = new Position3D(4.0, 5.0, 6.0);
        Position3D point3 = point1.clone();
        Position3D point4 = new Position3D();

        System.out.println("Point 1: " + point1);
        System.out.println("Point 2: " + point2);

        System.out.printf("Distance between Point 1 and Point 2: %.2f%n\n",
                point1.distanceTo(point2));

        System.out.printf("Point4 Values: %s\n", point4);

        System.out.printf("Point1 is equal to Point2: %b\n", point1.equals(point2));
        System.out.printf("Point1 is equal to Point3: %b\n", point1.equals(point3));
        System.out.printf("Point1 is equal to Point4: %b\n", point1.equals(point4));
    }
} 
