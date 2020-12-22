package com.video.project;

import java.util.Arrays;

public class Coet {
	
	// Atributs de la classe Coet
	private String codi;
	private int propulsors;
	private int[] pMax;
	private static int[] pAct;
	
	// Constructor. Treu excepcions si el codi no té 8 xifres o el número de propulsors no concorda amb el de potències
	public Coet(String codi, int propulsors, int[] pMax) throws Exception{
		if(codi.length() != 8) throw new Exception("El codi del coet ha de ser de 8 xifres");
		if(propulsors != pMax.length) throw new Exception("S'ha d'introduïr una potència màxima per a cada propulsor");
		
		this.codi = codi;
		this.propulsors = propulsors;
		this.pMax = pMax;
		
		// Crear array amb potències actuals a 0
		pAct = new int[propulsors];
	}

	// Mètode per extreure la informació del coet
	public void getInfo() {
		System.out.println("El codi del coet és: " + codi + ". Té " + propulsors + " propulsors amb les següents potències màximes: " + Arrays.toString(pMax));
	}
	
	// Mètode accelerar
	public  void accelerar(int propulsor) {
		// La potència actual augmentarà fins el valor de potència màxima
		while(pAct[propulsor] < pMax[propulsor]) {
			// Augmenta en 1 la potència del propulsor
			pAct[propulsor]++;
			// Imprimeix la potència actual
			System.out.println("Coet " + codi + ": " + Arrays.toString(pAct));
			// S'adorm el thread perquè es vegi l'evolució en pantalla
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// Mètode frenar
	public void frenar(int propulsor) {
		// La potència actual es reduirà fins a 0
		while(pAct[propulsor] > 0) {
			// Es redueix en 1 la potència del propulsor
			pAct[propulsor]--;
			// Imprimeix la potència actual
			System.out.println("Coet " + codi + ": " + Arrays.toString(pAct) + "****");
			// S'adorm el thread perquè es vegi l'evolució en pantalla
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
