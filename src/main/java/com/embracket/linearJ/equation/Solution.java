package com.embracket.linearJ.equation;

import java.util.ArrayList;
import java.util.List;

/**
 * The solution for an equation, as a list of variables (variable, value)
 */
public class Solution {
    private List<Variable> solutions;

    public Solution(){
        this.solutions = new ArrayList<>();
    }

    public void addSolution(Variable variable){
        solutions.add(variable);
    }

    public List<Variable> getSolutions(){
        return this.solutions;
    }

    @Override
    public String toString() {
        String result = "";
        for (Variable solution : solutions){
            result += solution + "\n";
        }
        return result;
    }
}
