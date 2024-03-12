package com.embracket.linearJ.equation;

import java.util.HashMap;
import java.util.Map;

import static com.embracket.linearJ.equation.EquationParser.parseEquation;

public class Equation {
    private Map<String, Double> leftHand;
    private Map<String, Double> rightHand;


    public Equation(){
        leftHand = new HashMap<>();
        rightHand = new HashMap<>();

        leftHand.put("", 0.0);
        rightHand.put("", 0.0);
    }

    public Equation(Map<String, Double> leftHand, Map<String, Double> rightHand){
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }
    public Map<String, Double> getLeftHand(){
        return leftHand;
    }
    public Map<String, Double> getRightHand(){
        return rightHand;
    }

    @Override
    public boolean equals(Object other){
        if (other.getClass() == Equation.class){
            Equation otherEquation = (Equation) other;
            return otherEquation.getLeftHand() == leftHand && otherEquation.getRightHand() == rightHand;
        }
        return false;
    }
}
