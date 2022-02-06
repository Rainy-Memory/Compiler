package IR.Instruction;

import FrontEnd.IRVisitor;
import IR.IRBasicBlock;
import IR.Operand.IROperand;
import IR.Operand.IRRegister;

public class IRIcmpInstruction extends IRInstruction {
    private final String op;
    private final IRRegister resultRegister;
    private IROperand lhs;
    private IROperand rhs;

    public IRIcmpInstruction(IRBasicBlock parentBlock, String op, IRRegister resultRegister, IROperand lhs, IROperand rhs) {
        super(parentBlock);
        this.op = op;
        this.resultRegister = resultRegister;
        this.lhs = lhs;
        this.rhs = rhs;
        lhs.addUser(this);
        rhs.addUser(this);
        resultRegister.setDef(this);
    }

    public String getOp() {
        return op;
    }

    public IRRegister getResultRegister() {
        return resultRegister;
    }

    public IROperand getLhs() {
        return lhs;
    }

    public IROperand getRhs() {
        return rhs;
    }

    @Override
    public void replaceUse(IROperand oldOperand, IROperand newOperand) {
        super.replaceUse(oldOperand, newOperand);
        if (lhs == oldOperand) {
            oldOperand.removeUser(this);
            lhs = newOperand;
            newOperand.addUser(this);
        }
        if (rhs == oldOperand) {
            oldOperand.removeUser(this);
            rhs = newOperand;
            newOperand.addUser(this);
        }
    }

    @Override
    public boolean noUsersAndSafeToRemove() {
        return resultRegister.getUsers().isEmpty();
    }

    @Override
    public String toString() {
        return resultRegister + " = icmp " + op + " " + lhs.getIRType() + " " + lhs + ", " + rhs;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
