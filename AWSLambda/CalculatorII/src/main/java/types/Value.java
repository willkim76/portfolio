package types;

public interface Value {

    public Value add(Value value);

    public Value subtract(Value value);

    public Value divide(Value value);

    public Value multiply(Value value);

    public Value dot(Value value);
}
