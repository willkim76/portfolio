package types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ValueTest {

    @BeforeEach
    void setup() {}

    @Test
    void withValue_usingSingleBigDecimalValue_createsAValue() {
        // GIVEN
        BigDecimal expected = BigDecimal.valueOf(5);

        // WHEN
        Value actual = Value.builder().withComponent1(expected).build();

        // THEN
        assertEquals(expected, actual.getComponent_1());
        assertNull(actual.getComponent_2());
        assertFalse(actual.isComplex());
    }

    @Test
    void withValue_usingTwoBigDecimalValues_createsAValue() {
        // GIVEN
        BigDecimal expected_1 = BigDecimal.valueOf(4.20);
        BigDecimal expected_2 = BigDecimal.valueOf(-69);

        // WHEN
        Value actual = Value.builder()
                .withComponent1(expected_1)
                .withComponent2(expected_2)
                .build();

        // THEN
        assertEquals(expected_1, actual.getComponent_1());
        assertEquals(expected_2, actual.getComponent_2());
        assertFalse(actual.isComplex());
    }

    @Test
    void withValueAndIsComplex_usingTwoBigDecimalValues_createsAValue() {
        // GIVEN
        BigDecimal expected_1 = BigDecimal.valueOf(4.20);
        BigDecimal expected_2 = BigDecimal.valueOf(-69);

        // WHEN
        Value actual = Value.builder()
                .withComponent1(expected_1)
                .withComponent2(expected_2)
                .withComplex(true)
                .build();

        // THEN
        assertEquals(expected_1, actual.getComponent_1());
        assertEquals(expected_2, actual.getComponent_2());
        assertTrue(actual.isComplex());
    }

    @Test
    void build_withNoComponents_throwsIllegalStateException() {
        // GIVEN Attempting to build a Value without any components
        Value.Builder actual = Value.builder().withComplex(true);

        // WHEN
        // THEN Throws IllegalStateException
        assertThrows(IllegalStateException.class, actual::build);
    }

    @Test
    void build_withOnlySecondComponent_throwsIllegalStateException() {
        // GIVEN Attempting to build a Value with only a second components
        Value.Builder actual = Value.builder()
                .withComponent2(BigDecimal.TEN)
                .withComplex(true);

        // WHEN
        // THEN Throws IllegalStateException
        assertThrows(IllegalStateException.class, actual::build);
    }

    @Test
    void build_withOnlyFirstComponentsAndWithComplex_throwsIllegalStateException() {
        // GIVEN Attempting to build a Value with first component and with complex
        Value.Builder actual = Value.builder()
                .withComponent1(BigDecimal.TEN)
                .withComplex(true);

        // WHEN
        // THEN Throws IllegalStateException
        assertThrows(IllegalStateException.class, actual::build);
    }
}
