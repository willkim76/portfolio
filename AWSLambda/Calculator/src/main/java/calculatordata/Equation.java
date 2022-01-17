package calculatordata;

import types.Value;
import types.Operator;

/**
 * Equation
 */
public class Equation {
    private Expression expression;
    private Value result;

    public Equation(Expression expression) {
        this.expression = expression;
        this.evaluate();
    }

    private void evaluate() {
        result = Operator.evaluate(
                Operator.valueOf(expression.getOperator()),
                Expression.toValue(expression.getOperand_1()),
                Expression.toValue(expression.getOperand_2())
        );
    }

    public Expression getExpression() {
        return expression;
    }

    public Value getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !this.getClass().equals(o.getClass())) { return false; }
        if (this == o) { return true; }
        Equation that = (Equation) o;

        return this.expression.equals(that.expression) &&
                this.result.equals(that.result);
    }

    @Override
    public String toString() {
        return String.format("%s = %s", this.result, this.expression);
    }
}
