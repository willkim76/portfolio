package lambdacalculator;

import calculatordata.Expression;
import calculatordata.Equation;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CalculatorHandler implements RequestHandler<Expression, Equation> {

    @Override
    public Equation handleRequest(Expression theExpression, Context context) {

        CalculatorApp calculatorApp = new CalculatorApp();
        try {
            System.out.println("Expression Received: " + theExpression);
            Equation theEquation = calculatorApp.calculate(theExpression);

            System.out.println("The Result is: " + theEquation.getResult());
            System.out.println("The Equation is: " + theEquation);

            return theEquation;
        } catch (Exception e) {
            System.out.println("Not A Valid Expression: " + e.getMessage());
        }
        return null;
    }
}
