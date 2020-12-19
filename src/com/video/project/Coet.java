package com.video.project;

public class Coet {
	
	private String codi;
	private int propulsors;
	
	public Coet(String codi, int propulsors) {
		this.codi = codi;
		this.propulsors = propulsors;
	}

	public void getInfo() {
		System.out.println("El codi del coet és: " + codi + ". Té " + propulsors + " propulsors");
	}
}
