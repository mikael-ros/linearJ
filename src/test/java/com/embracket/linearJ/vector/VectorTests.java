package com.embracket.linearJ.vector;

import com.embracket.linearJ.util.WrongDimensionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VectorTests {

    @BeforeEach
    void setUp(){

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testStringFormat(){
        Vector vector = new Vector(new int[]{0,0,0});
        assertEquals("(0,0,0)", vector.toString());
    }

    @Test
    void testEquals(){
        Vector vectorOne = new Vector(new int[]{0,0,0});
        Vector vectorTwo = new Vector(new int[]{0,0,0});
        assertEquals(vectorOne, vectorTwo);
    }

    @Test
    void testInversion(){
        Vector vector = new Vector(new int[]{1,-1,1});
        assertEquals(new Vector(new int[]{-1,1,-1}), vector.invert());
    }

    @Test
    void testGetDimension(){
        Vector vector = new Vector(new int[]{0,0,0});
        assertEquals(3, vector.getDimension());
    }

    @Test
    void testDifferentConstructors(){
        Vector vectorWithJustDimension = new Vector(3);
        assertEquals(new Vector(new int[]{0,0,0}), vectorWithJustDimension);
        Vector vectorWithDefinedCoordinates = new Vector(new int[]{1,1,1});
        assertEquals(new Vector(new int[]{1,1,1}), vectorWithDefinedCoordinates);
    }

    @Test
    void testAddition(){
        Vector vectorOne = new Vector(new int[]{0,0,0});
        Vector vectorTwo = new Vector(new int[]{1,1,1});
        assertEquals(new Vector(new int[]{1,1,1}), vectorOne.add(vectorTwo));
    }

    @Test
    void testAdditionDifferentDimension(){
        Vector vectorOne = new Vector(new int[]{0,0,0});
        Vector vectorTwo = new Vector(new int[]{1,1,1,1});
        assertThrows(WrongDimensionException.class, () -> {
            vectorOne.add(vectorTwo);
        });
    }

    @Test
    void testSubtraction(){
        Vector vectorOne = new Vector(new int[]{0,0,0});
        Vector vectorTwo = new Vector(new int[]{1,1,1});
        assertEquals(new Vector(new int[]{-1,-1,-1}), vectorOne.sub(vectorTwo));
    }
}
