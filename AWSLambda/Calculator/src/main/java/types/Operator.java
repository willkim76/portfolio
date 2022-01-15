package types;

/**
 * Defines the behavior of the Value type. Performs the mathematical operations of Scalars,
 * Vectors, and Complex Numbers.
 */
public enum Operator {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    // TODO: Vector/Complex and Scalar operation initial logic needs to be refined.
    public static Value evaluate(Operator operator, Value value_1, Value value_2) {
        Value result = null;
        switch (operator) {
            case ADD: {
                checkValidAddSubtraction(value_1, value_2);
                result = Value.builder()
                        .withValue1(value_1.getComponent_1().add(value_2.getComponent_2()))
                        .withValue2(value_1.getComponent_2().add(value_2.getComponent_2()))
                        .withComplex(value_1.isComplex())
                        .build();
                break;
            }
            case SUBTRACT: {
                checkValidAddSubtraction(value_1, value_2);
                result = Value.builder()
                        .withValue1(value_1.getComponent_1().subtract(value_2.getComponent_2()))
                        .withValue2(value_1.getComponent_2().subtract(value_2.getComponent_2()))
                        .withComplex(value_1.isComplex())
                        .build();
                break;
            }
            case MULTIPLY: {
                checkValidMultiplication(value_1, value_2);
                result = Value.builder()
                        .withValue1(value_1.getComponent_1().multiply(value_2.getComponent_2()))
                        .withValue2(value_1.getComponent_2().multiply(value_2.getComponent_2()))
                        .withComplex(value_1.isComplex())
                        .build();
                break;
            }
            case DIVIDE: {
                checkValidDivision(value_1, value_2);
                result = Value.builder()
                        .withValue1(value_1.getComponent_1().divide(value_2.getComponent_1()))
                        .withValue2(value_1.getComponent_1().divide(value_2.getComponent_2()))
                        .build();
                break;
            }
            default: {
                throw new IllegalArgumentException("Undefined Operator");
            }
        }
        return result;
    }

    // TODO Need to update operation check
    private static void checkValidAddSubtraction(Value value_1, Value value_2) {
        throw new IllegalArgumentException("Cannot ADD Scalar to Vector");
    }

    private static void checkValidMultiplication(Value value_1, Value value_2) {
        throw new IllegalArgumentException("Cannot");
    }

    private static void checkValidDivision(Value value_1, Value value_2) {
        throw new IllegalArgumentException("");
    }
}
