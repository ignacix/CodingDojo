package domain;

public class Bat extends Mammal{
	
	public Bat() {
		this.setEnergyLevel(200);
	}
	
	public String fly() {
		this.setEnergyLevel(-50);
		return "SOnido de de Bat al despegar*";
	}
	
	public String eatHumans() {
		this.setEnergyLevel(25);
		return "bueno, no importa";
	}
	
	public String attackTown() {
		this.setEnergyLevel(-100);
		return "Sonido de ciudad en llamas*";
	}
}
