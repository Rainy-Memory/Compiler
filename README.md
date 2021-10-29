# PrismCube

A toy Mx* compiler with java implementation.

![](https://img.shields.io/badge/version-1.0.0-green.svg)
[![](https://img.shields.io/badge/source_language-Mx*-yellow.svg)](https://github.com/ACMClassCourses/Compiler-Design-Implementation)
![](https://img.shields.io/github/last-commit/Rainy-Memory/Compiler)

![](https://img.shields.io/github/languages/top/Rainy-Memory/Compiler)
![](https://img.shields.io/github/languages/code-size/Rainy-Memory/Compiler)
![](https://img.shields.io/github/repo-size/Rainy-Memory/Compiler)

## Mx* Language

Mx* is a simplified language from the mix of Standard C++ and Java. Details of Mx* can be found [here](https://github.com/ACMClassCourses/Compiler-Design-Implementation).

## Progress

 - [x] g4
 - [x] ASTBuilder
 - [x] ASTPrinter (inspired by [Masterball](https://github.com/SiriusNEO/Masterball))
 - [x] SymbolCollector
 - [ ] ScopePrinter  **working...**
 - [ ] SemanticChecker

## File Structure

```
📦src
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
 ┃ ┃ ┣ 📜AtomExpressionNode.java
 ┃ ┃ ┣ 📜BinaryExpressionNode.java
 ┃ ┃ ┣ 📜ExpressionNode.java
 ┃ ┃ ┣ 📜FunctionCallExpressionNode.java
 ┃ ┃ ┣ 📜LambdaExpressionNode.java
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
 ┣ 📂Debug
 ┃ ┣ 📜ASTPrinter.java
 ┃ ┣ 📜MemoLog.java
 ┃ ┗ 📜ScopePrinter.java
 ┣ 📂FrontEnd
 ┃ ┣ 📜ASTBuilder.java
 ┃ ┣ 📜Memory.java
 ┃ ┣ 📜Preprocessor.java
 ┃ ┣ 📜SemanticChecker.java
 ┃ ┗ 📜SymbolCollector.java
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
 ┃ ┃ ┣ 📜ClassEntity.java
 ┃ ┃ ┣ 📜ConstructorEntity.java
 ┃ ┃ ┣ 📜Entity.java
 ┃ ┃ ┣ 📜FunctionEntity.java
 ┃ ┃ ┗ 📜VariableEntity.java
 ┃ ┣ 📂error
 ┃ ┃ ┣ 📜error.java
 ┃ ┃ ┣ 📜InternalError.java
 ┃ ┃ ┣ 📜LogError.java
 ┃ ┃ ┣ 📜SemanticError.java
 ┃ ┃ ┗ 📜SyntaxError.java
 ┃ ┣ 📂Scope
 ┃ ┃ ┣ 📜ClassScope.java
 ┃ ┃ ┣ 📜ConstructorScope.java
 ┃ ┃ ┣ 📜FunctionScope.java
 ┃ ┃ ┣ 📜GlobalScope.java
 ┃ ┃ ┗ 📜Scope.java
 ┃ ┣ 📂Type
 ┃ ┃ ┣ 📜ArrayType.java
 ┃ ┃ ┣ 📜ClassType.java
 ┃ ┃ ┗ 📜Type.java
 ┃ ┣ 📜Cursor.java
 ┃ ┗ 📜MxStarErrorListener.java
 ┗ 📜PrismCube.java
```
