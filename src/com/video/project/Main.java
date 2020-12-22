package com.video.project;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// Es creen dos coets
		Coet coet1 = new Coet("32WESSDS", 3, new int[] {10, 30, 80});
		Coet coet2 = new Coet("LDSFJA32", 6, new int[] {30, 40, 50, 50, 30, 10});
		
		// Es mostra la informació
		coet1.getInfo();
		coet2.getInfo();
		
		// Accelerem els propulsors del coet2 en diferents threads
		Accio thread0 = new Accio(coet2, 3, "accelerar");
		thread0.start();
		Accio thread1 = new Accio(coet2, 2, "accelerar");
		thread1.start();		
		Accio thread2 = new Accio(coet2, 1, "accelerar");
		thread2.start();		
		Accio thread3 = new Accio(coet2, 4, "accelerar");
		thread3.start();		
		Accio thread4 = new Accio(coet2, 0, "accelerar");
		thread4.start();		
		Accio thread5 = new Accio(coet2, 5, "accelerar");
		thread5.start();
	}

}
