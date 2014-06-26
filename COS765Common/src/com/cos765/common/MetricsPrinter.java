package com.cos765.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

import com.cos765.common.Common.Metrics;

public class MetricsPrinter implements Runnable {

	private String filename;
	private PrintWriter writer;

	@SuppressWarnings("deprecation")
	public MetricsPrinter(int bufferSize, long RTT, double p, double E_x) {
		this.filename = "buffer=" + Integer.toString(bufferSize) + "_RTT=" + Long.toString(RTT) + "_p=" + Double.toString(p) + "_Ex=" + Double.toString(E_x) + "_" 
				+ (new Date().getMonth()) + "_"  + (new Date().getDay()) + "_" + (new Date().getHours()) + "_" + (new Date().getMinutes()) + ".txt";
		
		try {
			this.writer = new PrintWriter(new File(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		while (true) {
			try {
				Thread.sleep(5000);
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
					+ (Metrics.expiredSegments + Metrics.lostSegments + Metrics.discardedSegments)*1.0/Metrics.receivedSegments);
			
			System.out.println("Tempo total parado: " + Metrics.totalPauseTime + 
					" #pausas: " + Metrics.pauseCount + 
					" Tempo médio pausado: " + Metrics.totalPauseTime/Metrics.pauseCount + " ms.");
			
			System.out.println("Total recebido (bytes): " + Metrics.totalTransferSize + 
					" Tempo total: " + Metrics.totalTransferTime + 
					" Vazão: " + Metrics.throughput + " bps");
			
			System.out.println("");
			
			
			
			writer.println("seg RECEBIDOS/TOCADOS/EXPIRADOS/PERDIDOS/DESCARTADOS/FRAÇÃO DE NÃO TOCADOS: " 
					+ Metrics.receivedSegments + "/" 
					+ Metrics.playedSegments + "/" 					
					+ Metrics.expiredSegments + "/" 
					+ Metrics.lostSegments + "/" 
					+ Metrics.discardedSegments + "/"
					+ (Metrics.expiredSegments + Metrics.lostSegments + Metrics.discardedSegments)*1.0/Metrics.receivedSegments);
			
			writer.println("Tempo total parado: " + Metrics.totalPauseTime + 
					" #pausas: " + Metrics.pauseCount + 
					" Tempo médio pausado: " + Metrics.totalPauseTime/Metrics.pauseCount + " ms.");
			
			writer.println("Total recebido (bytes): " + Metrics.totalTransferSize + 
					" Tempo total: " + Metrics.totalTransferTime + 
					" Vazão: " + Metrics.throughput + " bps");
			
			writer.flush();
			
		}
	}	
	
}
