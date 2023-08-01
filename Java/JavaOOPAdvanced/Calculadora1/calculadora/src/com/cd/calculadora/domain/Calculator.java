package com.cd.calculadora.domain;

public class Calculator {

	private double operandOne;
	private char operation;
	private double operandTwo;
	private double result;
	
	public Calculator() {
		
	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public char getOperation() {
		return operation;
	}
	public double getResult() {
		return result;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	public void seResult(double result) {
		this.result = result;
	}
	
	public void performOperation() {
		
		if(this.operation == '+') {
			this.result = this.operandOne + this.operandTwo;			
		}else {
			this.result = this.operandOne - this.operandTwo;
		}		
	}
	
}
