package IR.Operand;

import IR.TypeSystem.IRTypeSystem;

public class IRConstBool extends IRConstNumber {
    private final boolean value;

    public IRConstBool(IRTypeSystem irType, boolean value) {
        super(irType);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public int getIntValue() {
        return value ? 1 : 0;
    }

    @Override
    public String toString() {
        // bool is treated as i8 and has init value of const int 0 && 1 in clang
        // however, const bool is "true" and "false".
        return value ? "true" : "false";
    }
}