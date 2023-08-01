package com.cd.calculadora.main;

import com.cd.calculadora.domain.Calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator  calculadora = new Calculator();
		calculadora.setOperandOne(10.5);
		calculadora.setOperandTwo(5.2);;
		calculadora.setOperation('+');
		calculadora.performOperation();
		System.out.println(calculadora.getResult());
		
	}

}
