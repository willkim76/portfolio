package types;

import java.math.BigDecimal;

public class ComplexScalar extends Scalar implements Operand {
    private final BigDecimal component_imag;

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
    public ComplexScalar add(Operand operand) {
        if (operand == null ) { throw new IllegalArgumentException(); }

        if (operand.getClass() == Vector.class) { throw new IllegalArgumentException(); }



        return new ComplexScalar(BigDecimal.ONE, BigDecimal.TEN);
    }

    @Override
    public ComplexScalar subtract(Operand operand) {
        return null;
    }

    @Override
    public ComplexScalar divide(Operand operand) {
        return null;
    }

    @Override
    public ComplexScalar multiply(Operand operand) {
        return null;
    }
}
