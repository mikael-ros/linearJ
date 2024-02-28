package com.embracket.linearJ.point;

import com.embracket.linearJ.vector.Vector;

public class Point {
    private int[] coordinates;

    public Point(int[] coordinates){
        this.coordinates = coordinates;
    }

    public Point(int dimension){
        coordinates = new int[dimension];
    }

    public int getDimension(){
        return coordinates.length;
    }

    public boolean sameDimension(Vector vector){
        return getDimension() == vector.getDimension();
    }

    public boolean equals(Object object){
        if (object.getClass() == Vector.class) {
            boolean same = true;
            Vector other = (Vector) object;
            if (sameDimension(other)) {
                for (int i = 0; i < getDimension(); i++) {
                    if (coordinates[i] != other.getVector()[i]) {
                        same = false;
                        break;
                    }
                }
            } else {
                same = false;
            }
            return same;
        } else {
            return false;
        }
    }

    public String toString(){
        String readable = "";
        for (int i = 0; i < getDimension(); i++){
            readable = readable + coordinates[i];
            if (i < getDimension() - 1){
                readable += ",";
            }
        }
        return "(" + readable + ")";
    }
}
