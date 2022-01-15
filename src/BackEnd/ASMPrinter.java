package BackEnd;

import ASM.ASMBasicBlock;
import ASM.Operand.ASMConstString;
import ASM.ASMFunction;
import ASM.ASMModule;
import ASM.Instruction.ASMInstruction;
import ASM.Operand.GlobalSymbol.ASMGlobalBoolean;
import ASM.Operand.GlobalSymbol.ASMGlobalInteger;
import ASM.Operand.GlobalSymbol.ASMGlobalSymbol;
import Memory.Memory;

import java.io.PrintStream;

/**
 * This class print rv32i assembly to output file.
 * Some format were based on clang.
 *
 * @author rainy memory
 * @version 1.0.0
 */

public class ASMPrinter {
    private PrintStream ps;
    private int indentCnt = 0;
    private int functionCnt = 0;

    private static PrintStream virtualStream = null;
    private static boolean print = false;
    private static boolean printVirtual = false;
    private static final int commentAlignLength = 50;
    private static final int alignLength = 15;

    public static int getAlignLength() {
        return alignLength;
    }

    public static void enable() {
        print = true;
    }

    public static void disable() {
        print = false;
    }

    public static void enableVirtual(PrintStream virtualStream) {
        ASMPrinter.virtualStream = virtualStream;
        printVirtual = true;
    }

    public static void disableVirtual() {
        printVirtual = false;
    }

    private void printWithIndent(String str) {
        for (int i = 0; i < indentCnt; i++) ps.print("\t");
        ps.println(str);
    }

    private String formatComment(String str, String comment) {
        int spaceNum = commentAlignLength - str.length() - 4 * indentCnt;
        assert spaceNum > 0;
        return str + " ".repeat(spaceNum) + "#" + comment;
    }

    private String formatPseudoOptions(String option, String value) {
        int spaceNum = alignLength - option.length() - 1;
        assert spaceNum > 0;
        return "." + option + " ".repeat(spaceNum) + value;
    }

    /**
     * This method print rv32i asm to PrintStream
     * specified by Memory.
     *
     * @see Memory
     */
    public void print(Memory memory) {
        if (print) {
            ps = memory.getPrintStream();
            print(memory.getAsmModule());
        }
    }

    public void printVirtual(Memory memory) {
        if (printVirtual) {
            assert virtualStream != null;
            ps = virtualStream;
            print(memory.getAsmModule());
        }
    }

    private void print(ASMModule module) {
        indentCnt++;
        printWithIndent(".text");
        printWithIndent(formatPseudoOptions("file", "\"src.mx\""));
        indentCnt--;
        module.getFunctions().values().forEach(this::print);
        if (module.getGlobals().values().size() != 0) {
            indentCnt++;
            printWithIndent("");
            printWithIndent(formatPseudoOptions("section", ".sdata, \"aw\", @progbits"));
            indentCnt--;
            module.getGlobals().values().forEach(this::print);
        }
        if (module.getStrings().values().size() != 0) {
            indentCnt++;
            printWithIndent("");
            printWithIndent(formatPseudoOptions("section", ".rodata.str1.1, \"aMS\", @progbits, 1"));
            indentCnt--;
            module.getStrings().values().forEach(this::print);
        }
    }

    private void print(ASMGlobalSymbol symbol) {
        String name = symbol.getSymbolName();
        printWithIndent("");
        indentCnt++;
        printWithIndent(formatComment(formatPseudoOptions("type", name + ", @object"), " @" + name));
        printWithIndent(formatPseudoOptions("globl", symbol.getSymbolName()));
        printWithIndent(formatPseudoOptions("p2align", "2"));
        indentCnt--;
        printWithIndent(name + ":");
        indentCnt++;
        int value = symbol.getValue();
        if (symbol instanceof ASMGlobalBoolean) {
            printWithIndent(formatComment(formatPseudoOptions("byte", Integer.toString(value)), " 0x" + value));
            printWithIndent(formatPseudoOptions("size", symbol.getSymbolName() + ", 1"));
        } else if (symbol instanceof ASMGlobalInteger) {
            printWithIndent(formatComment(formatPseudoOptions("word", Integer.toUnsignedString(value)), " 0x" + Integer.toUnsignedString(value, 16)));
            printWithIndent(formatPseudoOptions("size", symbol.getSymbolName() + ", 4"));
        } else {
            printWithIndent(formatPseudoOptions("word", Integer.toUnsignedString(value)));
            printWithIndent(formatPseudoOptions("size", name + ", 4"));
        }
        indentCnt--;
    }

    private void print(ASMConstString string) {
        String name = string.getName();
        printWithIndent("");
        indentCnt++;
        printWithIndent(formatComment(formatPseudoOptions("type", name + ", @object"), " @" + name));
        indentCnt--;
        printWithIndent(name + ":");
        String value = string.getValue();
        int length = string.getLength();
        indentCnt++;
        printWithIndent(formatPseudoOptions("asciz", "\"" + value + "\""));
        printWithIndent(formatPseudoOptions("size", name + ", " + (length + 1)));
        indentCnt--;
    }

    private void print(ASMFunction function) {
        String funcName = function.getFunctionName();
        indentCnt++;
        printWithIndent(formatComment(formatPseudoOptions("globl", funcName), " -- Begin Function " + funcName));
        printWithIndent(formatPseudoOptions("p2align", "2"));
        printWithIndent(formatPseudoOptions("type", funcName + ", @function"));
        indentCnt--;
        printWithIndent(formatComment(funcName + ":", " @" + funcName));
        function.getBlocks().forEach(this::print);
        String endLabel = ".Lfunc_end" + (functionCnt++);
        printWithIndent(endLabel + ":");
        indentCnt++;
        printWithIndent(formatPseudoOptions("size", funcName + ", " + endLabel + "-" + funcName));
        indentCnt--;
        printWithIndent(formatComment("", " -- End Function"));
    }

    private void print(ASMBasicBlock block) {
        printWithIndent(block.getLabel() + ":");
        indentCnt++;
        block.getInstructions().forEach(this::print);
        indentCnt--;
    }

    private void print(ASMInstruction inst) {
        if (inst == null) return; // used in printVirtual
        printWithIndent(inst.toString());
    }
}
