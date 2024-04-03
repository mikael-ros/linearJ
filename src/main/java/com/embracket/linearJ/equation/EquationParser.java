package com.embracket.linearJ.equation;

import java.util.*;

public class EquationParser {

    /**
     * Parses a readable equation like
     * @param readableEquation "2x + 4y + z = 2"
     * @return and returns an Equation object, internally holding maps with coefficients and such (see Equation class)
     */
    public static Equation parseEquation(String readableEquation){
        Map<String, Double> leftHand = new HashMap<>();
        Map<String, Double> rightHand = new HashMap<>();

        String[] hands = readableEquation.replaceAll("\\s","").split("=");
        String leftHandString = hands[0];
        String rightHandString = hands[1];

        populate(leftHand, leftHandString, splitCoefficients(leftHandString), splitTerms(leftHandString));
        populate(rightHand, rightHandString, splitCoefficients(rightHandString), splitTerms(rightHandString));

        return new Equation(leftHand, rightHand);
    }

    public static EquationSystem parseEquationSystem(String[] readableEquations){
        Equation[] equations = new Equation[readableEquations.length];
        for (int i = 0; i < readableEquations.length; i++){
            equations[i] = parseEquation(readableEquations[i]);
        }
        return new EquationSystem(equations);
    }

    private static void populate(Map<String, Double> mapToPopulate, String hand, String[] coefficients, String[] terms){
        for (int i = 0; i < coefficients.length; i++){
            mapToPopulate.put(terms[i], mapToPopulate.getOrDefault(terms[i], 0.0) + parse(coefficients[i]));
        }
        for (String term : terms){
            mapToPopulate.putIfAbsent(term, 1.0);
        }
    }

    /**
     * Handles fraction strings, like 3/2
     * @param fraction The fraction string
     * @return         The double representation
     */
    private static double parseFraction(String fraction){
        String[] split = fraction.split("/");
        return Double.parseDouble(split[0]) / Double.parseDouble(split[1]);
    }

    private static double parse(String number){
        return (number.contains("/")) ? parseFraction(number) : Double.parseDouble(number);
    }

    /**
     * Gathers all the coefficients
     * @param hand The side of the equation
     * @return A list of coefficients
     */
    private static String[] splitCoefficients(String hand){
        return hand.replaceAll("[a-z]|[A-Z]|(_\\w*)","").split("(\\+)|(?=-)");
    }

    /**
     * Gathers all the terms
     * @param hand The side of the equation
     * @return A list of terms
     */
    private static String[] splitTerms(String hand){
        var test = hand.replaceAll("(?<!_)\\d|(\\.)|(/)"," ");
        String[] terms = hand.replaceAll("(?<!_)\\d|(\\.)|(/)"," ").split("(\\+)|(-)");
        for (int i = 0; i < terms.length; i++){
            terms[i] = terms[i].replaceAll("\\s","");
        }
        return terms;
    }


}
