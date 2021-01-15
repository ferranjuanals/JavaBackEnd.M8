package com.video.project;

import java.util.Arrays;

public class Coet {
	
	// Atributs de la classe Coet
	private String codi;
	private int propulsors;
	private int[] pMax;
	private int[] pAct;
	private int pT;
	
	// Constructor. Treu excepcions si el codi no t� 8 xifres o el n�mero de propulsors no concorda amb el de pot�ncies
	public Coet(String codi, int propulsors, int[] pMax) throws Exception {
		if(codi.length() != 8) throw new Exception("El codi del coet ha de ser de 8 xifres");
		if(propulsors != pMax.length) throw new Exception("S'ha d'introdu�r una pot�ncia m�xima per a cada propulsor");
		
		this.codi = codi;
		this.propulsors = propulsors;
		// Ordenar les pot�ncies m�ximes dels propulsors en ordre ascendent
		Arrays.sort(pMax);
		this.pMax = pMax;
		
		// Crear array amb pot�ncies actuals a 0
		pAct = new int[propulsors];
		pT = Arrays.stream(pMax).sum();
	}

	// M�tode per extreure la informaci� del coet
	public void getInfo() {
		System.out.println("El codi del coet �s: " + codi + ". T� " + propulsors + " propulsors amb les seg�ents pot�ncies m�ximes: " + Arrays.toString(pMax));
	}
	
	// M�tode per accelerar un propulsor
	public void accelerar(int propulsor) {		
		// Crear inst�ncia de la classe Accio amb un nou thread per accelerar el propulsor
		Accio thread = new Accio(codi, propulsor, pMax, pAct);
		thread.start();
	}
	
	// M�tode per accelerar tots els propulsors d'un coet per augmentar des de la velocitat incial a la indicada
	public void augmentarVelocitat(int v0, int v) {
		// Calcular la pot�ncia necess�ria
		double pN = Math.pow(((v - v0) / 100.0), 2);
		// Informar per pantalla en cas que la pot�ncia total sigui insuficient
		if(pN > pT) {
			// Calcular la velocitat m�xima 
			double nv = v0 + (100 * Math.sqrt(pT));
			// Imprimir la informaci� de la velocitat m�xima
			System.out.println("El coet " + codi + " no pot accelarar fins la velocitat indicada per falta de pot�ncia.");
			System.out.print("Partint d'una velocitat inicial de " + v0 + ", la velocitat m�xima a la que pot arribar el coet " + codi + " �s: ");
			System.out.printf("%.0f%n", nv);
			return;
		}
		// Crear Array buit per guardar la pot�ncia necess�ria de cada propulsor
		int[] pLim = new int[propulsors];
		// Guardar la pot�ncia restant a repartir entre els propulsors
		int pR = (int) pN;
		// Guardar el nombre de propulsors restants
		int propulsorsRes = propulsors;
		// 
		for(int i=0; propulsorsRes > 0; i++) {
			// Calcular i guardar la pot�ncia necess�ria per cada propulsor arrodonint a l'al�a
			int pNP = (pR + propulsorsRes - 1) / propulsorsRes;
			// Si la pot�ncia necess�ria �s major a la pot�ncia m�xima del propulsor
			if(pNP > pMax[i]) {
				// Utilitzar la pot�ncia m�xima
				pLim[i] = pMax[i];
				// Restar la pot�ncia utilitzada a la pot�ncia restant
				pR -= pMax[i];
				// Redu�r en un el nombre de propulsors restants
				propulsorsRes--;
			// La pot�ncia necess�ria �s menor a la pot�ncia m�xima del propulsor
			} else {
				// Utilitzar la pot�ncia necess�ria
				pLim[i] = pNP;
				// Restar la pot�ncia utilitzada a la pot�ncia restant
				pR -= pNP;
				// Redu�r en un el nombre de propulsors restants
				propulsorsRes--;
			}
			// Crear inst�ncia de la classe Accio amb un nou thread per accelerar el propulsor
			Accio thread = new Accio(codi, i, pLim, pAct);
			thread.start();
		}
	}
	
	// M�tode per frenar un propulsor
	public void frenar(int propulsor) {		
		// Crear inst�ncia de la classe Accio amb un nou thread per frenar el propulsor
		Accio thread = new Accio(codi, propulsor, pAct);
		thread.start();
	}
	
}
