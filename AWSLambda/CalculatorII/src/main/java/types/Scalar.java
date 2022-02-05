package types;

import java.lang.UnsupportedOperationException;
import exceptions.IllegalOperandException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Scalar implements Operand, Comparable<Scalar> {
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private final BigDecimal component_real;

    public Scalar(BigDecimal component_real) {
        if (component_real == null) throw new IllegalOperandException();
        this.component_real = component_real;
    }

    public BigDecimal getComponent_real() {
        return this.component_real;
    }

    @Override
    public Scalar add(Operand operand) {
        if (operand == null) { throw new IllegalArgumentException(); }

        if (operand.getClass() == ComplexScalar.class) {
            ComplexScalar that = (ComplexScalar) operand;
            return new ComplexScalar(
                    this.component_real.add(that.getComponent_real()),
                    that.getComponent_imag()
            );
        } else if (operand.getClass() == Scalar.class){
            Scalar that = (Scalar) operand;
            return new Scalar(this.component_real.add(that.component_real));
        }

        throw new UnsupportedOperationException(
                "Unsupported Scalar add operation for " + operand.getClass().getSimpleName()
        );
    }

    @Override
    public Scalar subtract(Operand operand) {
        if (operand == null) { throw new IllegalArgumentException(); }

        if (operand.getClass() == ComplexScalar.class) {
            ComplexScalar that = (ComplexScalar) operand;
            return new ComplexScalar(
                    this.component_real.subtract(that.getComponent_real()),
                    that.getComponent_imag()
            );
        } else if (operand.getClass() == Scalar.class){
            Scalar that = (Scalar) operand;
            return new Scalar(this.component_real.subtract(that.component_real));
        }

        throw new UnsupportedOperationException(
                "Unsupported Scalar subtract operation for " + operand.getClass().getSimpleName()
        );
    }

    @Override
    public Operand divide(Operand operand) {
        if (operand == null) { throw new IllegalArgumentException(); }

        if (operand.getClass() == ComplexScalar.class) {
            ComplexScalar that = (ComplexScalar) operand;
            return new ComplexScalar(
                    this.getComponent_real().multiply(that.getComponent_real())
                            .divide(that.getComponent_real().pow(2)
                                    .add(that.getComponent_imag().pow(2)), ROUNDING_MODE),
                    this.getComponent_real().multiply(that.getComponent_imag()).negate()
                            .divide(that.getComponent_real().pow(2)
                                    .add(that.getComponent_imag().pow(2)), ROUNDING_MODE)
            );
        } else if (operand.getClass() == Scalar.class){
            Scalar that = (Scalar) operand;
            return new Scalar(this.component_real.divide(that.component_real, ROUNDING_MODE));
        }

        throw new UnsupportedOperationException(
                "Unsupported Scalar divide operation for " + operand.getClass().getSimpleName()
        );
    }

    @Override
    public Operand multiply(Operand operand) {
        if (operand == null) { throw new IllegalArgumentException(); }

        if (operand.getClass() == ComplexScalar.class) {
            ComplexScalar that = (ComplexScalar) operand;
            return new ComplexScalar(
                    this.getComponent_real().multiply(that.getComponent_real()),
                    this.getComponent_real().multiply(that.getComponent_imag())
            );
        } else if (operand.getClass() == Scalar.class){
            Scalar that = (Scalar) operand;
            return new Scalar(this.component_real.multiply(that.component_real));
        }

        throw new UnsupportedOperationException(
                "Unsupported Scalar multiply operation for " + operand.getClass().getSimpleName()
        );
    }

    @Override
    public String toString() {
        return "Scalar{" + this.component_real + "}";
    }

    @Override
    public int compareTo(Scalar o) {
        return this.component_real.compareTo(o.getComponent_real());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scalar that = (Scalar) o;
        return Objects.equals(this.component_real, that.component_real);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.component_real);
    }
}
