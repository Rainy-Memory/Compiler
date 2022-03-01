# PrismCube

![PrismCube](assets/PrismCube.png)

PrismCube, a toy Mx* compiler with java implementation.

Fun fact: To learn more about project name, click [here](https://www.youtube.com/watch?v=CV3nAHhopRY).

![](https://img.shields.io/badge/version-1.0.0-green.svg)
![](https://img.shields.io/badge/all_testcases-passed-green.svg)
![](https://img.shields.io/badge/JDK_version-17-orange.svg)
[![](https://img.shields.io/badge/source_language-Mx*-yellow.svg)](https://github.com/ACMClassCourses/Compiler-Design-Implementation)
![](https://img.shields.io/github/last-commit/Rainy-Memory/PrismCube)

![](https://img.shields.io/github/languages/top/Rainy-Memory/PrismCube)
![](https://img.shields.io/github/languages/code-size/Rainy-Memory/PrismCube)
![](https://img.shields.io/github/repo-size/Rainy-Memory/PrismCube)

## Mx* Language

Mx* is a simplified language from the mix of Standard C++ and Java. Details of Mx* can be found [here](https://github.com/ACMClassCourses/Compiler-Design-Implementation).

## Progress

 - [x] g4
 - [x] ArgumentProcessor (inside Memory)
 - [x] Preprocessor
 - [x] ASTBuilder
 - [x] ASTPrinter (inspired by [Masterball](https://github.com/SiriusNEO/Masterball))
 - [x] SymbolCollector
 - [x] ScopePrinter
 - [x] SemanticChecker
 - [x] ConstStringCollector
 - [x] IRBuilder
 - [x] IRPrinter
 - [x] InstructionSelector
 - [x] NaiveAllocator
 - [x] GraphColoringAllocator
 - [x] ASMPrinter
 - [x] Optimize

## File Structure

```
📦src
 ┣ 📂ASM
 ┃ ┣ 📂Instruction
 ┃ ┃ ┣ 📜ASMArithmeticInstruction.java
 ┃ ┃ ┣ 📜ASMCloneInstruction.java
 ┃ ┃ ┣ 📜ASMInstruction.java
 ┃ ┃ ┣ 📜ASMMemoryInstruction.java
 ┃ ┃ ┣ 📜ASMMoveInstruction.java
 ┃ ┃ ┗ 📜ASMPseudoInstruction.java
 ┃ ┣ 📂Operand
 ┃ ┃ ┣ 📂GlobalSymbol
 ┃ ┃ ┃ ┣ 📜ASMGlobalBoolean.java
 ┃ ┃ ┃ ┣ 📜ASMGlobalInteger.java
 ┃ ┃ ┃ ┣ 📜ASMGlobalString.java
 ┃ ┃ ┃ ┗ 📜ASMGlobalSymbol.java
 ┃ ┃ ┣ 📜ASMAddress.java
 ┃ ┃ ┣ 📜ASMConstString.java
 ┃ ┃ ┣ 📜ASMImmediate.java
 ┃ ┃ ┣ 📜ASMLabel.java
 ┃ ┃ ┣ 📜ASMOperand.java
 ┃ ┃ ┣ 📜ASMPhysicalRegister.java
 ┃ ┃ ┣ 📜ASMRegister.java
 ┃ ┃ ┗ 📜ASMVirtualRegister.java
 ┃ ┣ 📜ASMBasicBlock.java
 ┃ ┣ 📜ASMFunction.java
 ┃ ┣ 📜ASMModule.java
 ┃ ┗ 📜ASMStackFrame.java
 ┣ 📂AST
 ┃ ┣ 📂DefineNode
 ┃ ┃ ┣ 📜ClassDefineNode.java
 ┃ ┃ ┣ 📜ConstructorDefineNode.java
 ┃ ┃ ┣ 📜FunctionDefineNode.java
 ┃ ┃ ┣ 📜ParameterDefineNode.java
 ┃ ┃ ┣ 📜ProgramDefineNode.java
 ┃ ┃ ┣ 📜SingleVariableDefineNode.java
 ┃ ┃ ┗ 📜VariableDefineNode.java
 ┃ ┣ 📂ExpressionNode
 ┃ ┃ ┣ 📜AddressingExpressionNode.java
 ┃ ┃ ┣ 📜AssignExpressionNode.java
 ┃ ┃ ┣ 📜BinaryExpressionNode.java
 ┃ ┃ ┣ 📜ExpressionNode.java
 ┃ ┃ ┣ 📜FunctionCallExpressionNode.java
 ┃ ┃ ┣ 📜LambdaExpressionNode.java
 ┃ ┃ ┣ 📜LeftValueExpressionNode.java
 ┃ ┃ ┣ 📜MemberAccessExpressionNode.java
 ┃ ┃ ┣ 📜NewTypeExpressionNode.java
 ┃ ┃ ┣ 📜PostCrementExpressionNode.java
 ┃ ┃ ┗ 📜UnaryExpressionNode.java
 ┃ ┣ 📂PrimaryNode
 ┃ ┃ ┣ 📜BoolConstantPrimaryNode.java
 ┃ ┃ ┣ 📜IdentifierPrimaryNode.java
 ┃ ┃ ┣ 📜NullConstantPrimaryNode.java
 ┃ ┃ ┣ 📜NumericalConstantPrimaryNode.java
 ┃ ┃ ┣ 📜PrimaryNode.java
 ┃ ┃ ┣ 📜StringConstantPrimaryNode.java
 ┃ ┃ ┗ 📜ThisPrimaryNode.java
 ┃ ┣ 📂StatementNode
 ┃ ┃ ┣ 📜BlockStatementNode.java
 ┃ ┃ ┣ 📜BreakStatementNode.java
 ┃ ┃ ┣ 📜ContinueStatementNode.java
 ┃ ┃ ┣ 📜EmptyStatementNode.java
 ┃ ┃ ┣ 📜ExpressionStatementNode.java
 ┃ ┃ ┣ 📜ForStatementNode.java
 ┃ ┃ ┣ 📜IfStatementNode.java
 ┃ ┃ ┣ 📜ReturnStatementNode.java
 ┃ ┃ ┣ 📜StatementNode.java
 ┃ ┃ ┗ 📜WhileStatementNode.java
 ┃ ┣ 📂TypeNode
 ┃ ┃ ┣ 📜ArrayTypeNode.java
 ┃ ┃ ┣ 📜BuiltinTypeNode.java
 ┃ ┃ ┣ 📜ClassTypeNode.java
 ┃ ┃ ┣ 📜ReturnTypeNode.java
 ┃ ┃ ┣ 📜SpecialTypeNode.java
 ┃ ┃ ┗ 📜TypeNode.java
 ┃ ┣ 📜ASTNode.java
 ┃ ┣ 📜ASTVisitor.java
 ┃ ┗ 📜ProgramNode.java
 ┣ 📂BackEnd
 ┃ ┣ 📂RegisterAllocate
 ┃ ┃ ┣ 📜GraphColoringAllocator.java
 ┃ ┃ ┣ 📜LivenessAnalyzer.java
 ┃ ┃ ┗ 📜NaiveAllocator.java
 ┃ ┣ 📜ASMEmitter.java
 ┃ ┣ 📜InstructionSelector.java
 ┃ ┗ 📜RegisterAllocator.java
 ┣ 📂Debug
 ┃ ┣ 📜ASTPrinter.java
 ┃ ┣ 📜MemoLog.java
 ┃ ┗ 📜ScopePrinter.java
 ┣ 📂FrontEnd
 ┃ ┣ 📜ASTBuilder.java
 ┃ ┣ 📜ConstStringCollector.java
 ┃ ┣ 📜IRBuilder.java
 ┃ ┣ 📜IREmitter.java
 ┃ ┣ 📜IRVisitor.java
 ┃ ┣ 📜Preprocessor.java
 ┃ ┣ 📜SemanticChecker.java
 ┃ ┗ 📜SymbolCollector.java
 ┣ 📂IR
 ┃ ┣ 📂Instruction
 ┃ ┃ ┣ 📜IRAllocaInstruction.java
 ┃ ┃ ┣ 📜IRBinaryInstruction.java
 ┃ ┃ ┣ 📜IRBitcastInstruction.java
 ┃ ┃ ┣ 📜IRBrInstruction.java
 ┃ ┃ ┣ 📜IRCallInstruction.java
 ┃ ┃ ┣ 📜IRGetelementptrInstruction.java
 ┃ ┃ ┣ 📜IRIcmpInstruction.java
 ┃ ┃ ┣ 📜IRInstruction.java
 ┃ ┃ ┣ 📜IRJumpInstruction.java
 ┃ ┃ ┣ 📜IRLoadInstruction.java
 ┃ ┃ ┣ 📜IRMoveInstruction.java
 ┃ ┃ ┣ 📜IRPhiInstruction.java
 ┃ ┃ ┣ 📜IRReturnInstruction.java
 ┃ ┃ ┣ 📜IRStoreInstruction.java
 ┃ ┃ ┣ 📜IRTruncInstruction.java
 ┃ ┃ ┗ 📜IRZextInstruction.java
 ┃ ┣ 📂Operand
 ┃ ┃ ┣ 📜IRConst.java
 ┃ ┃ ┣ 📜IRConstBool.java
 ┃ ┃ ┣ 📜IRConstChar.java
 ┃ ┃ ┣ 📜IRConstInt.java
 ┃ ┃ ┣ 📜IRConstNumber.java
 ┃ ┃ ┣ 📜IRConstString.java
 ┃ ┃ ┣ 📜IRGlobalVariableRegister.java
 ┃ ┃ ┣ 📜IRLabel.java
 ┃ ┃ ┣ 📜IRNull.java
 ┃ ┃ ┣ 📜IROperand.java
 ┃ ┃ ┣ 📜IRRegister.java
 ┃ ┃ ┗ 📜IRZeroInitializer.java
 ┃ ┣ 📂TypeSystem
 ┃ ┃ ┣ 📜IRIntType.java
 ┃ ┃ ┣ 📜IRNullType.java
 ┃ ┃ ┣ 📜IRPointerType.java
 ┃ ┃ ┣ 📜IRStructureType.java
 ┃ ┃ ┣ 📜IRTypeSystem.java
 ┃ ┃ ┗ 📜IRVoidType.java
 ┃ ┣ 📜IRBasicBlock.java
 ┃ ┣ 📜IRFunction.java
 ┃ ┣ 📜IRGlobalDefine.java
 ┃ ┗ 📜IRModule.java
 ┣ 📂Memory
 ┃ ┗ 📜Memory.java
 ┣ 📂MiddleEnd
 ┃ ┣ 📂ASMOptimize
 ┃ ┃ ┣ 📜BlockReorderer.java
 ┃ ┃ ┣ 📜CodeEliminator.java
 ┃ ┃ ┣ 📜CodePuller.java
 ┃ ┃ ┣ 📜ControlFlowSimplifyer.java
 ┃ ┃ ┗ 📜PeepholePeeker.java
 ┃ ┣ 📂Deprecated
 ┃ ┃ ┣ 📜IRGlobalInitializeEliminator.java
 ┃ ┃ ┗ 📜TrivialDeadCodeEliminator.java
 ┃ ┣ 📂IROptimize
 ┃ ┃ ┣ 📜AggressiveDeadCodeEliminator.java
 ┃ ┃ ┣ 📜ControlFlowGraphChecker.java
 ┃ ┃ ┣ 📜FunctionInliner.java
 ┃ ┃ ┣ 📜IRBlockFuser.java
 ┃ ┃ ┣ 📜LoopOptimizer.java
 ┃ ┃ ┣ 📜MemoryToRegisterPromoter.java
 ┃ ┃ ┣ 📜PhiResolver.java
 ┃ ┃ ┗ 📜SparseConditionalConstantPropagator.java
 ┃ ┣ 📂Pass
 ┃ ┃ ┣ 📜ASMFunctionPass.java
 ┃ ┃ ┗ 📜IRFunctionPass.java
 ┃ ┣ 📂Utils
 ┃ ┃ ┣ 📜CloneManager.java
 ┃ ┃ ┣ 📜CopyInterfereGraph.java
 ┃ ┃ ┣ 📜DominatorTreeBuilder.java
 ┃ ┃ ┣ 📜IRLoop.java
 ┃ ┃ ┗ 📜LoopExtractor.java
 ┃ ┣ 📜ASMOptimizer.java
 ┃ ┣ 📜IROptimizer.java
 ┃ ┗ 📜Optimize.java
 ┣ 📂Parser
 ┃ ┣ 📜MxStar.g4
 ┃ ┣ 📜MxStar.interp
 ┃ ┣ 📜MxStar.tokens
 ┃ ┣ 📜MxStarBaseListener.java
 ┃ ┣ 📜MxStarBaseVisitor.java
 ┃ ┣ 📜MxStarLexer.interp
 ┃ ┣ 📜MxStarLexer.java
 ┃ ┣ 📜MxStarLexer.tokens
 ┃ ┣ 📜MxStarListener.java
 ┃ ┣ 📜MxStarParser.java
 ┃ ┗ 📜MxStarVisitor.java
 ┣ 📂Utility
 ┃ ┣ 📂Entity
 ┃ ┃ ┣ 📜ConstructorEntity.java
 ┃ ┃ ┣ 📜Entity.java
 ┃ ┃ ┣ 📜FunctionEntity.java
 ┃ ┃ ┣ 📜MethodEntity.java
 ┃ ┃ ┗ 📜VariableEntity.java
 ┃ ┣ 📂Scope
 ┃ ┃ ┣ 📜BlockScope.java
 ┃ ┃ ┣ 📜BracesScope.java
 ┃ ┃ ┣ 📜BranchScope.java
 ┃ ┃ ┣ 📜ClassScope.java
 ┃ ┃ ┣ 📜ConstructorScope.java
 ┃ ┃ ┣ 📜FunctionScope.java
 ┃ ┃ ┣ 📜GlobalScope.java
 ┃ ┃ ┣ 📜LoopScope.java
 ┃ ┃ ┣ 📜MethodScope.java
 ┃ ┃ ┗ 📜Scope.java
 ┃ ┣ 📂Type
 ┃ ┃ ┣ 📜ArrayType.java
 ┃ ┃ ┣ 📜ClassType.java
 ┃ ┃ ┗ 📜Type.java
 ┃ ┣ 📂error
 ┃ ┃ ┣ 📜ASMError.java
 ┃ ┃ ┣ 📜ArgumentParseError.java
 ┃ ┃ ┣ 📜IRError.java
 ┃ ┃ ┣ 📜LogError.java
 ┃ ┃ ┣ 📜OptimizeError.java
 ┃ ┃ ┣ 📜SemanticError.java
 ┃ ┃ ┣ 📜SyntaxError.java
 ┃ ┃ ┗ 📜error.java
 ┃ ┣ 📜Cursor.java
 ┃ ┗ 📜MxStarErrorListener.java
 ┗ 📜PrismCube.java
```
