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
			System.out.println("seg RECEBIDOS/TOCADOS/EXPIRADOS/PERDIDOS/DESCARTADOS: " 
					+ Statistics.receivedSegments + "/" 
					+ Statistics.playedSegments + "/" 					
					+ Statistics.expiredSegments + "/" 
					+ Statistics.lostSegments + "/" 
					+ Statistics.discardedSegments);	
		}
	}	
	
}
