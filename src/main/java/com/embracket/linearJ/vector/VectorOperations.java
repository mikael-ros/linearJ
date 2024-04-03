package com.embracket.linearJ.vector;

import com.embracket.linearJ.util.WrongDimensionException;

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

    /**
     * Calculates the vector product u x v = (a1, a2, a3) x (b1, b2, b3) = (a2b3 - a3b2, a3b1 - a1b3, a1b2 - a2b1)
     * @param vectorOne A vector
     * @param vectorTwo Another vector, to be multiplied with
     * @return A new vector, if both vectors are same dimension and 3D
     * @throws WrongDimensionException If the vectors aren't the same dimension, or aren't 3D, since such operations are not defined
     */
    public static Vector3D vectorProduct(Vector3D vectorOne, Vector3D vectorTwo) {
        double[] v1Coords = vectorOne.getVector();
        double[] v2Coords = vectorTwo.getVector();
                       // Writing several on same line for readability
        /* Vector One */ double a1 = v1Coords[0]; double a2 = v1Coords[1]; double a3 = v1Coords[2];
        /* Vector Two */ double b1 = v2Coords[0]; double b2 = v2Coords[1]; double b3 = v2Coords[2];

        double[] resultVectorCoordinates = new double[]{a2*b3 - a3*b2, a3*b1 - a1*b3, a1*b2 - a2*b1};
        return new Vector3D(resultVectorCoordinates);
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

    /**
     * The orthogonal projection of a vector onto another, defined for 2D and 3D vectors. u' = (u * e) * e, where e is the unit vector
     * @param vector The vector being projected
     * @param projector The vector being projected onto
     * @return The resulting orthogonal projection vector
     */
    public static Vector projectOrthogonal(Vector vector, Vector projector){
        if (vector.sameDimension(projector) && vector.getDimension() > 1 && vector.getDimension() < 4) {
            Vector unitProjector = getUnitVector(projector);
            return linearMultiply(unitProjector, scalarProduct(vector, unitProjector));
        }
        return new Vector(vector.getDimension()); // Temporary, this should throw an exception.
    }


}
