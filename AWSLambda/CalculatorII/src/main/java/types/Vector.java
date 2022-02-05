package types;

import exceptions.IllegalOperandException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vector implements Operand {
    private final List<BigDecimal> components;

    public Vector(BigDecimal component_x, BigDecimal component_y) {
        this(new BigDecimal[] {component_x, component_y});
    }

    public Vector(BigDecimal component_x, BigDecimal component_y, BigDecimal component_z) {
        this(new BigDecimal[] {component_x, component_y, component_z});
    }

    public Vector(BigDecimal... components) {
        this.components = Arrays.asList(Arrays.copyOf(components, components.length));
        if (this.components.contains(null)) {
            throw new IllegalOperandException("Null component within Vector.");
        } else if (this.components.size() < 2) {
            throw new IllegalOperandException("Number of Dimensions less than Two.");
        }
    }

    public List<BigDecimal> getComponents() {
        return new ArrayList<>(components);
    }

    public int numOfDimensions() {
        return components.size();
    }

    @Override
    public Vector add(Operand operand) {
        if (operand == null) {
            throw new IllegalArgumentException("Cannot add a Vector with null.");
        }

        if (this.getClass() != operand.getClass()) {
            throw new IllegalArgumentException(
                    String.format("Cannot add a Vector with %s.",
                            operand.getClass()
                    )
            );
        }

        Vector that = (Vector) operand;
        if (this.components.size() != that.components.size()) {
            throw new IllegalArgumentException(
                    String.format("Cannot add a %sD Vector with a %sD Vector.",
                            this.components.size(),
                            that.components.size()
                    )
            );
        }

        BigDecimal[] sum = new BigDecimal[this.components.size()];
        for (int comp = 0; comp < sum.length; comp++) {
            sum[comp] = this.components.get(comp).add(that.components.get(comp));
        }
        return new Vector(sum);
    }

    @Override
    public Vector subtract(Operand operand) {
        return null;
    }

    @Override
    public Vector divide(Operand operand) {
        return null;
    }

    /**
     * Performs a Vector multiplication or the cross product between two Vectors
     * @param operand
     * @return
     */
    @Override
    public Vector multiply(Operand operand) {
        return this.cross(operand);
    }

    /**
     * Performs a Scalar multiplication or the dot product between two Vectors or a
     * @param operand
     * @return
     */
    public Vector dot(Operand operand) {
        return null;
    }

    public Vector cross(Operand operand) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) { return false; }
        if (this == o) { return true; }

        Vector that = (Vector) o;
        if (this.getComponents().equals(that.getComponents())) { return true; }

        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}
