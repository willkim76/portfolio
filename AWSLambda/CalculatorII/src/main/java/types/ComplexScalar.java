package types;

import java.math.BigDecimal;

public class ComplexScalar extends Scalar implements Value {
    private final BigDecimal component_imag;

    public ComplexScalar(String component_real, String component_imag) {
        this(BigDecimal.valueOf(Long.parseLong(component_real)),
                BigDecimal.valueOf(Long.parseLong(component_imag))
        );
    }

    public ComplexScalar(BigDecimal component_real, BigDecimal component_imag) {
        super(component_real);
        this.component_imag = component_imag;
    }

    @Override
    public BigDecimal getComponent_real() {
        return super.getComponent_real();
    }

    public BigDecimal getComponent_imag() {
        return this.component_imag;
    }

    @Override
    public ComplexScalar add(Value value) {
        if (value == null ) { throw new IllegalArgumentException(); }

        if (value.getClass() == Vector.class) { throw new IllegalArgumentException(); }



        return new ComplexScalar(BigDecimal.ONE, BigDecimal.TEN);
    }

    @Override
    public ComplexScalar subtract(Value value) {
        return null;
    }

    @Override
    public ComplexScalar divide(Value value) {
        return null;
    }

    @Override
    public ComplexScalar multiply(Value value) {
        return null;
    }
}
