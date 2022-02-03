package data;

import org.junit.jupiter.api.Test;
import types.Vector;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class VectorTest {

    @Test
    void twoArgConstructor_withTwoBigDecimals_createsNewVector() {
        // GIVEN
        BigDecimal component_x = BigDecimal.valueOf(13);
        BigDecimal component_y = BigDecimal.valueOf(37);

        // WHEN
        // THEN
        Vector vector = new Vector(component_x, component_y);
    }

    @Test
    void threeArgConstructor_withThreeBigDecimals_createsNewVector() {
        // GIVEN
        BigDecimal component_x = BigDecimal.valueOf(13);
        BigDecimal component_y = BigDecimal.valueOf(37);
        BigDecimal component_z = BigDecimal.valueOf(42);

        // WHEN
        // THEN
        Vector vector = new Vector(component_x, component_y, component_z);
    }

    @Test
    void threeArgConstructor_withNullAndBigDecimal_throwsIllegalValueException() {
        // GIVEN
        BigDecimal component_x = BigDecimal.valueOf(13);
        BigDecimal component_y = BigDecimal.valueOf(37);
        BigDecimal component_z = null;

        // WHEN
        // THEN
        Vector vector = new Vector(component_x, component_y, component_z);
    }

    @Test
    void vectorAdd_withTwo2DVectors_aVectorIsReturned() {
        // GIVEN
        Vector vector_1 = new Vector(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        Vector vector_2 = new Vector(BigDecimal.valueOf(8), BigDecimal.valueOf(7));


        // WHEN
        Vector vector = vector_1.add(vector_2);

        // THEN
        assertEquals(vector_1.numOfDimensions(), vector.numOfDimensions());
        assertEquals(BigDecimal.TEN, vector.getComponents().get(0));
        assertEquals(BigDecimal.TEN, vector.getComponents().get(1));
    }

    @Test
    void vectorAdd_withTwo3DVectors_aVectorIsReturned() {
        // GIVEN
        Vector vector_1 =
                new Vector(BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(9));
        Vector vector_2 =
                new Vector(BigDecimal.valueOf(8), BigDecimal.valueOf(7), BigDecimal.ONE);


        // WHEN
        Vector vector = vector_1.add(vector_2);

        // THEN
        assertEquals(vector_1.numOfDimensions(), vector.numOfDimensions());
        assertEquals(BigDecimal.TEN, vector.getComponents().get(0));
        assertEquals(BigDecimal.TEN, vector.getComponents().get(1));
        assertEquals(BigDecimal.TEN, vector.getComponents().get(2));
    }
}
