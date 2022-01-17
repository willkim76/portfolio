package lambdacalculator;

import calculatordata.Expression;
import calculatordata.Equation;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CalculatorHandler implements RequestHandler<Expression, Equation> {

    @Override
    public Equation handleRequest(Expression theExpression, Context context) {

        CalculatorApp calculatorApp = new CalculatorApp();

        System.out.println("Expression Received: " + theExpression);

        Equation theEquation = calculatorApp.calculate(theExpression);

        System.out.println("The result of the Expression is: " + theEquation.getResult());
        System.out.println("The Equation is: " + theEquation);

        return theEquation;
    }
}
