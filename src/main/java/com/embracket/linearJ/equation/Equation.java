package com.embracket.linearJ.equation;

import static com.embracket.linearJ.equation.EquationParser.parseEquation;

public class Equation {

    public Equation (){

    }

    public Equation (String readableEquation){
        return parseEquation(readableEquation);
    }
}
