package com.cos765.common;

public class Segment implements Comparable<Segment> {
	private int sequenceNumber;
	private byte[] payload;
	private long time;	
	public static final int PAYLOAD_SIZE = 160; 	// usado em outras classes
	public static final int HEADER_SIZE = 4;		// usado em outras classes

	
	public Segment(int sequenceNumber, byte[] payload, long time) {
		this.setSequenceNumber(sequenceNumber);
		this.setPayload(payload);
		this.setTime(time);
	}	
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public byte[] getPayload() {
		return payload;
	}

	public void setPayload(byte[] payload) {
		this.payload = payload;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	@Override
	public int compareTo(Segment o) {
		if (this.time > o.time) {
			return 1;
		} else if (this.time == o.time) {
			return 0;
		} else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return "{" + getSequenceNumber() + ":" + getTime() + "}";		
	}
}
