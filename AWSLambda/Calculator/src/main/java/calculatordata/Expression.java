package calculatordata;

import types.Operand;
import types.Operator;

public class Expression {
    private Operator operator;
    private Operand operand_1;
    private Operand operand_2;

    public Expression(Operator operator, Operand operand_1, Operand operand_2) {
        this.operator = operator;
        this.operand_1 = operand_1;
        this.operand_2 = operand_2;
    }

    public Operator getOperator() {
        return operator;
    }

    public Operand getOperand_1() {
        return operand_1;
    }

    public Operand getOperand_2() {
        return operand_2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !this.getClass().equals(o.getClass())) { return false; }
        if (this == o) { return true; }
        Expression that = (Expression) o;
        return this.operand_1.equals(that.operand_1) &&
                this.operand_2.equals(that.operand_2) &&
                this.operator.equals(that.operator);
    }

    @Override
    public String toString() {
        return String.format("Expression:");
    }
}
