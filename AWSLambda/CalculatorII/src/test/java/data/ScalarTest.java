package data;

import exceptions.IllegalOperandException;
import org.junit.jupiter.api.Test;
import types.ComplexScalar;
import types.Scalar;
import types.Vector;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ScalarTest {

    @Test
    void constructor_withBigDecimals_createsNewScalar() {
        // GIVEN
        BigDecimal component_real = BigDecimal.valueOf(13);

        // WHEN
        // THEN
        Scalar scalar = null;
        try {
            scalar = new Scalar(component_real);
        } catch (Exception e) {
            fail("Unexpectedly threw " + e.getClass().getSimpleName());
        }
        assertNotNull(scalar, "Unexpectedly did not instantiate a Vector");
    }

    @Test
    void constructor_withNull_throwsIllegalOperandException() {
        // GIVEN
        BigDecimal component_real = null;

        // WHEN
        // THEN
        Scalar scalar = null;
        try {
            scalar = new Scalar(component_real);
        } catch (Exception e) {
            assertEquals(IllegalOperandException.class,
                    e.getClass(),
                    "Unexpectedly threw " + e.getClass().getSimpleName());
        }
        assertNull(scalar, "Unexpectedly instantiated a Scalar");
    }

    @Test
    void add_withTwoScalars_aScalarIsReturned() {
        // GIVEN
        BigDecimal component_1 = BigDecimal.valueOf(3);
        BigDecimal component_2 = BigDecimal.valueOf(2);

        Scalar scalar1 = new Scalar(component_1);
        Scalar scalar2 = new Scalar(component_2);

        // WHEN
        Scalar sum = scalar1.add(scalar2);

        // THEN
        assertEquals(component_1.add(component_2), sum.getComponent_real());
    }

    @Test
    void add_withScalarAndComplexScalar_aComplexScalarIsReturned() {
        // GIVEN
        BigDecimal component_1 = BigDecimal.valueOf(3);
        BigDecimal component_2 = BigDecimal.valueOf(2);

        Scalar scalar1 = new Scalar(component_1);
        Scalar scalar2 = new ComplexScalar(component_1, component_2);

        // WHEN
        ComplexScalar sum = (ComplexScalar) scalar1.add(scalar2);

        // THEN
        assertEquals(component_1.add(component_1), sum.getComponent_real());
        assertEquals(component_2, sum.getComponent_imag());
    }


    @Test
    void add_withScalarAndVector_throwsUnsupportedOperationException() {
        // GIVEN
        BigDecimal component_1 = BigDecimal.valueOf(3);
        BigDecimal component_2 = BigDecimal.valueOf(2);

        Scalar scalar = new Scalar(component_1);
        Vector vector = new Vector(component_1, component_2);

        // WHEN
        // THEN
        assertThrows(UnsupportedOperationException.class, () -> scalar.add(vector));
    }

    @Test
    void subtract_withTwoScalars_aScalarIsReturned() {
        // GIVEN
        BigDecimal component_1 = BigDecimal.valueOf(3);
        BigDecimal component_2 = BigDecimal.valueOf(5);

        Scalar scalar1 = new Scalar(component_1);
        Scalar scalar2 = new Scalar(component_2);

        // WHEN
        Scalar difference = scalar1.subtract(scalar2);

        // THEN
        assertEquals(component_1.subtract(component_2), difference.getComponent_real());
    }

    @Test
    void subtract_withScalarAndComplexScalar_aComplexScalarIsReturned() {
        // GIVEN
        BigDecimal component_1 = BigDecimal.valueOf(3);
        BigDecimal component_2 = BigDecimal.valueOf(7);

        Scalar scalar = new Scalar(component_1);
        ComplexScalar complexScalar = new ComplexScalar(component_1, component_2);

        // WHEN
        ComplexScalar difference = (ComplexScalar) scalar.subtract(complexScalar);

        // THEN
        assertEquals(component_1.subtract(component_1), difference.getComponent_real());
        assertEquals(component_2, difference.getComponent_imag());
    }

    @Test
    void subtract_withScalarAndVector_throwsUnsupportedOperationException() {
        // GIVEN
        BigDecimal component_1 = BigDecimal.valueOf(3);
        BigDecimal component_2 = BigDecimal.valueOf(2);

        Scalar scalar = new Scalar(component_1);
        Vector vector = new Vector(component_1, component_2);

        // WHEN
        // THEN
        assertThrows(UnsupportedOperationException.class, () -> scalar.subtract(vector));
    }

    @Test
    void multiply_withScalars_aScalarIsReturned() {
        // GIVEN
        BigDecimal component_1 = BigDecimal.valueOf(3);
        BigDecimal component_2 = BigDecimal.valueOf(5);

        Scalar scalar1 = new Scalar(component_1);
        Scalar scalar2 = new Scalar(component_2);

        // WHEN
        Scalar product = (Scalar) scalar1.multiply(scalar2);

        // THEN
        assertEquals(component_1.multiply(component_2), product.getComponent_real());
    }

    @Test
    void multiply_withScalarAndComplexScalar_aScalarIsReturned() {
        // GIVEN
        BigDecimal component_1 = BigDecimal.valueOf(3);
        BigDecimal component_2 = BigDecimal.valueOf(5);

        Scalar scalar1 = new Scalar(component_1);
        ComplexScalar scalar2 = new ComplexScalar(component_1, component_2);

        // WHEN
        ComplexScalar product = (ComplexScalar) scalar1.multiply(scalar2);

        // THEN
        assertEquals(component_1.multiply(component_1), product.getComponent_real());
        assertEquals(component_1.multiply(component_2), product.getComponent_imag());
    }
}
