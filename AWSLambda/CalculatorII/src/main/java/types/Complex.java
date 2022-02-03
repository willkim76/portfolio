package types;

import java.math.BigDecimal;

public class Complex implements Value {
    private BigDecimal component_real;
    private BigDecimal component_imag;

    public Complex(BigDecimal component_real, BigDecimal component_imag) {
        this.component_real = component_real;
        this.component_imag = component_imag;
    }


    @Override
    public Value add(Value value) {
        if (value == null || Complex.class != value.getClass()) {
            throw new IllegalArgumentException();
        }

        return new Complex(BigDecimal.ONE, BigDecimal.TEN);
    }

    @Override
    public Value subtract(Value value) {
        return null;
    }

    @Override
    public Value divide(Value value) {
        return null;
    }

    @Override
    public Value multiply(Value value) {
        return null;
    }

    @Override
    public Value dot(Value value) {
        return null;
    }
}
