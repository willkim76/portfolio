package types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class OperatorTest {
    private Value scalar_1;
    private Value scalar_2;
    private Value vector_1;
    private Value vector_2;
    private Value complex_1;
    private Value complex_2;

    @BeforeEach
    void setup() {
        scalar_1 = Value.builder().withComponent1(BigDecimal.valueOf(3)).build();
        scalar_2 = Value.builder().withComponent1(BigDecimal.valueOf(6)).build();
        vector_1 = Value.builder().withComponent1(BigDecimal.valueOf(3))
                .withComponent2(BigDecimal.valueOf(6))
                .build();
        vector_2 = Value.builder().withComponent1(BigDecimal.valueOf(2))
                .withComponent2(BigDecimal.valueOf(4))
                .build();
        complex_1 = Value.builder().withComponent1(BigDecimal.valueOf(3))
                .withComponent2(BigDecimal.valueOf(6))
                .withComplex(true)
                .build();
        complex_2 = Value.builder().withComponent1(BigDecimal.valueOf(2))
                .withComponent2(BigDecimal.valueOf(4))
                .withComplex(true)
                .build();
    }

    @Test
    void evaluate_addUsingScalarAndVector_throwsIllegalArgumentException() {
        // GIVEN
        // WHEN
        // THEN Attempting to add a Scalar to a Vector should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () ->
                { Operator.evaluate(Operator.ADD, scalar_1, vector_1); }
        );
    }

    @Test
    void evaluate_addUsingScalarAndComplex_throwsIllegalArgumentException() {
        // GIVEN
        // WHEN
        // THEN Attempting to add a Scalar to a Vector should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () ->
                { Operator.evaluate(Operator.ADD, scalar_1, complex_1); }
        );
    }

    @Test
    void evaluate_addUsingVectorAndComplex_throwsIllegalArgumentException() {
        // GIVEN
        // WHEN
        // THEN Attempting to add a Vector to a Complex should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () ->
                { Operator.evaluate(Operator.ADD, vector_1, complex_1); }
        );
    }


    @Test
    void evaluate_addUsingTwoScalarValues_createsANewScalarValue() {
        // GIVEN
        Value expectedValue = Value.builder().withComponent1(BigDecimal.valueOf(9)).build();
        Operator operation = Operator.ADD;

        // WHEN
        Value actualValue = Operator.evaluate(operation, scalar_1, scalar_2);

        // THEN
        assertEquals(expectedValue, actualValue,
                String.format(
                        "Expected a %s from %s operation but was unexpectedly: %s",
                        expectedValue,
                        operation,
                        actualValue
                )
        );
    }

    @Test
    void evaluate_addUsingTwoVectorValues_createsANewVectorValue() {
        // GIVEN
        Value expectedValue = Value.builder().withComponent1(BigDecimal.valueOf(5))
                .withComponent2(BigDecimal.TEN)
                .build();
        Operator operation = Operator.ADD;

        // WHEN
        Value actualValue = Operator.evaluate(operation, vector_1, vector_2);

        // THEN
        assertEquals(expectedValue, actualValue,
                String.format(
                        "Expected a %s from %s operation but was unexpectedly: %s",
                        expectedValue,
                        operation,
                        actualValue
                )
        );
    }

    @Test
    void evaluate_addUsingTwoComplexValues_createsANewVectorValue() {
        // GIVEN
        Value expectedValue = Value.builder().withComponent1(BigDecimal.valueOf(5))
                .withComponent2(BigDecimal.TEN)
                .withComplex(true)
                .build();
        Operator operation = Operator.ADD;

        // WHEN
        Value actualValue = Operator.evaluate(operation, complex_1, complex_2);

        // THEN
        assertEquals(expectedValue, actualValue,
                String.format(
                        "Expected a %s from %s operation but was unexpectedly: %s",
                        expectedValue,
                        operation,
                        actualValue
                )
        );
    }

    @Test
    void evaluate_subtractUsingTwoScalarValues_createsANewScalarValue() {
        // GIVEN
        Value expectedValue = Value.builder().withComponent1(BigDecimal.valueOf(-3)).build();
        Operator operation = Operator.SUBTRACT;

        // WHEN
        Value actualValue = Operator.evaluate(operation, scalar_1, scalar_2);

        // THEN
        assertEquals(expectedValue, actualValue,
                String.format(
                        "Expected a %s from %s operation but was unexpectedly: %s",
                        expectedValue,
                        operation,
                        actualValue
                )
        );
    }

    @Test
    void evaluate_subtractUsingTwoVectorValues_createsANewVectorValue() {
        // GIVEN
        Value expectedValue = Value.builder().withComponent1(BigDecimal.ONE)
                .withComponent2(BigDecimal.valueOf(2))
                .build();
        Operator operation = Operator.SUBTRACT;

        // WHEN
        Value actualValue = Operator.evaluate(operation, vector_1, vector_2);

        // THEN
        assertEquals(expectedValue, actualValue,
                String.format(
                        "Expected a %s from %s operation but was unexpectedly: %s",
                        expectedValue,
                        operation,
                        actualValue
                )
        );
    }

    @Test
    void evaluate_subtractUsingTwoComplexValues_createsANewVectorValue() {
        // GIVEN
        Value expectedValue = Value.builder().withComponent1(BigDecimal.ONE)
                .withComponent2(BigDecimal.valueOf(2))
                .withComplex(true)
                .build();
        Operator operation = Operator.SUBTRACT;

        // WHEN
        Value actualValue = Operator.evaluate(operation, complex_1, complex_2);

        // THEN
        assertEquals(expectedValue, actualValue,
                String.format(
                        "Expected a %s from %s operation but was unexpectedly: %s",
                        expectedValue,
                        operation,
                        actualValue
                )
        );
    }
}
