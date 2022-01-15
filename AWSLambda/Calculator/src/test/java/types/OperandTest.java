package types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class OperandTest {

    @BeforeEach
    void setup() {}

    @Test
    void withValue_usingSingleBigDecimalValue_createsAnOperand() {
        // GIVEN
        BigDecimal expected = BigDecimal.valueOf(5);

        // WHEN
        Operand actual = Operand.builder().withValue1(expected).build();

        // THEN
        assertEquals(expected, actual.getValue_1());
        assertNull(actual.getValue_2());
        assertFalse(actual.isComplex());
    }

    @Test
    void withValue_usingTwoBigDecimalValues_createsAnOperand() {
        // GIVEN
        BigDecimal expected_1 = BigDecimal.valueOf(4.20);
        BigDecimal expected_2 = BigDecimal.valueOf(-69);

        // WHEN
        Operand actual = Operand.builder()
                .withValue1(expected_1)
                .withValue2(expected_2)
                .build();

        // THEN
        assertEquals(expected_1, actual.getValue_1());
        assertEquals(expected_2, actual.getValue_2());
        assertFalse(actual.isComplex());
    }

    @Test
    void withValueAndIsComplex_usingTwoBigDecimalValues_createsAnOperand() {
        // GIVEN
        BigDecimal expected_1 = BigDecimal.valueOf(4.20);
        BigDecimal expected_2 = BigDecimal.valueOf(-69);

        // WHEN
        Operand actual = Operand.builder()
                .withValue1(expected_1)
                .withValue2(expected_2)
                .withComplex(true)
                .build();

        // THEN
        assertEquals(expected_1, actual.getValue_1());
        assertEquals(expected_2, actual.getValue_2());
        assertTrue(actual.isComplex());
    }

    @Test
    void isComplex_usingNoBigDecimalValues_createsDefaultOperand() {
        // GIVEN
        BigDecimal expected_1 = BigDecimal.ZERO;

        // WHEN
        Operand actual = Operand.builder()
                .withComplex(true)
                .build();

        // THEN
        assertEquals(expected_1, actual.getValue_1());
        assertEquals(expected_1, actual.getValue_2());
        assertTrue(actual.isComplex());
    }
}
