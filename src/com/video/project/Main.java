package com.video.project;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// Es creen dos coets
		Coet coet1 = new Coet("32WESSDS", 3, new int[] {10, 30, 80});
		Coet coet2 = new Coet("LDSFJA32", 6, new int[] {30, 40, 50, 50, 30, 10});
		
		// Es mostra la informació
		coet1.getInfo();
		coet2.getInfo();
		
		coet1.augmentarVelocitat(12, 1120);
		coet2.augmentarVelocitat(12, 1120);
		

	}

}
