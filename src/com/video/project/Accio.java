package com.video.project;

public class Accio extends Thread {

	private Coet coet;
	private int propulsor;
	private String accio;
	
	// Constructor de clase Accio
	public Accio(Coet coet, int propulsor, String accio) {		
		this.coet = coet;
		this.propulsor = propulsor;
		this.accio = accio;
	}
	
	// Crea un nou thread amb els mètodes d'accelerar o frenar
	@Override
	public void run() {
		if(accio == "accelerar") {
			coet.accelerar(propulsor);
		}else if(accio == "frenar") {
			coet.frenar(propulsor);
		}
	}
	
}
