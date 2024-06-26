package com.embracket.linearJ.equation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import java.util.HashMap;
import java.util.Map;

import static com.embracket.linearJ.equation.EquationParser.parseEquation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EquationTests {
    private Map<String, Double> leftHand = new HashMap<>();
    private Map<String, Double> rightHand = new HashMap<>();
    @BeforeEach
    void setUp(){
        leftHand = new HashMap<>();
        rightHand = new HashMap<>();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyEquation(){
        leftHand.put("",0.0);
        rightHand.put("",0.0);

        Equation equation = new Equation();

        assertEquals(leftHand, equation.getLeftHand());
        assertEquals(rightHand, equation.getRightHand());
    }

    @Test
    void testNoCoefficients(){
        String equation = "x + y = 0";

        leftHand.put("x", 1.0);
        leftHand.put("y", 1.0);
        rightHand.put("",0.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testBasicEquation(){
        // Equation is 2x + 3y = 2
        String equation = "2x + 3y = 2";

        leftHand.put("x", 2.0);
        leftHand.put("y", 3.0);
        rightHand.put("",2.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationsWithBothHands(){
        String equation = "2x + 3y = 2z + 4a";

        leftHand.put("x", 2.0);
        leftHand.put("y", 3.0);
        rightHand.put("z",2.0);
        rightHand.put("a",4.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationWithNegativeCoefficients(){
        String equation = "-2x - 3y = 2";

        leftHand.put("x", -2.0);
        leftHand.put("y", -3.0);
        rightHand.put("",2.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationWithFractionCoefficients(){
        String equation = "2x + 3/2y = 2";

        leftHand.put("x", 2.0);
        leftHand.put("y", 1.5);
        rightHand.put("",2.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationWithDecimalCoefficients(){
        String equation = "2x + 0.1y = 2";

        leftHand.put("x", 2.0);
        leftHand.put("y", 0.1);
        rightHand.put("",2.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationWithLongVariableName(){
        String equation = "2x + ay = 2";

        leftHand.put("x", 2.0);
        leftHand.put("ay", 1.0);
        rightHand.put("",2.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationWithSubscriptVariableName(){
        String equation = "2x_1 + 3x_2 = 2";

        leftHand.put("x_1", 2.0);
        leftHand.put("x_2", 3.0);
        rightHand.put("",2.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationWithNoVariables(){
        String equation = "2 + 1 = 3";

        leftHand.put("", 3.0);
        rightHand.put("",3.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationWithNoVariablesOnlyNegative(){
        String equation = "-2 - 1 = -3";

        leftHand.put("", -3.0);
        rightHand.put("",-3.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationWithDuplicateVariables(){
        String equation = "2x + 4x = 2";

        leftHand.put("x", 6.0);
        rightHand.put("",2.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationWithSeveralDigitMultipliers(){
        String equation = "21x = 2";

        leftHand.put("x", 21.0);
        rightHand.put("",2.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testEquationWithDuplicateMultipliers(){
        String equation = "2x + 2y + 2 = 2";

        leftHand.put("x", 2.0);
        leftHand.put("y", 2.0);
        leftHand.put("", 2.0);
        rightHand.put("",2.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }

    @Test
    void testNegatedVariableMultipliers(){
        String equation = "2x - 2x + 2y + 2 = 2";

        leftHand.put("x", 0.0);
        leftHand.put("y", 2.0);
        leftHand.put("", 2.0);
        rightHand.put("",2.0);

        Equation parsedEquation = parseEquation(equation);

        assertEquals(leftHand, parsedEquation.getLeftHand());
        assertEquals(rightHand, parsedEquation.getRightHand());
    }
//    @Test
//    void testEquationWithWrongFormatThrowsBadEquationFormatException(){
//        String equation = "2x = 2 = 2";
//
//        assertThrows(BadEquationFormatException.class, () -> {
//            parseEquation(equation);
//        });
//    }
//
//    @Test
//    void testEquationOfIncorrectTypeThrowsWrongEquationTypeException(){
//        String equation = "2sin(x) = 1";
//
//        assertThrows(WrongEquationTypeException.class, () -> {
//            parseEquation(equation);
//        });
//    }
}
