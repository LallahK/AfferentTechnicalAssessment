# Abdullah Karbanee 

## Afferent Technical Assessment

This project implements an algebraic calculator. The calculator supports the following operations: Addition (+), Subtraction (-), Multiplication (*), Division (-) and Power(^).

The project uses maven to as the build tool to implement the calculator

## Context Free Grammar

The following context free grammar was used to implement the calculator

| Nonterminal   | Rule              |
| ------------- | ----------------- |
| Sum           | Mul Sum'          |
| Sum'          | '+' Mul Sum'      |
|               | '-' Mul Sum'      |
|               | $\epsilon$        |
| Mul           | Pow Mul'          |
| Mul'          | '*' Pow Mul'      |
|               | '/' Pow Mul'      |
|               | $\epsilon$        |
| Pow           | Num Pow'          |
| Pow'          | '^' Num Pow'      |
|               | $\epsilon$        |
| Num           | [0-9]* (\\. [0-9]*)? |

## Running the Calculator

The calculator can be run using the following command:
```
mvn package exec:java
```
Which will then accept strings via stdin as input for the calculator. For example
```
4^3-2
-> 62.0
```
where `-> 62.0` is the output given by the calculator. One can then exit the program using `exit` or `close` as input.