package com.cd.cuentabanco.domain;

public class BankAccount {
	private String numCuenta;
	private double saldoCuentaCorriente;
	private double saldoCuentaAhorros;
	
	public static int cuentasCreadas=0;
	
	public static double dineroAlmacenado = 0;
	
	public double getSaldoCuentaCorriente() {
		return this.saldoCuentaCorriente;
	}
	
	public double getSaldoCuentaAhorro() {
		return this.saldoCuentaAhorros;
	}
	
	public void depositoCuentaCorriente(double deposito) {
		dineroAlmacenado += deposito;
		this.saldoCuentaCorriente += deposito;
	}
	
	public void depositoCuentaAhorro(double deposito) {
		dineroAlmacenado += deposito;
		this.saldoCuentaAhorros += deposito;
	}
	
	
	public String RetirarCuentaCorriente(double extraccion) {
		
		if(this.saldoCuentaCorriente-extraccion >0) {
			this.saldoCuentaCorriente-=extraccion;
			return "Su extracción fue exitosa";
		}else {
			return "No tiene saldo suficiente en su cuenta";
		}
	}
	
	public String RetirarCuentaAhorros(double extraccion) {
		
		if(this.saldoCuentaAhorros-extraccion>0) {
			this.saldoCuentaAhorros-= extraccion;
			return "Su extracción fue exitosa";
		}else {
			return "No tiene saldo suficiente en su cuenta";
		}
	}
	
	
	private String numRandom() {
		String result = "";
		for(int x=0; x<10; x++) {
			double flotante = Math.random()*9+1;
			int entero = (int)flotante;
			result = result.concat(String.valueOf(entero));
		}
		return result;
	}
	
	public String verSaldos() {
		return String.format("N° Cuenta:%s   %,.2f   %,.2f",  this.numCuenta, this.saldoCuentaAhorros, this.saldoCuentaCorriente);
	}
	
	public BankAccount() {
		cuentasCreadas++;
		this.numCuenta=this.numRandom();
	}

}
