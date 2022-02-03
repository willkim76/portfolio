package calculator;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import data.Equation;
import data.Expression;

public class CalculatorHandler implements RequestHandler<Expression, Equation> {

    @Override
    public Equation handleRequest(Expression expression, Context context) {
        Calculator calculator = new Calculator();

        return null;
    }
}
