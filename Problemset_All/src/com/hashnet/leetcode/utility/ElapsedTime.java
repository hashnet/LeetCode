package com.hashnet.leetcode.utility;

public class ElapsedTime {
	private static ElapsedTime instance = null;
	private ElapsedTime() {}
	private long start = 0;
	private long end = 0;
	
	public static ElapsedTime getInstance() {
		if(instance == null) instance = new ElapsedTime();
		
		return instance;
	}
	
	public void start() {
		start = System.nanoTime();
	}
	
	public void stop() {
		end = System.nanoTime();
	}
	
	public String getElapsed() {
		long elapsed = end - start;
		long seconds = elapsed / 1_000_000_000;
		elapsed %= 1_000_000_000;
		long millis = elapsed / 1_000_000;
		elapsed %= 1_000_000;
		long micros = elapsed / 1_000;
		elapsed %= 1_000;
		long nanos = elapsed;
		
		return String.format("[Seconds: %3d, Millis: %3d, Micros: %3d, Nanos: %3d]", seconds, millis, micros, nanos);

	}
	public void printElapsed() {
		System.out.println(getElapsed());
	}
}
