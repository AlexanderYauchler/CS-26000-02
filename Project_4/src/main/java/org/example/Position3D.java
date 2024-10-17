package org.example;

import java.util.Random;

public class Position3D implements Comparable {
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

    public Position3D(Position3D pos) {
        this.x = pos.x;
        this.y = pos.y;
        this.z = pos.z;
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


