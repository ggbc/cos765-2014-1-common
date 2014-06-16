package com.cos765.common;

public class Segment {
	private byte order;
	private byte[] payload;
	private long timestamp;

	public Segment(byte order, byte[] payload, long timestamp)
	{
		this.order = order;
		this.payload = payload;
		this.timestamp = timestamp;
	}
	
	public byte getOrder() {
		return order;
	}

	public void setOrder(byte order) {
		this.order = order;
	}

	public byte[] getPayload() {
		return payload;
	}

	public void setPayload(byte[] payload) {
		this.payload = payload;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
