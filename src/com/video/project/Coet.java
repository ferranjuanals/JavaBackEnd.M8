package com.video.project;

import java.util.Arrays;

public class Coet {
	
	private String codi;
	private int propulsors;
	private int[] potencies;
	
	public Coet(String codi, int propulsors, int[] potencies) throws Exception{
		if(codi.length() != 8) throw new Exception("El codi del coet ha de ser de 8 xifres");
		if(propulsors != potencies.length) throw new Exception("S'ha d'introdu�r una pot�ncia m�xima per a cada propulsor");
		
		this.codi = codi;
		this.propulsors = propulsors;
		this.potencies = potencies;
	}

	public void getInfo() {
		System.out.println("El codi del coet �s: " + codi + ". T� " + propulsors + " propulsors amb les seg�ents pot�ncies m�ximes: " + Arrays.toString(potencies));
	}
}
