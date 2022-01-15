package calculatordata;

import types.Value;
import types.Operator;

public class Expression {
    private Operator operator;
    private Value value_1;
    private Value value_2;

    public Expression(Operator operator, Value value_1, Value value_2) {
        this.operator = operator;
        this.value_1 = value_1;
        this.value_2 = value_2;
    }

    public Operator getOperator() {
        return operator;
    }

    public Value getOperand_1() {
        return value_1;
    }

    public Value getOperand_2() {
        return value_2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !this.getClass().equals(o.getClass())) { return false; }
        if (this == o) { return true; }
        Expression that = (Expression) o;
        return this.value_1.equals(that.value_1) &&
                this.value_2.equals(that.value_2) &&
                this.operator.equals(that.operator);
    }

    @Override
    public String toString() {
        return String.format("Expression:");
    }
}
