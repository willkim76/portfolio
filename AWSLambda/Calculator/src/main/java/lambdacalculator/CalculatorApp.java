package lambdacalculator;

import calculatordata.Expression;
import calculatordata.Equation;

/**
 *
 */
public class CalculatorApp {

    public Equation calculate(Expression expression) {
        System.out.println("Calculating the Expression: " + expression);
        return new Equation(expression);
    }
}
