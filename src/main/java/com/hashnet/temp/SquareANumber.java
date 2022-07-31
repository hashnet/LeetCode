package com.hashnet.temp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SquareANumber {
	public static void main(String[] args) throws IOException {
//		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		InputStreamReader reader = new InputStreamReader(new FileInputStream("src/inputs/input.txt"), StandardCharsets.UTF_8);

		
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(square(Integer.valueOf(line)));
		}
	}

	private static long square(long num) {
		return num * num;
	}
}
