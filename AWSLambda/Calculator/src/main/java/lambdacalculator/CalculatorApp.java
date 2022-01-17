package lambdacalculator;

import calculatordata.Expression;
import calculatordata.Equation;

/**
 *
 */
public class CalculatorApp {

    public Equation evaluate(Expression expression) {
        System.out.println("Evaluating the Expression: " + expression);
        return new Equation(expression);
    }
}
