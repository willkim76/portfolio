package exceptions;

public class IllegalOperandException extends RuntimeException {

    public IllegalOperandException() {}

    public IllegalOperandException(String msg) {
        super(msg);
    }
}
