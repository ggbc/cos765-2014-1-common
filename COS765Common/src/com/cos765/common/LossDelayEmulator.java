package com.cos765.common;


public class LossDelayEmulator {

	public static Segment doEmulate (Segment segment) {
		Segment pSegment = loseByChance(segment);
		
		return delay(segment);
	}
		
	private static Segment delay (Segment segment) {
		// Capturar o tempo atual
		// Atrasar de RTT/2 + X
		// Retornar o Segmento		
		return segment;
	}
	
	private static Segment loseByChance (Segment segment) {
		// Decidir se um segmento � perdido ou n�o
		return segment;
	}

}
