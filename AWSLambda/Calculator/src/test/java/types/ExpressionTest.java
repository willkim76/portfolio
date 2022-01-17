package types;

import calculatordata.Equation;
import calculatordata.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class ExpressionTest {
    private Value scalar_1;
    private Value scalar_2;
    private Value vector_1;
    private Value vector_2;
    private Value complex_1;
    private Value complex_2;

    @BeforeEach
    void setup() {
        scalar_1 = Value.builder().withComponent1(BigDecimal.valueOf(7)).build();
        scalar_2 = Value.builder().withComponent1(BigDecimal.valueOf(-7)).build();
        vector_1 = Value.builder().withComponent1(BigDecimal.valueOf(3))
                .withComponent2(BigDecimal.valueOf(5)).build();
        vector_2 = Value.builder().withComponent1(BigDecimal.valueOf(-15))
                .withComponent2(BigDecimal.valueOf(3)).build();
        complex_1 = Value.builder().withComponent1(BigDecimal.valueOf(6))
                .withComponent2(BigDecimal.valueOf(-3))
                .withComplex(true).build();
        complex_2 = Value.builder().withComponent1(BigDecimal.valueOf(-2))
                .withComponent2(BigDecimal.valueOf(-5))
                .withComplex(true).build();
    }

    @Test
    void constructor_addWithTwoScalars_createsExpression() {
        // GIVEN Two Scalar operands to add
        Expression actual = new Expression("ADD",
                scalar_1.getComponent_1().toString(),
                scalar_2.getComponent_1().toString());

        // WHEN
        // THEN
        assertNotNull(actual);
        assertEquals(Operator.ADD, actual.getOperator());
        assertEquals(scalar_1, actual.getOperand_1());
        assertEquals(scalar_2, actual.getOperand_2());
    }

}
