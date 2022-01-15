package types;

import java.math.BigDecimal;

/**
 * Defines the behavior of the Operand type. Performs the mathematical operations of Scalars,
 * Vectors, and Complex Numbers.
 */
public enum Operator {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    // TODO: Vector/Complex and Scalar operation initial logic needs to be refined.
    public static Operand evaluate(Operator operator, Operand operand_1, Operand operand_2) {
        Operand result = null;
        switch (operator) {
            case ADD: {
                checkValidAddSubtraction(operand_1, operand_2);
                result = Operand.builder()
                        .withValue1(operand_1.getValue_1().add(operand_2.getValue_2()))
                        .withValue2(operand_1.getValue_2().add(operand_2.getValue_2()))
                        .withComplex(operand_1.isComplex())
                        .build();
                break;
            }
            case SUBTRACT: {
                checkValidAddSubtraction(operand_1, operand_2);
                result = Operand.builder()
                        .withValue1(operand_1.getValue_1().subtract(operand_2.getValue_2()))
                        .withValue2(operand_1.getValue_2().subtract(operand_2.getValue_2()))
                        .withComplex(operand_1.isComplex())
                        .build();
                break;
            }
            case MULTIPLY: {
                checkValidMultiplication(operand_1, operand_2);
                result = Operand.builder()
                        .withValue1(operand_1.getValue_1().multiply(operand_2.getValue_2()))
                        .withValue2(operand_1.getValue_2().multiply(operand_2.getValue_2()))
                        .withComplex(operand_1.isComplex())
                        .build();
                break;
            }
            case DIVIDE: {
                checkValidDivision(operand_1, operand_2);
                result = Operand.builder()
                        .withValue1(operand_1.getValue_1().divide(operand_2.getValue_1()))
                        .withValue2(operand_1.getValue_1().divide(operand_2.getValue_2()))
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
    private static void checkValidAddSubtraction(Operand operand_1, Operand operand_2) {
        throw new IllegalArgumentException("Cannot ADD Scalar to Vector");
    }

    private static void checkValidMultiplication(Operand operand_1, Operand operand_2) {
        throw new IllegalArgumentException("Cannot");
    }

    private static void checkValidDivision(Operand operand_1, Operand operand_2) {
        throw new IllegalArgumentException("");
    }
}
