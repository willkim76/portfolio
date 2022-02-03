package exceptions;

public class IllegalValueException extends RuntimeException {

    public IllegalValueException() {}

    public IllegalValueException(String msg) {
        super(msg);
    }
}
