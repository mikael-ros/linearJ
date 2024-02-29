package com.embracket.linearJ.vector;

/**
 * Operations that take vectors, modify them, and return a new vector
 */
public class VectorOperations {
    public static Vector add(Vector vectorOne, Vector vectorTwo){
        Vector result = new Vector(vectorOne.getDimension());
        if(vectorOne.sameDimension(vectorTwo)) {
            for (int i = 0; i < vectorOne.getDimension(); i++) {
                result.getVector()[i] = vectorOne.getVector()[i] + vectorTwo.getVector()[i];
            }
        }
        return result;
    }

    public static Vector sub(Vector vectorOne, Vector vectorTwo) {
        return add(vectorOne, invert(vectorTwo));
    }

    /**
     * Multiplies vectors and returns the scalar product
     * @param vectorOne
     * @param vectorTwo
     * @return The scalar product
     */
    public static double scalarProduct(Vector vectorOne, Vector vectorTwo){
        double result = 0;
        if (vectorOne.sameDimension(vectorTwo)){
            for (int i = 0; i < vectorOne.getDimension(); i++){
                result += vectorOne.getVector()[i] * vectorTwo.getVector()[i];
            }
        }
        return result;
    }

    /**
     * Multiplies with a scalar instead. Creates another vector with a constant value and multiplies it with this one
     * @param multiplier A scalar, integer
     * @return A new vector
     */
    public static Vector linearMultiply(Vector vector, double multiplier){
        Vector result = new Vector(vector.getDimension());
        for (int i = 0; i < vector.getDimension(); i++){
            result.getVector()[i] = vector.getVector()[i] * multiplier;
        }
        return result;
    }

    public static double getLength(Vector vector){
        return Math.sqrt(scalarProduct(vector,vector));
    }


    public static Vector invert(Vector vector){
        return linearMultiply(vector, -1);
    }

    /**
     * Gets the unit vector, the vector with the same direction but length 1
     * @return The unit vector
     */
    public static Vector getUnitVector(Vector vector) {
        return linearMultiply(vector,(1/getLength(vector)));
    }
}
