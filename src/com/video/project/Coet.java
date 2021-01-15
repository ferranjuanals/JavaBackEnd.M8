package com.video.project;

import java.util.Arrays;

public class Coet {
	
	// Atributs de la classe Coet
	private String codi;
	private int propulsors;
	private int[] pMax;
	private int[] pAct;
	private int pT;
	
	// Constructor. Treu excepcions si el codi no té 8 xifres o el número de propulsors no concorda amb el de potències
	public Coet(String codi, int propulsors, int[] pMax) throws Exception {
		if(codi.length() != 8) throw new Exception("El codi del coet ha de ser de 8 xifres");
		if(propulsors != pMax.length) throw new Exception("S'ha d'introduïr una potència màxima per a cada propulsor");
		
		this.codi = codi;
		this.propulsors = propulsors;
		// Ordenar les potències màximes dels propulsors en ordre ascendent
		Arrays.sort(pMax);
		this.pMax = pMax;
		
		// Crear array amb potències actuals a 0
		pAct = new int[propulsors];
		pT = Arrays.stream(pMax).sum();
	}

	// Mètode per extreure la informació del coet
	public void getInfo() {
		System.out.println("El codi del coet és: " + codi + ". Té " + propulsors + " propulsors amb les següents potències màximes: " + Arrays.toString(pMax));
	}
	
	// Mètode per accelerar un propulsor
	public void accelerar(int propulsor) {		
		// Crear instància de la classe Accio amb un nou thread per accelerar el propulsor
		Accio thread = new Accio(codi, propulsor, pMax, pAct);
		thread.start();
	}
	
	// Mètode per accelerar tots els propulsors d'un coet per augmentar des de la velocitat incial a la indicada
	public void augmentarVelocitat(int v0, int v) {
		// Calcular la potència necessària
		double pN = Math.pow(((v - v0) / 100.0), 2);
		// Informar per pantalla en cas que la potència total sigui insuficient
		if(pN > pT) {
			// Calcular la velocitat màxima 
			double nv = v0 + (100 * Math.sqrt(pT));
			// Imprimir la informació de la velocitat màxima
			System.out.println("El coet " + codi + " no pot accelarar fins la velocitat indicada per falta de potència.");
			System.out.print("Partint d'una velocitat inicial de " + v0 + ", la velocitat màxima a la que pot arribar el coet " + codi + " és: ");
			System.out.printf("%.0f%n", nv);
			return;
		}
		// Crear Array buit per guardar la potència necessària de cada propulsor
		int[] pLim = new int[propulsors];
		// Guardar la potència restant a repartir entre els propulsors
		int pR = (int) pN;
		// Guardar el nombre de propulsors restants
		int propulsorsRes = propulsors;
		// 
		for(int i=0; propulsorsRes > 0; i++) {
			// Calcular i guardar la potència necessària per cada propulsor arrodonint a l'alça
			int pNP = (pR + propulsorsRes - 1) / propulsorsRes;
			// Si la potència necessària és major a la potència màxima del propulsor
			if(pNP > pMax[i]) {
				// Utilitzar la potència màxima
				pLim[i] = pMax[i];
				// Restar la potència utilitzada a la potència restant
				pR -= pMax[i];
				// Reduïr en un el nombre de propulsors restants
				propulsorsRes--;
			// La potència necessària és menor a la potència màxima del propulsor
			} else {
				// Utilitzar la potència necessària
				pLim[i] = pNP;
				// Restar la potència utilitzada a la potència restant
				pR -= pNP;
				// Reduïr en un el nombre de propulsors restants
				propulsorsRes--;
			}
			// Crear instància de la classe Accio amb un nou thread per accelerar el propulsor
			Accio thread = new Accio(codi, i, pLim, pAct);
			thread.start();
		}
	}
	
	// Mètode per frenar un propulsor
	public void frenar(int propulsor) {		
		// Crear instància de la classe Accio amb un nou thread per frenar el propulsor
		Accio thread = new Accio(codi, propulsor, pAct);
		thread.start();
	}
	
}
