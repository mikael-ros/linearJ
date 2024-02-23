package com.embracket.linearJ.vector;

public class Vector {
    private int[] coordinates;
    public Vector(int[] coordinates){
        this.coordinates = coordinates;
    }

    public int getDimension(){
        return coordinates.length;
    }

    public int[] getVector(){
        return coordinates;
    }

    public void add(Vector vector){
        //coordinates = coordinates + vector.getVector();
    }
}

