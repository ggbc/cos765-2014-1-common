package com.cos765.common;

public class Segment implements Comparable<Segment> {
	private byte order;
	private byte[] payload;
	private long time;	
	
	public Segment(byte order, byte[] payload, long time) {
		this.setOrder(order);
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

	public byte getOrder() {
		return order;
	}

	public void setOrder(byte order) {
		this.order = order;
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
}
