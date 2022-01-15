package types;

import java.math.BigDecimal;

/**
 * Defines the attributes of an Operand.
 */
public class Operand {
    private BigDecimal value_1;
    private BigDecimal value_2;
    private boolean isComplex;

    private Operand(Builder builder) {
        this.value_1 = builder.value_1;
        this.value_2 = builder.value_2;
        this.isComplex = builder.isComplex;
    }

    public BigDecimal getValue_1() {
        return value_1;
    }

    public BigDecimal getValue_2() {
        return value_2;
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

        Operand that = (Operand) o;
        return this.value_1.equals(that.value_1) &&
                this.value_2.equals(that.value_2) &&
                this.isComplex == that.isComplex;
    }

    @Override
    public String toString() {
        if (value_2 == null) {
            return String.format("{Scalar: %s}", value_1);
        }
        if (!isComplex) {
            return String.format("{Vector: [%s, %s]}", value_1, value_2);
        }
        return String.format("{Complex: [%s, %sj]}", value_1, value_2);
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

        public Operand build() {
            if (value_1 == null || value_2 == null && isComplex) {
                throw new IllegalStateException();
            }
            return new Operand(this);
        }
    }
}
