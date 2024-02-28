package com.embracket.linearJ.vector;

import com.embracket.linearJ.util.WrongDimensionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTests {

    @BeforeEach
    void setUp(){

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testCoordinateConstructor(){
        assertArrayEquals(new double[]{1,2,3}, (new Vector(new double[]{1,2,3}).getVector()));

    }

    @Test
    void testDimensionConstructor(){
        assertArrayEquals(new double[]{0,0,0}, (new Vector(3).getVector()));
    }

    @Test
    void testConstantConstructor(){
        assertArrayEquals(new double[]{1,1,1}, (new Vector(1,3).getVector()));
    }

    @Test
    void testStringFormat(){
        Vector vector = new Vector(new double[]{0,0,0});
        assertEquals("(0.0,0.0,0.0)", vector.toString());
    }

    @Test
    void testEquals(){
        Vector vectorOne = new Vector(new double[]{0,0,0});
        Vector vectorTwo = new Vector(new double[]{0,0,0});
        assertEquals(vectorOne, vectorTwo);
    }

    @Test
    void testGetLengthOfZeroVector(){
        Vector vector = new Vector(new double[]{0,0,0});
        assertEquals(0, vector.getLength());
    }

    @Test
    void testGetLength(){
        Vector vector = new Vector(new double[]{3,0,0});
        assertEquals(3, vector.getLength());
    }

    @Test
    void testInversion(){
        Vector vector = new Vector(new double[]{1,-1,1});
        assertEquals(new Vector(new double[]{-1,1,-1}), vector.invert());
    }

    @Test
    void testGetDimension(){
        Vector vector = new Vector(new double[]{0,0,0});
        assertEquals(3, vector.getDimension());
    }

    @Test
    void testDifferentConstructors(){
        Vector vectorWithJustDimension = new Vector(3);
        assertEquals(new Vector(new double[]{0,0,0}), vectorWithJustDimension);
        Vector vectorWithDefinedCoordinates = new Vector(new double[]{1,1,1});
        assertEquals(new Vector(new double[]{1,1,1}), vectorWithDefinedCoordinates);
    }

    @Test
    void testAddition(){
        Vector vectorOne = new Vector(new double[]{0,0,0});
        Vector vectorTwo = new Vector(new double[]{1,1,1});
        assertEquals(new Vector(new double[]{1,1,1}), vectorOne.add(vectorTwo));
    }

    @Test
    void testAdditionDifferentDimension(){
        Vector vectorOne = new Vector(new double[]{0,0,0});
        Vector vectorTwo = new Vector(new double[]{1,1,1,1});
        assertThrows(WrongDimensionException.class, () -> {
            vectorOne.add(vectorTwo);
        });
    }

    @Test
    void testSubtraction(){
        Vector vectorOne = new Vector(new double[]{0,0,0});
        Vector vectorTwo = new Vector(new double[]{1,1,1});
        assertEquals(new Vector(new double[]{-1,-1,-1}), vectorOne.sub(vectorTwo));
    }

    @Test
    void testScalarProduct(){
        Vector vectorOne = new Vector(new double[]{2,2,2});
        Vector vectorTwo = new Vector(new double[]{1,1,1});
        assertEquals(6, vectorOne.scalarProduct(vectorTwo));
    }

    @Test
    void testScalarProductDifferentDimension(){
        Vector vectorOne = new Vector(new double[]{0,0,0});
        Vector vectorTwo = new Vector(new double[]{1,1,1,1});
        assertThrows(WrongDimensionException.class, () -> {
            vectorOne.scalarProduct(vectorTwo);
        });
    }

    @Test
    void testLinearMultiply(){
        Vector vector = new Vector(new double[]{1,2,3});
        assertEquals(new Vector(new double[]{2,4,6}), vector.linearMultiply(2));
    }

    @Test
    void testGetUnitVector(){
        Vector vector = new Vector(new double[]{3,0,0});
        assertEquals(new Vector(new double[]{1,0,0}), vector.getUnitVector());
    }
}
