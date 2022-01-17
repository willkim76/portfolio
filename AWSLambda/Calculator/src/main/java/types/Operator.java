package types;

import static java.math.RoundingMode.HALF_UP;

/**
 * Defines the behavior of the Value type, specifically the mathematical operations of Scalars,
 * 2D Vectors, and Complex Numbers and the rules of operation.
 */
public enum Operator {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    DOT;

    /**
     * Performs the mathematical operation of Scalars, 2D Vectors, and Complex Numbers
     * @param operator - Operator, the operation to apply to operands
     * @param oprnd_1 - Value the first operand
     * @param oprnd_2 - Value the second operand
     * @return The Value result of the operation
     * @throws IllegalArgumentException
     */
    public static Value evaluate(Operator operator, Value oprnd_1, Value oprnd_2) {
        Value result = null;
        switch (operator) {
            case ADD: {
                checkValidAddSubOperands(ADD, oprnd_1, oprnd_2);

                Value.Builder resultValue = Value.builder();
                if (!oprnd_1.isScalar()) {
                    resultValue.withComponent2(oprnd_1.getComponent_2().add(oprnd_2.getComponent_2()));
                }
                result = resultValue.withComponent1(oprnd_1.getComponent_1().add(oprnd_2.getComponent_1()))
                        .withComplex(oprnd_1.isComplex())
                        .build();
                break;
            }
            case SUBTRACT: {
                checkValidAddSubOperands(SUBTRACT, oprnd_1, oprnd_2);

                Value.Builder resultValue = Value.builder();
                if (!oprnd_1.isScalar()) {
                    resultValue.withComponent2(oprnd_1.getComponent_2().subtract(oprnd_2.getComponent_2()));
                }
                result = resultValue.withComponent1(oprnd_1.getComponent_1().subtract(oprnd_2.getComponent_1()))
                        .withComplex(oprnd_1.isComplex())
                        .build();
                break;
            }
            case MULTIPLY: {
                checkValidMultiOperands(oprnd_1, oprnd_2);
                if (oprnd_1.isScalar() && oprnd_2.isScalar()) {
                    result = Value.builder()
                            .withComponent1(oprnd_1.getComponent_1().multiply(oprnd_2.getComponent_1()))
                            .build();
                } else if (!oprnd_1.isScalar()) {
                    result = Value.builder()
                            .withComponent1(oprnd_1.getComponent_1().multiply(oprnd_2.getComponent_1()))
                            .withComponent2(oprnd_1.getComponent_2().multiply(oprnd_2.getComponent_1()))
                            .withComplex(oprnd_1.isComplex())
                            .build();
                } else if (!oprnd_2.isScalar()){
                    result = Value.builder()
                            .withComponent1(oprnd_2.getComponent_1().multiply(oprnd_1.getComponent_1()))
                            .withComponent2(oprnd_2.getComponent_2().multiply(oprnd_1.getComponent_1()))
                            .withComplex(oprnd_2.isComplex())
                            .build();
                }
                break;
            }
            case DIVIDE: {
                checkValidMultiOperands(oprnd_1, oprnd_2);
                if (oprnd_1.isScalar() || oprnd_2.isScalar()) { }
                    result = Value.builder()
                        .withComponent1(oprnd_1.getComponent_1().divide(oprnd_2.getComponent_1(), HALF_UP))
                        .withComponent2(oprnd_1.getComponent_1().divide(oprnd_2.getComponent_2(), HALF_UP))
                        .build();
                break;
            }
            case DOT: {
                checkValidDotOperands(oprnd_1, oprnd_2);
                result = Value.builder()
                        .withComponent1(
                                oprnd_1.getComponent_1().multiply(oprnd_2.getComponent_1())
                                .add(oprnd_1.getComponent_2().multiply(oprnd_2.getComponent_2()))
                        )
                        .build();
                break;
            }
            default: {
                throw new IllegalArgumentException("Undefined Operation: " + operator);
            }
        }
        return result;
    }

    private static void checkValidAddSubOperands(Operator operator, Value oprnd_1, Value oprnd_2) {
        if (oprnd_1.isScalar() != oprnd_2.isScalar() || oprnd_1.isComplex() != oprnd_2.isComplex()) {
            String errArg1 = oprnd_1.isScalar() || oprnd_2.isScalar() ? "Scalar Value" : "Vector Value";
            String errArg2 = oprnd_1.isComplex() || oprnd_2.isComplex() ? "Complex Value" : "Vector Value";
            throw new IllegalArgumentException(
                    String.format("Cannot %s a %s to a %s", operator, errArg1, errArg2)
            );
        }
    }

    private static void checkValidMultiOperands(Value oprnd_1, Value oprnd_2) {
        if (!oprnd_1.isScalar() && !oprnd_2.isScalar()) {
            String errArg1 = oprnd_1.isComplex() ? "Complex Value" : "Vector Value";
            String errArg2 = oprnd_2.isComplex() ? "Complex Value" : "Vector Value";
            throw new IllegalArgumentException(
                    String.format("Cannot MULTIPLY a %s with a %s", errArg1, errArg2)
            );
        }
    }

    private static void checkValidDotOperands(Value oprnd_1, Value oprnd_2) {
        if (oprnd_1.isScalar() || oprnd_2.isScalar()) {
            String errArg1 =
                    oprnd_1.isScalar() ? "Scalar Value" : oprnd_1.isComplex() ? "Complex Value" : "Vector Value";
            String errArg2 =
                    oprnd_2.isScalar() ? "Scalar Value" : oprnd_2.isComplex() ? "Complex Value" : "Vector Value";
            throw new IllegalArgumentException(
                    String.format("Cannot DOT a %s with a %s", errArg1, errArg2)
            );
        }
    }
}
