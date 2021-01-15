package com.video.project;

import java.util.Arrays;

public class Accio extends Thread {

	private String accio;
	private String codi;
	private int propulsor;
	private int[] pFin;
	private int[] pAct;
	
	// Constructor de clase Accio per al mètode accelerar
	public Accio(String codi, int propulsor, int[] pFin, int[] pAct) {
		accio = "accelerar";
		
		this.codi = codi;
		this.propulsor = propulsor;
		this.pFin = pFin;
		this.pAct = pAct;
	}
	
	// Constructor de la clase Accio per al mètode frenar
	public Accio(String codi, int propulsor, int[] pAct) {
		accio = "frenar";
		
		this.codi = codi;
		this.propulsor = propulsor;
		this.pAct = pAct;
	}
	
	// Crea un nou thread amb els mètodes d'accelerar o frenar
	@Override
	public void run() {
		if(accio == "accelerar") {
			// La potència actual augmentarà fins el valor de potència límit
			while(pAct[propulsor] < pFin[propulsor]) {
				// Augmenta en 1 la potència del propulsor
				pAct[propulsor]++;
				// Imprimeix la potència actual
				System.out.println("Coet " + codi + ": " + Arrays.toString(pAct));
				// S'adorm el thread perquè es vegi l'evolució en pantalla
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else if(accio == "frenar") {
			// La potència actual es reduirà fins a 0
			while(pAct[propulsor] > 0) {
				// Es redueix en 1 la potència del propulsor
				pAct[propulsor]--;
				// Imprimeix la potència actual
				System.out.println("Coet " + codi + ": " + Arrays.toString(pAct));
				// S'adorm el thread perquè es vegi l'evolució en pantalla
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
