package com.embracket.linearJ.line;

import com.embracket.linearJ.equation.Equation;
import com.embracket.linearJ.equation.EquationSystem;
import com.embracket.linearJ.point.Point;
import com.embracket.linearJ.vector.Vector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.embracket.linearJ.equation.EquationParser.parseEquation;
import static com.embracket.linearJ.equation.EquationParser.parseEquationSystem;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTests {
    @BeforeEach
    void setUp(){

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testSimpleLine(){
        Point point = new Point(new double[]{0.0,0.0,0.0});
        Vector direction = new Vector(new double[]{1.0,0.0,0.0});

        Line3D line = new Line3D(point, direction);
        Equation correspondingNormalEquation = parseEquation("x=0");
        EquationSystem correspondingParameterEquation = parseEquationSystem(new String[]{"x=0+t",
                                                                                         "y=0",
                                                                                         "z=0"});

        //assertEquals(line.getNormalForm(), correspondingNormalEquation); Need to implement normal!
        assertEquals(line.getParameterForm(), correspondingParameterEquation);
    }
}
