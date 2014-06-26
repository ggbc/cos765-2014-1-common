package com.cos765.common;

public class Common {

	public static final int SERVER_PORT = 15000;
	public static final int TRANSMISSION_TIME = 20;
	public static Boolean bufferFull = false;	
	public static int maxBufferSize = 10;
	
	
	public static class Statistics {
		// Statistics
		public static int expiredSegments = 0;
		public static int lostSegments = 0;
		public static long initialTransferTime = 0;
		public static long totalTransferTime = 0;
		public static int totalTransferSize = 0;		
		public static double throughput = 0.0;
		public static int pauseCount = 0;
		public static long pauseStartTime = 0;
		public static long pauseEndTime = 0;
		public static long totalPauseTime = 0;
	}	
}
