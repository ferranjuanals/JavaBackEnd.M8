package com.video.project;

import java.util.Arrays;

public class Coet {
	
	// Atributs de la classe Coet
	private String codi;
	private int propulsors;
	private int[] potencies;
	
	// Constructor. Treu excepcions si el codi no té 8 xifres o el número de propulsors no concorda amb el de potències
	public Coet(String codi, int propulsors, int[] potencies) throws Exception{
		if(codi.length() != 8) throw new Exception("El codi del coet ha de ser de 8 xifres");
		if(propulsors != potencies.length) throw new Exception("S'ha d'introduïr una potència màxima per a cada propulsor");
		
		this.codi = codi;
		this.propulsors = propulsors;
		this.potencies = potencies;
	}

	// Mètode per extreure la informació del coet
	public void getInfo() {
		System.out.println("El codi del coet és: " + codi + ". Té " + propulsors + " propulsors amb les següents potències màximes: " + Arrays.toString(potencies));
	}
}
