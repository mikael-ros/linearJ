package com.embracket.linearJ.line;

import com.embracket.linearJ.equation.Equation;
import com.embracket.linearJ.equation.EquationSystem;
import com.embracket.linearJ.point.Point;
import com.embracket.linearJ.vector.Vector;

public class Line3D extends Line{
    public Line3D(Point point, Vector direction) {
        super(point, direction);
    }

    public Equation getNormalForm(){
        return new Equation(normal.x * ('x' - point.x) + normal.y * ('y' - point.y) + normal.z * ('z' - point.z) = 0);
    }
    public EquationSystem getParameterForm(){
        return new EquationSystem(new Equation[]{
                new Equation('x' = point.x + direction.x),
                new Equation('y' = point.y + direction.y),
                new Equation('z' = point.z + direction.z)
        });
    }
}
