package com.embracket.linearJ.equation;

public class EquationSystem {
    private Equation[] equations;
    public EquationSystem (Equation[] equations){
        this.equations = equations;
    }

    public Equation[] getEquations(){
        return equations;
    }

    @Override
    public boolean equals(Object other){
        if (other.getClass() == EquationSystem.class){
            EquationSystem otherEquationSystem = (EquationSystem) other;
            if (otherEquationSystem.getEquations().length == equations.length){
                for (int i = 0; i < equations.length; i++){
                    if (equations[i] != otherEquationSystem.getEquations()[i]){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
