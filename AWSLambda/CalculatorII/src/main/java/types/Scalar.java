package types;

import com.amazonaws.services.kms.model.UnsupportedOperationException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Scalar implements Value {
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private final BigDecimal component_real;

    public Scalar(String component_real) {
        this(BigDecimal.valueOf(Long.parseLong(component_real)));
    }

    public Scalar(BigDecimal component_real) {
        this.component_real = component_real;
    }

    public BigDecimal getComponent_real() {
        return component_real;
    }

    @Override
    public Scalar add(Value value) {
        if (value == null) { throw new IllegalArgumentException(); }

        if (value.getClass() == ComplexScalar.class) {
            ComplexScalar that = (ComplexScalar) value;
            return new ComplexScalar(
                    this.component_real.add(that.getComponent_real()),
                    that.getComponent_imag()
            );
        } else if (value.getClass() == Scalar.class){
            Scalar that = (Scalar) value;
            return new Scalar(this.component_real.add(that.component_real));
        }

        throw new UnsupportedOperationException(
                "Unsupported Scalar add operation for " + value.getClass().getSimpleName()
        );
    }

    @Override
    public Scalar subtract(Value value) {
        if (value == null) { throw new IllegalArgumentException(); }

        if (value.getClass() == ComplexScalar.class) {
            ComplexScalar that = (ComplexScalar) value;
            return new ComplexScalar(
                    this.component_real.subtract(that.getComponent_real()),
                    that.getComponent_imag()
            );
        } else if (value.getClass() == Scalar.class){
            Scalar that = (Scalar) value;
            return new Scalar(this.component_real.subtract(that.component_real));
        }

        throw new UnsupportedOperationException(
                "Unsupported Scalar subtract operation for " + value.getClass().getSimpleName()
        );
    }

    @Override
    public Value divide(Value value) {
        if (value == null) { throw new IllegalArgumentException(); }

        if (value.getClass() == ComplexScalar.class) {
            ComplexScalar that = (ComplexScalar) value;
            return new ComplexScalar(
                    this.getComponent_real().multiply(that.getComponent_real())
                            .divide(that.getComponent_real().pow(2)
                                    .add(that.getComponent_imag().pow(2)), ROUNDING_MODE),
                    this.getComponent_real().multiply(that.getComponent_imag()).negate()
                            .divide(that.getComponent_real().pow(2)
                                    .add(that.getComponent_imag().pow(2)), ROUNDING_MODE)
            );
        } else if (value.getClass() == Scalar.class){
            Scalar that = (Scalar) value;
            return new Scalar(this.component_real.divide(that.component_real, ROUNDING_MODE));
        }

        throw new UnsupportedOperationException(
                "Unsupported Scalar divide operation for " + value.getClass().getSimpleName()
        );
    }

    @Override
    public Value multiply(Value value) {
        if (value == null) { throw new IllegalArgumentException(); }

        if (value.getClass() == ComplexScalar.class) {
            ComplexScalar that = (ComplexScalar) value;
            return new ComplexScalar(
                    this.getComponent_real().multiply(that.getComponent_real()),
                    this.getComponent_real().multiply(that.getComponent_imag())
            );
        } else if (value.getClass() == Scalar.class){
            Scalar that = (Scalar) value;
            return new Scalar(this.component_real.multiply(that.component_real));
        }

        throw new UnsupportedOperationException(
                "Unsupported Scalar multiply operation for " + value.getClass().getSimpleName()
        );
    }
}
