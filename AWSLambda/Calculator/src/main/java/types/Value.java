package types;

import java.math.BigDecimal;

/**
 * Defines the attributes of a Value. A Value can be a Scalar, 2D Vector, or a Complex
 * Number. The number of arguments determines the stated types listed previously.
 *
 *
 */
public class Value {
    private BigDecimal component_1;
    private BigDecimal component_2;
    private boolean isScalar;
    private boolean isComplex;

    private Value(Builder builder) {
        this.component_1 = builder.component_1;
        this.component_2 = builder.component_2;
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

    public boolean isScalar() {
        return component_2 == null;
    }

    public static Value toValue(String input) {
        String[] inputToProcess = input.split(" ");

        if (inputToProcess.length == 1) {
            return Value.builder().withComponent1(new BigDecimal(inputToProcess[0])).build();
        } else if (inputToProcess.length == 2) {
            String comp1 = inputToProcess[0].replace("[", "").replace(",", "");
            String comp2 = inputToProcess[1].replace("]", "").replace(",", "");
            return Value.builder()
                    .withComponent1(new BigDecimal(comp1))
                    .withComponent2(new BigDecimal(comp2))
                    .build();
        } else if (inputToProcess.length == 3) {
            String comp1 = inputToProcess[0];
            String comp2 =
                    inputToProcess[1].concat(inputToProcess[2].substring(0, inputToProcess[2].indexOf("j")));
            return Value.builder()
                    .withComponent1(new BigDecimal(comp1))
                    .withComponent2(new BigDecimal(comp2))
                    .withComplex(true)
                    .build();
        }
        return null;
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
                this.component2IsEqual(that) &&
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

    private boolean component2IsEqual(Value that) {
        if (this.component_2 == null && that.component_2 == null) { return true; }
        if (this.component_2 == null || that.component_2 == null) { return false; }
        return this.component_2.equals(that.component_2);
    }

    public static class Builder {
        private BigDecimal component_1;
        private BigDecimal component_2;
        private boolean isComplex;

        public Builder withComponent1(BigDecimal withComponent_1) {
            this.component_1 = withComponent_1;
            return this;
        }

        public Builder withComponent2(BigDecimal withComponent_2) {
            this.component_2 = withComponent_2;
            return this;
        }

        public Builder withComplex(boolean withIsComplex) {
            this.isComplex = withIsComplex;
            return this;
        }

        public Value build() {
            if (component_1 == null || component_2 == null && isComplex) {
                throw new IllegalStateException();
            }
            return new Value(this);
        }
    }
}
