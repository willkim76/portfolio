package types;

import exceptions.IllegalValueException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vector implements Value {
    private List<BigDecimal> components;

    public Vector(BigDecimal component_x, BigDecimal component_y) {
        this(new BigDecimal[] {component_x, component_y});
    }

    public Vector(BigDecimal component_x, BigDecimal component_y, BigDecimal component_z) {
        this(new BigDecimal[] {component_x, component_y, component_z});
    }

    public Vector(BigDecimal... components) {
        this.components = Arrays.asList(Arrays.copyOf(components, components.length));
        if (this.components.contains(null)) {
            throw new IllegalValueException("Null component within Vector.");
        }
    }

    public List<BigDecimal> getComponents() {
        return new ArrayList<>(components);
    }

    public int numOfDimensions() {
        return components.size();
    }

    @Override
    public Vector add(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot add a Vector with null.");
        }

        if (this.getClass() != value.getClass()) {
            throw new IllegalArgumentException(
                    String.format("Cannot add a Vector with %s.",
                            value.getClass()
                    )
            );
        }

        Vector that = (Vector) value;
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
    public Vector subtract(Value value) {
        return null;
    }

    @Override
    public Vector divide(Value value) {
        return null;
    }

    @Override
    public Vector multiply(Value value) {
        return this.dot(value);
    }

    @Override
    public Vector dot(Value value) {
        return null;
    }
}
