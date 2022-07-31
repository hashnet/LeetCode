package com.hashnet.temp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Graph_Degree {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
//		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		InputStreamReader reader = new InputStreamReader(new FileInputStream("src/inputs/degrees.txt"), StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		String line;
		while ((line = in.readLine()) != null) {
			int count = 0; // holds the number of incident edges of a node.

			for (int i = 0; i < line.length(); i+=2) {	//i+=2 to skip the space inbetween
				count = count + line.charAt(i) - '0';
			}
			
			min = Math.min(min, count);
			max = Math.max(max, count);
			
			if (min == 0 && max == ((line.length()+1) / 2)) {
				break;
			}
		}
		
		System.out.println(min + " " + max);
	}
}