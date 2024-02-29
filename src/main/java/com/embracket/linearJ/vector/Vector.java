package com.embracket.linearJ.vector;

import com.embracket.linearJ.util.WrongDimensionException;

public class Vector {
    private double[] coordinates;
    public Vector(double[] coordinates){
        this.coordinates = coordinates;
    }
    public Vector(int dimension){
        this.coordinates = new double[dimension];
    }

    public Vector(double constant, int dimension){
        this.coordinates = new double[dimension];
        setConstant(constant);
    }

    public int getDimension(){
        return coordinates.length;
    }

    public boolean sameDimension(Vector vector){
        return getDimension() == vector.getDimension();
    }

    public double[] getVector(){
        return coordinates;
    }

    public void setVector(Vector vector){
        if (sameDimension(vector)){
            setVector(vector.getVector());
        }
    }

    public void setVector(double[] coordinates){
        if (coordinates.length == this.coordinates.length) {
            this.coordinates = coordinates;
        }
    }

    public void setConstant(double constant){
        for (int i = 0; i < getDimension(); i++){
            coordinates[i] = constant;
        }
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

