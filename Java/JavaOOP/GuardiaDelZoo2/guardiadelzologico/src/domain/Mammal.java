package domain;

public class Mammal {
	private int energyLevel;
	
	
	public int getEnergyLevel() {
		return this.energyLevel;
	}
	public void setEnergyLevel(int energy) {
		this.energyLevel += energy;
	}
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public String displayEnergy() {
		return  String .valueOf(this.energyLevel);
	}
}
