package com.video.project;

import java.util.Arrays;

public class Accio extends Thread {

	private String accio;
	private String codi;
	private int propulsor;
	private int[] pFin;
	private int[] pAct;
	
	// Constructor de clase Accio per al m�tode accelerar
	public Accio(String codi, int propulsor, int[] pFin, int[] pAct) {
		accio = "accelerar";
		
		this.codi = codi;
		this.propulsor = propulsor;
		this.pFin = pFin;
		this.pAct = pAct;
	}
	
	// Constructor de la clase Accio per al m�tode frenar
	public Accio(String codi, int propulsor, int[] pAct) {
		accio = "frenar";
		
		this.codi = codi;
		this.propulsor = propulsor;
		this.pAct = pAct;
	}
	
	// Crea un nou thread amb els m�todes d'accelerar o frenar
	@Override
	public void run() {
		if(accio == "accelerar") {
			// La pot�ncia actual augmentar� fins el valor de pot�ncia l�mit
			while(pAct[propulsor] < pFin[propulsor]) {
				// Augmenta en 1 la pot�ncia del propulsor
				pAct[propulsor]++;
				// Imprimeix la pot�ncia actual
				System.out.println("Coet " + codi + ": " + Arrays.toString(pAct));
				// S'adorm el thread perqu� es vegi l'evoluci� en pantalla
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else if(accio == "frenar") {
			// La pot�ncia actual es reduir� fins a 0
			while(pAct[propulsor] > 0) {
				// Es redueix en 1 la pot�ncia del propulsor
				pAct[propulsor]--;
				// Imprimeix la pot�ncia actual
				System.out.println("Coet " + codi + ": " + Arrays.toString(pAct));
				// S'adorm el thread perqu� es vegi l'evoluci� en pantalla
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
