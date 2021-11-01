package Debug;

import Utility.Memory;
import Utility.Scope.*;

import java.util.concurrent.atomic.AtomicInteger;

public class ScopePrinter {
    public void print(Memory memory) {
        printf("----------------------------------------ScopePrinter----------------------------------------\n");
        printScope(memory.getGlobalScope());
        printf("----------------------------------------ScopePrinter----------------------------------------\n");
    }

    private int indentCnt = 0;
    private final int tabletLength = 60;

    private void printf(String format, Object... args) {
        for (int i = 0; i < indentCnt; i++) System.out.print("\t");
        System.out.printf(format, args);
    }

    private void enter(String name) {
        printf("[begin] %s:\n", name);
        indentCnt++;
    }

    private void leave(String name) {
        indentCnt--;
        printf("[ end ] %s.\n", name);
    }

    private void printDefaultScope(Scope scope) {
        if (scope.getVariables().size() == 0) {
            if (scope instanceof GlobalScope) {
//                printf("there is no global variable. but it is obvious since you don't collect variables in symbol collector =.=\n");
            }
            if (scope instanceof ClassScope) {
                printf("this class has no member.\n");
            }
            if (scope instanceof FunctionScope) {
//                printf("this function has no local variable.\n");
            }
            if (scope instanceof ConstructorScope) {
//                printf("this constructor has no local variable.\n");
            }
        } else {
            printf("-variables: (%d)\n", scope.getVariables().size());
            printf("%-" + (tabletLength - indentCnt * 4) + "s%s\n", "variable type", "variable name");
            scope.getVariables().forEach((k, v) -> {
                printf("%-" + (tabletLength - indentCnt * 4) + "s%s\n", v.getVariableType().getTypeName(), k);
            });
        }
        if (scope.getFunctions().size() == 0) {
            if (scope instanceof GlobalScope) {
                printf("there is no global function.\n");
            }
            if (scope instanceof ClassScope) {
                printf("this class has no member function.\n");
            }
            if (scope instanceof FunctionScope) {
//                printf("function cannot have inner functions.\n");
            }
            if (scope instanceof ConstructorScope) {
//                printf("constructor cannot have inner functions.\n");
            }
        } else {
            printf("-functions: (%d)\n", scope.getFunctions().size());
            printf("%-" + (tabletLength - indentCnt * 4) + "s%s\n", "function return type", "function name");
            scope.getFunctions().forEach((k, v) -> {
                printf("%-" + (tabletLength - indentCnt * 4) + "s%s\n", v.getReturnType().getTypeName(), k);
                printScope(v.getFunctionScope());
            });
        }
    }

    private void printScope(GlobalScope scope) {
        enter("Global Scope");
        printf("classes:\n");
        printf("builtin type:\n");
        AtomicInteger cnt = new AtomicInteger(0);
        scope.getClasses().forEach((k, v) -> {
            if (v.isBuiltinType()) {
                printf("%s\n", k);
            } else cnt.set(cnt.get() + 1);
        });
        if (cnt.equals(new AtomicInteger(0))) {
            printf("global scope has no custom class.\n");
        } else {
            printf("custom class: (%d)\n", cnt.get());
            scope.getClasses().forEach((k, v) -> {
                if (!v.isBuiltinType()) {
                    printf("class name: %s\n", k);
                    printScope(v.getClassScope());
                }
            });
        }
        printDefaultScope(scope);
        leave("Global Scope");
    }

    private void printScope(ClassScope scope) {
        enter("Class Scope");
        if (scope.hasCustomConstructor()) {
            printf("constructor:\n");
            printScope(scope.getConstructor().getConstructorScope());
        } else {
            printf("this class has no custom constructor.\n");
        }
        printDefaultScope(scope);
        leave("Class Scope");
    }

    private void printScope(FunctionScope scope) {
        enter("Function Scope");
        if (scope.getParameters().size() == 0) {
            printf("this function has no parameter.\n");
        } else {
            printf("parameters: (%d)\n", scope.getParameters().size());
            printf("%-" + (tabletLength - indentCnt * 4) + "s%s\n", "parameter type", "parameter name");
            scope.getParameters().forEach(parameter -> {
                printf("%-" + (tabletLength - indentCnt * 4) + "s%s\n", parameter.getVariableType().getTypeName(), parameter.getEntityName());
            });
        }
        printDefaultScope(scope);
        leave("Function Scope");
    }

    private void printScope(ConstructorScope scope) {
        enter("Constructor Scope");
        printDefaultScope(scope);
        leave("Constructor Scope");
    }
}
