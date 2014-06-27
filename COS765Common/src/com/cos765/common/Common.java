package com.cos765.common;

public class Common {

	public static final int SERVER_PORT = 15000;
	public static final int SLEEP_TIME = 20;
	public static Boolean bufferFull = false;	
	public static int maxBufferSize = 10;
	public static boolean returnedFromPause = false;
	
	
	public static class Metrics {
		// Statistics
		public static int receivedByUDPSegments = 0; // recebidos na camada UDP
		public static int receivedByBufferSegments= 0; // recebidos na camada UDP
		public static int expiredSegments = 0; // ficaram fora de ordem após atraso
		public static int lostSegments = 0; // peridos pela probabilidade p
		public static int discardedSegments = 0; // buffer estava cheio, então foram descartados
		public static int playedSegments = 0; 		
		public static long initialTransferTime = 0;
		public static long totalTransferTime = 0;
		public static int totalTransferSize = 0;		
		public static double throughput = 0.0;
		public static int pauseCount = 1;
		public static long pauseStartTime = 0;
		public static long pauseEndTime = 0;
		public static long totalPauseTime = 0;
	}	
}
