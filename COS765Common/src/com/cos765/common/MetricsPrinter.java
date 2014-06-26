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
			// Contagem das estatísticas
			System.out.println("");
			System.out.println("seg RECEBIDOS/TOCADOS/EXPIRADOS/PERDIDOS/DESCARTADOS/FRAÇÃO DE NÃO TOCADOS: " 
					+ Metrics.receivedSegments + "/" 
					+ Metrics.playedSegments + "/" 					
					+ Metrics.expiredSegments + "/" 
					+ Metrics.lostSegments + "/" 
					+ Metrics.discardedSegments + "/"
					+ (Metrics.expiredSegments + Metrics.lostSegments + Metrics.discardedSegments)/Metrics.receivedSegments);
			
			System.out.println("Tempo total parado: " + Metrics.totalPauseTime + 
					" #pausas: " + Metrics.pauseCount + 
					" Tempo médio pausado: " + Metrics.totalPauseTime/Metrics.pauseCount + " ms.");
			
			System.out.println("Total recebido (bytes): " + Metrics.totalTransferSize + 
					" Tempo total: " + Metrics.totalTransferTime + 
					" Vazão: " + Metrics.throughput + " bps");
			
			System.out.println("");			
		}
	}	
	
}
