package com.embracket.linearJ.vector;

import com.embracket.linearJ.util.WrongDimensionException;

public class Vector {
    private int[] coordinates;
    public Vector(int[] coordinates){
        this.coordinates = coordinates;
    }
    public Vector(int dimension){
        this.coordinates = new int[dimension];
    }

    public int getDimension(){
        return coordinates.length;
    }

    public boolean sameDimension(Vector vector){
        return getDimension() == vector.getDimension();
    }

    public int[] getVector(){
        return coordinates;
    }

    public void setVector(Vector vector){
        if (sameDimension(vector)){
            setVector(vector.getVector());
        }
    }

    public void setVector(int[] coordinates){
        if (coordinates.length == this.coordinates.length) {
            this.coordinates = coordinates;
        }
    }

    public Vector invert(){
        Vector inverted = new Vector(3);
        for (int i = 0; i < getDimension(); i++) {
            inverted.getVector()[i] = -coordinates[i];
        }
        return inverted;
    }

    public Vector add(Vector vector){
        Vector result = new Vector(3);
        if(sameDimension(vector)) {
            for (int i = 0; i < getDimension(); i++) {
                result.getVector()[i] = coordinates[i] + vector.getVector()[i];
            }
        }
        return result;
    }

    public Vector sub(Vector vector) {
        return add(vector.invert());
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

