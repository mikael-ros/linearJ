package com.embracket.linearJ.line;

import com.embracket.linearJ.equation.Equation;
import com.embracket.linearJ.equation.EquationSystem;
import com.embracket.linearJ.point.Point;
import com.embracket.linearJ.vector.Vector;

import static com.embracket.linearJ.equation.EquationParser.parseEquation;
import static com.embracket.linearJ.vector.VectorOperations.getUnitVector;

public class Line3D implements Line{
    private Point point;
    private Vector direction;
    private Vector normal;

    public Line3D(Point point, Vector direction){
        this.point = point;
        this.direction = getUnitVector(direction);
    }

    public Equation getNormalForm(){
        return parseEquation(normal.getVector()[0] + "(x - " + point.getCoordinates()[0] + ") + "
                            + normal.getVector()[1] + "(y - " + point.getCoordinates()[1] + ") + "
                            + normal.getVector()[2] + "(z - " + point.getCoordinates()[2] + ") = 0");
    }
    public EquationSystem getParameterForm(){
        return new EquationSystem(new Equation[]{
                parseEquation("x = " + point.getCoordinates()[0] + " + " + direction.getVector()[0] + "t"),
                parseEquation("y = " + point.getCoordinates()[1] + " + " + direction.getVector()[1] + "t"),
                parseEquation("z = " + point.getCoordinates()[2] + " + " + direction.getVector()[2] + "t"),
        });
    }
}
