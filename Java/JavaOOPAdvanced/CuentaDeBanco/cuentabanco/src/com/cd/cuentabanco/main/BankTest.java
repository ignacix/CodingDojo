package com.cd.cuentabanco.main;
import com.cd.cuentabanco.domain.BankAccount;

public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount cuenta1 = new BankAccount();
		BankAccount cuenta2 = new BankAccount();
		System.out.println(cuenta1.RetirarCuentaAhorros(5));
		System.out.println(cuenta2.verSaldos());
		System.out.println(cuenta1.verSaldos());
		
		System.out.println(BankAccount.cuentasCreadas);
	}

}
