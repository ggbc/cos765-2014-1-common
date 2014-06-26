package com.cos765.common;

import com.cos765.common.Common.Metrics;

public class MetricsPrinter implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Contagem das estat�sticas
			System.out.println("");
			System.out.println("seg RECEBIDOS/TOCADOS/EXPIRADOS/PERDIDOS/DESCARTADOS/FRA��O DE N�O TOCADOS: " 
					+ Metrics.receivedSegments + "/" 
					+ Metrics.playedSegments + "/" 					
					+ Metrics.expiredSegments + "/" 
					+ Metrics.lostSegments + "/" 
					+ Metrics.discardedSegments + "/"
					+ (Metrics.expiredSegments + Metrics.lostSegments + Metrics.discardedSegments)/Metrics.receivedSegments);
			
			System.out.println("Tempo total parado: " + Metrics.totalPauseTime + 
					" #pausas: " + Metrics.pauseCount + 
					" Tempo m�dio pausado: " + Metrics.totalPauseTime/Metrics.pauseCount + " ms.");
			
			System.out.println("Total recebido (bytes): " + Metrics.totalTransferSize + 
					" Tempo total: " + Metrics.totalTransferTime + 
					" Vaz�o: " + Metrics.throughput + " bps");
			
			System.out.println("");			
		}
	}	
	
}
