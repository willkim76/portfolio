package types;

import java.math.BigDecimal;

/**
 * Defines the attributes of an Value.
 */
public class Value {
    private BigDecimal component_1;
    private BigDecimal component_2;
    private boolean isComplex;

    private Value(Builder builder) {
        this.component_1 = builder.value_1;
        this.component_2 = builder.value_2;
        this.isComplex = builder.isComplex;
    }

    public BigDecimal getComponent_1() {
        return component_1;
    }

    public BigDecimal getComponent_2() {
        return component_2;
    }

    public boolean isComplex() {
        return isComplex;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(this.getClass().equals(o.getClass()))) {
            return false;
        }
        if (this == o) {
            return true;
        }

        Value that = (Value) o;
        return this.component_1.equals(that.component_1) &&
                this.component_2.equals(that.component_2) &&
                this.isComplex == that.isComplex;
    }

    @Override
    public String toString() {
        if (component_2 == null) {
            return String.format("{Scalar: %s}", component_1);
        }
        if (!isComplex) {
            return String.format("{Vector: [%s, %s]}", component_1, component_2);
        }
        return String.format("{Complex: [%s, %sj]}", component_1, component_2);
    }

    public static class Builder {
        private BigDecimal value_1;
        private BigDecimal value_2;
        private boolean isComplex;

        public Builder withValue1(BigDecimal withValue_1) {
            this.value_1 = withValue_1;
            return this;
        }

        public Builder withValue2(BigDecimal withValue_2) {
            this.value_2 = withValue_2;
            return this;
        }

        public Builder withComplex(boolean withIsComplex) {
            this.isComplex = withIsComplex;
            return this;
        }

        public Value build() {
            if (value_1 == null || value_2 == null && isComplex) {
                throw new IllegalStateException();
            }
            return new Value(this);
        }
    }
}
