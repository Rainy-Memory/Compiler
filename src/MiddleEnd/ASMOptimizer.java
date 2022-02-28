package MiddleEnd;

import Memory.Memory;
import MiddleEnd.ASMOptimize.CodeEliminator;
import MiddleEnd.ASMOptimize.ControlFlowSimplifyer;
import MiddleEnd.ASMOptimize.PeepholePeeker;

import static Debug.MemoLog.log;

public class ASMOptimizer extends Optimize {
    static private final int rounds = 30;

    public void invoke(Memory memory) {
        if (level == OptimizeLevel.O0) return;
        int cnt = 0;
        boolean changed;
        while (cnt++ < rounds) {
            log.Infof("ASM Optimize round %d\n", cnt);
            changed = false;

            changed |= new PeepholePeeker().peek(memory);

            changed |= new CodeEliminator().eliminate(memory);

            if (level == OptimizeLevel.O2)
                changed |= new ControlFlowSimplifyer().simplify(memory);

            if (!changed) {
                log.Infof("No changed has made in this turn.\n");
                break;
            }
        }
    }
}