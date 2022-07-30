package com.hashnet.temp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Magic_Numbers {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String[] range = in.readLine().split("\\s+");
		int a = Integer.parseInt(range[0]);
		int b = Integer.parseInt(range[1]);
		
		for(int i=a; i<=b; i++) {
			System.out.println(isMagic(i) ? i : -1);
		}
	}
	
	private static boolean isMagic(int num) {
		return true;
	}
}