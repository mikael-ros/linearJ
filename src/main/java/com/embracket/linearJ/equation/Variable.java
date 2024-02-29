package com.embracket.linearJ.equation;

/**
 * A key value pair of a variable name and its value
 */
public class Variable {
    private Character variableName;
    private Object value;

    public Variable(Character variableName, Object value){
        this.variableName = variableName;
        this.value = value;
    }

    public Object getValue(){
        return value;
    }

    public Character getVariableName(){
        return variableName;
    }

    public void setVariableName(Character variableName){
        this.variableName = variableName;
    }

    public void setValue(Double value){
        this.value = value;
    }

    @Override
    public String toString() {
        return variableName + " = " + value;
    }

    /**
     * Two variables are considered equal when the values they hold are the same
     * @param obj The object compared to
     * @return If the object is a variable, and the value is equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Variable.class) {
            Variable other = (Variable) obj;
            return getValue() == other.getValue();
        } else {
            return false;
        }
    }
}
