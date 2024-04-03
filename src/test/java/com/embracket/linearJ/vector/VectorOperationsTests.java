package com.embracket.linearJ.vector;

import com.embracket.linearJ.util.WrongDimensionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.embracket.linearJ.vector.VectorOperations.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VectorOperationsTests {
    @BeforeEach
    void setUp(){

    }

    @AfterEach
    void tearDown() {

    }
    @Test
    void testGetLengthOfZeroVector(){
        Vector vector = new Vector(new double[]{0,0,0});
        assertEquals(0, getLength(vector));
    }

    @Test
    void testGetLength(){
        Vector vector = new Vector(new double[]{3,0,0});
        assertEquals(3, getLength(vector));
    }

    @Test
    void testInversion(){
        Vector vector = new Vector(new double[]{1,-1,1});
        assertEquals(new Vector(new double[]{-1,1,-1}), invert(vector));
    }

    @Test
    void testAddition(){
        Vector vectorOne = new Vector(new double[]{0,0,0});
        Vector vectorTwo = new Vector(new double[]{1,1,1});
        assertEquals(new Vector(new double[]{1,1,1}), add(vectorOne,vectorTwo));
    }

    @Test
    void testAdditionDifferentDimension(){
        Vector vectorOne = new Vector(new double[]{0,0,0});
        Vector vectorTwo = new Vector(new double[]{1,1,1,1});
        assertThrows(WrongDimensionException.class, () -> {
            add(vectorOne,vectorTwo);
        });
    }

    @Test
    void testSubtraction(){
        Vector vectorOne = new Vector(new double[]{0,0,0});
        Vector vectorTwo = new Vector(new double[]{1,1,1});
        assertEquals(new Vector(new double[]{-1,-1,-1}), sub(vectorOne,vectorTwo));
    }

    @Test
    void testScalarProduct(){
        Vector vectorOne = new Vector(new double[]{2,2,2});
        Vector vectorTwo = new Vector(new double[]{1,1,1});
        assertEquals(6, scalarProduct(vectorOne, vectorTwo));
    }

    @Test
    void testScalarProductDifferentDimension(){
        Vector vectorOne = new Vector(new double[]{0,0,0});
        Vector vectorTwo = new Vector(new double[]{1,1,1,1});
        assertThrows(WrongDimensionException.class, () -> {
            scalarProduct(vectorOne,vectorTwo);
        });
    }

    @Test
    void testLinearMultiply(){
        Vector vector = new Vector(new double[]{1,2,3});
        assertEquals(new Vector(new double[]{2,4,6}), linearMultiply(vector, 2));
    }

    @Test
    void testGetUnitVector(){
        Vector vector = new Vector(new double[]{3,0,0});
        assertEquals(new Vector(new double[]{1,0,0}), getUnitVector(vector));
    }

    @Test
    void testVectorProduct(){
        // This test corresponds to example 1.11
        Vector vectorOne = new Vector(new double[]{1,2,-2});
        Vector vectorTwo = new Vector(new double[]{-1,2,2});

        assertEquals(new Vector(new double[]{8,0,4}), vectorProduct(vectorOne, vectorTwo));
    }

    @Test
    void testVectorProductDifferentDimension(){
        Vector vectorOne = new Vector(new double[]{0,0,0});
        Vector vectorTwo = new Vector(new double[]{1,1,1,1});
        assertThrows(WrongDimensionException.class, () -> {
            vectorProduct(vectorOne,vectorTwo);
        });
    }
}
