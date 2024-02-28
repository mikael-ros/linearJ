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

    public double getLength(){
        return Math.sqrt(scalarProduct(this));
    }

    public Vector invert(){
        Vector inverted = new Vector(3);
        for (int i = 0; i < getDimension(); i++) {
            inverted.getVector()[i] = -coordinates[i];
        }
        return inverted;
    }

    public Vector add(Vector vector){
        Vector result = new Vector(getDimension());
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

    /**
     * Multiplies with a vector and returns the scalar product
     * @param vector The vector multiplied with
     * @return The scalar product
     */
    public double scalarProduct(Vector vector){
        double result = 0;
        if (sameDimension(vector)){
            for (int i = 0; i < getDimension(); i++){
                result += vector.getVector()[i] * coordinates[i];
            }
        }
        return result;
    }

    /**
     * Multiplies with a scalar instead. Creates another vector with a constant value and multiplies it with this one
     * @param multiplier A scalar, integer
     * @return A new vector
     */
    public Vector linearMultiply(double multiplier){
        Vector result = new Vector(getDimension());
        for (int i = 0; i < getDimension(); i++){
            result.getVector()[i] = coordinates[i] * multiplier;
        }
        return result;
    }

    /**
     * Gets the unit vector, the vector with the same direction but length 1
     * @return The unit vector
     */
    public Vector getUnitVector() {
        return linearMultiply((1/getLength()));
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

