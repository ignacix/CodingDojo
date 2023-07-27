package domain;

public class Gorilla extends Mammal{
	public Gorilla() {
		
	}
	
	public String throwSomething() {
		this.setEnergyLevel(-5);;
		return "El gorilla ha lanzado algo";
	}
	
	public String eatBananas() {
		this.setEnergyLevel(10);
		return "El mono está feliz";
	}
	
	public String climb(){
		this.setEnergyLevel(-10);
		return "El mono ha trepado a la cima de un arbol";
	}
}
