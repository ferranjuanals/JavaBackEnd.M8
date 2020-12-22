package com.video.project;

import java.util.Arrays;

public class Coet {
	
	// Atributs de la classe Coet
	private String codi;
	private int propulsors;
	private int[] pMax;
	private static int[] pAct;
	
	// Constructor. Treu excepcions si el codi no t� 8 xifres o el n�mero de propulsors no concorda amb el de pot�ncies
	public Coet(String codi, int propulsors, int[] pMax) throws Exception{
		if(codi.length() != 8) throw new Exception("El codi del coet ha de ser de 8 xifres");
		if(propulsors != pMax.length) throw new Exception("S'ha d'introdu�r una pot�ncia m�xima per a cada propulsor");
		
		this.codi = codi;
		this.propulsors = propulsors;
		this.pMax = pMax;
		
		// Crear array amb pot�ncies actuals a 0
		pAct = new int[propulsors];
	}

	// M�tode per extreure la informaci� del coet
	public void getInfo() {
		System.out.println("El codi del coet �s: " + codi + ". T� " + propulsors + " propulsors amb les seg�ents pot�ncies m�ximes: " + Arrays.toString(pMax));
	}
	
	// M�tode accelerar
	public  void accelerar(int propulsor) {
		// La pot�ncia actual augmentar� fins el valor de pot�ncia m�xima
		while(pAct[propulsor] < pMax[propulsor]) {
			// Augmenta en 1 la pot�ncia del propulsor
			pAct[propulsor]++;
			// Imprimeix la pot�ncia actual
			System.out.println("Coet " + codi + ": " + Arrays.toString(pAct));
			// S'adorm el thread perqu� es vegi l'evoluci� en pantalla
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// M�tode frenar
	public void frenar(int propulsor) {
		// La pot�ncia actual es reduir� fins a 0
		while(pAct[propulsor] > 0) {
			// Es redueix en 1 la pot�ncia del propulsor
			pAct[propulsor]--;
			// Imprimeix la pot�ncia actual
			System.out.println("Coet " + codi + ": " + Arrays.toString(pAct) + "****");
			// S'adorm el thread perqu� es vegi l'evoluci� en pantalla
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
