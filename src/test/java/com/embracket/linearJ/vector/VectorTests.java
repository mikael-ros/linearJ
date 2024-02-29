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
    void testGetDimension(){
        Vector vector = new Vector(new double[]{0,0,0});
        assertEquals(3, vector.getDimension());
    }
}
