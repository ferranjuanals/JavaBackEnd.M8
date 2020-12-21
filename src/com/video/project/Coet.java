package com.video.project;

import java.util.Arrays;

public class Coet {
	
	// Atributs de la classe Coet
	private String codi;
	private int propulsors;
	private int[] potencies;
	
	// Constructor. Treu excepcions si el codi no t� 8 xifres o el n�mero de propulsors no concorda amb el de pot�ncies
	public Coet(String codi, int propulsors, int[] potencies) throws Exception{
		if(codi.length() != 8) throw new Exception("El codi del coet ha de ser de 8 xifres");
		if(propulsors != potencies.length) throw new Exception("S'ha d'introdu�r una pot�ncia m�xima per a cada propulsor");
		
		this.codi = codi;
		this.propulsors = propulsors;
		this.potencies = potencies;
	}

	// M�tode per extreure la informaci� del coet
	public void getInfo() {
		System.out.println("El codi del coet �s: " + codi + ". T� " + propulsors + " propulsors amb les seg�ents pot�ncies m�ximes: " + Arrays.toString(potencies));
	}
}
