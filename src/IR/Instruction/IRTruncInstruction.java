package IR.Instruction;

import IR.IRVisitor;
import IR.Operand.IROperand;
import IR.Operand.IRRegister;
import IR.TypeSystem.IRIntType;
import IR.TypeSystem.IRTypeSystem;

public class IRTruncInstruction extends IRInstruction {
    private final IRRegister truncResultRegister;
    private final IROperand truncTarget;
    private final IRTypeSystem originalType;
    private final IRTypeSystem resultType;

    public IRTruncInstruction(IRRegister truncResultRegister, IROperand truncTarget, IRTypeSystem resultType) {
        assert truncResultRegister.getIRType() instanceof IRIntType;
        assert truncTarget.getIRType() instanceof IRIntType;
        assert resultType instanceof IRIntType;
        this.truncResultRegister = truncResultRegister;
        this.truncTarget = truncTarget;
        this.originalType = truncTarget.getIRType();
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return truncResultRegister + " = trunc " + originalType + " " + truncTarget + " to " + resultType;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
