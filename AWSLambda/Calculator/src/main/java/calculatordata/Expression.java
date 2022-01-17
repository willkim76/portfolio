package calculatordata;

import types.Operator;
import types.Value;

import java.util.Objects;

/**
 * The String representation of two Value operands and an Operator.
 *
 */
public class Expression {
    private String operator;
    private String oprnd_1;
    private String oprnd_2;

    public Expression() {}

    public Expression(String operator, String oprnd_1, String oprnd_2) {
        this.operator = operator;
        this.oprnd_1 = oprnd_1;
        this.oprnd_2 = oprnd_2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setOprnd_1(String oprnd_1) {
        this.oprnd_1 = oprnd_1;
    }

    public void setOprnd_2(String oprnd_2) {
        this.oprnd_2 = oprnd_2;
    }

    public String getOperator() {
        return operator;
    }

    public String getOperand_1() {
        return oprnd_1;
    }

    public String getOperand_2() {
        return oprnd_2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !this.getClass().equals(o.getClass())) { return false; }
        if (this == o) { return true; }
        Expression that = (Expression) o;
        return this.oprnd_1.equals(that.oprnd_1) &&
                this.oprnd_2.equals(that.oprnd_2) &&
                this.operator.equals(that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperator(), getOperand_1(), getOperand_2());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", Value.toValue(oprnd_1), Operator.valueOf(operator), Value.toValue(oprnd_2));
    }
}
