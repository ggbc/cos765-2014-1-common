package com.cos765.common;

import java.util.Random;

public class LossDelayEmulator {

	public static Segment doEmulate (Segment segment) {
		Segment pSegment = delay(segment);
		return loseByChance(pSegment);
	}
		
	private static Segment delay (Segment segment) {
		// Capturar o tempo atual
		// Atrasar de RTT/2 + X
		// Retornar o Segmento
		segment.setTime(segment.getTime() + 20); // TESTE: + 20 tem que virar +  (RTT/2  + X)
		return segment;
	}
	
	private static Segment loseByChance (Segment segment) {
		// Decidir a partir de "p" se um segmento � perdido ou n�o
		return segment;
	}

}
