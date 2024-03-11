package com.embracket.linearJ.vector;

import static com.embracket.linearJ.point.PointOperations.*;
import com.embracket.linearJ.util.WrongDimensionException;
import com.embracket.linearJ.point.Point;

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

    /**
     * Creates a vector from 2 points, "end point - begin point"
     * @param p1 The origin point
     * @param p2 The end point
     */
    public Vector(Point p1, Point p2){
        this.coordinates = sub(p2,p1).getCoordinates();
    }

    /**
     * Creates a origin vector (a vector with the same coordinates as the point itself)
     * @param p The point
     */
    public Vector(Point p){
        this.coordinates = p.getCoordinates();
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

