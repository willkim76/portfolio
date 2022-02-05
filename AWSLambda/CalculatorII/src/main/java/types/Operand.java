package types;

public interface Operand {

    public Operand add(Operand operand);

    public Operand subtract(Operand operand);

    public Operand divide(Operand operand);

    public Operand multiply(Operand operand);
}
