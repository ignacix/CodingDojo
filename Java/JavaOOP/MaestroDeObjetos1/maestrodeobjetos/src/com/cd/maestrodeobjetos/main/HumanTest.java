package com.cd.maestrodeobjetos.main;
import com.cd.maestrodeobjetos.domain.Wizard;
import com.cd.maestrodeobjetos.domain.Ninja;
public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Wizard mago = new Wizard();
		Ninja ninja = new Ninja();
		
		System.out.println(ninja.getHealth());
		mago.attack(ninja);
		System.out.println(ninja.getHealth());
		
		
		
		
	}

}
