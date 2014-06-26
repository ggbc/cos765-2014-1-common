package com.cos765.common;

import com.cos765.common.Common.Statistics;

public class StatisticsPrinter implements Runnable {

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
			System.out.println("seg RECEBIDOS/TOCADOS/EXPIRADOS/PERDIDOS/DESCARTADOS: " 
					+ Statistics.receivedSegments + "/" 
					+ Statistics.playedSegments + "/" 					
					+ Statistics.expiredSegments + "/" 
					+ Statistics.lostSegments + "/" 
					+ Statistics.discardedSegments);
			
			System.out.println("Tempo total parado: " + Statistics.totalPauseTime + 
					" #pausas: " + Statistics.pauseCount + 
					" Tempo médio pausado: " + Statistics.totalPauseTime/Statistics.pauseCount + " ms.");
			
			System.out.println("Total recebido (bytes): " + Statistics.totalTransferSize + 
					" Tempo total: " + Statistics.totalTransferTime + 
					" Vazão: " + Statistics.throughput + " bps");
			
			System.out.println("");			
		}
	}	
	
}
