package org.example;

import java.io.Serializable;

public class Diamond
        implements Cloneable, Serializable, Comparable<Diamond> {
    // Private member variables
    private String stockNum;
    private double size;
    private String clarity;
    private Character color;
    private String cut;


    // Default constructor
    public Diamond(
            String stockNum,
            double size,
            String clarity,
            Character color,
            String cut
    ) {
        this.stockNum = stockNum;
        this.size = size;
        this.clarity = clarity;
        this.color = color;
        this.cut = cut;
    }

    // Returns this object's data formatted into a string
    public String toString() {
        return "Diamond : \n[Stock #] - " + this.stockNum + "\n[Size] : " + this.size
                + "\n[Clarity] - " + this.clarity + "\n[Color] - " + this.color
                + "\n[Cut] - " + this.cut;
    }

    // Override of clone()
    @Override
    public Diamond clone() throws CloneNotSupportedException {
        return (Diamond) super.clone();
    }

    // Override compareTo() to compare individual data members
    @Override // TODO : This annoying function
    public int compareTo(Diamond o) {
        int result;

        if ((result = Double.compare(this.size, o.size)) != 0)
            return result;

        if ((result = this.clarity.compareTo(o.clarity)) != 0)
            return result;

        if ((char) this.color != o.color)
            return result;

        return 0;
    }
}
