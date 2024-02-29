package com.embracket.linearJ.plane;

import com.embracket.linearJ.vector.Vector;
import com.embracket.linearJ.vector.Vector3D;
import static com.embracket.linearJ.vector.VectorOperations.*;

import java.util.Arrays;

public class Plane {
    private Vector axisOne, axisTwo;

    /**
     * Construct plane using two vectors (parameter form)
     * @param axisOne first axis
     * @param axisTwo second axis
     */
    public Plane(Vector3D axisOne, Vector3D axisTwo){
        this.axisOne = getUnitVector(axisOne);
        this.axisTwo = getUnitVector(axisTwo);
    }

    /**
     * Constructs plane using normal vector (normal form)
     * @param normal The normal vector, that is orthagonal
     */
//    public Plane(Vector3D normal){
//        this.axisOne = normal.getOrthagonals()[0].getUnitVector();
//        this.axisTwo = normal.getOrthagonals()[1].getUnitVector();
//    }

    public Vector calculateNormal(){
        return new Vector3D(new double[]{0, 0, 0});
    }

    public Vector[] getAxis(){
        return new Vector[]{axisOne, axisTwo};
    }

    /**
     * Considered equal if planes have same axis'
     * @param object compared to
     * @return wheter it is equal
     */
    public boolean equals(Object object){
        if (object.getClass() == Plane.class) {
            Plane other = (Plane) object;
            return
                    Arrays.equals(other.getAxis(), getAxis());
        } else {
            return false;
        }
    }

    /**
     * Makes string out of
     * @return the first vector + the second
     */
    public String toString(){
        return axisOne.toString() + axisTwo.toString();
    }
}
