package com.embracket.linearJ.line;

import com.embracket.linearJ.equation.Equation;
import com.embracket.linearJ.equation.EquationSystem;
import com.embracket.linearJ.point.Point;
import com.embracket.linearJ.vector.Vector;

public class Line2D extends Line{
    public Line2D(Point point, Vector direction) {
        super(point, direction);
    }
    public Equation getNormalForm() {
        return new Equation(normal.x * ('x' - point.x) + normal.y * ('y' - point.y) = 0);
    }
    public EquationSystem getParameterForm(){
        return new EquationSystem(new Equation[]{
                new Equation('x' = point.x + direction.x),
                new Equation('y' = point.y + direction.y)
        });
    }
}
