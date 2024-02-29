package com.embracket.linearJ.line;

import com.embracket.linearJ.vector.Vector;
import com.embracket.linearJ.point.Point;
import static com.embracket.linearJ.vector.VectorOperations.*;

public class Line {
    private Point point;
    private Vector direction;

    /**
     * Constructs a line using a point and a direction
     * @param point The origin point
     * @param direction The direction the line should go
     */
    public Line(Point point, Vector direction){
        this.point = point;
        this.direction = getUnitVector(direction);
    }
    /**
     * Construct using normal
     * @param normal the normal
     */
//    public Line(Vector normal){
//
//    }
}
