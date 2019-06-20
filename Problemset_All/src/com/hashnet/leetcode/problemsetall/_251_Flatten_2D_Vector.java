package com.hashnet.leetcode.problemsetall;

public class _251_Flatten_2D_Vector {
	private int[][] v;
	private boolean hasNext;
	private int i;
	private int j;

	public _251_Flatten_2D_Vector(int[][] v) {
		this.v = v;

		hasNext = false;
		for (i = 0; i < v.length; i++) {
			if (v[i].length == 0)
				continue;
			else {
				hasNext = true;

				break;
			}
		}
		j = 0;
	}

	public int next() {
		if(!hasNext) return -1;
		
		int result = v[i][j++];
		
		if(j >= v[i].length) {
			hasNext = false;
			for (i = i+1; i < v.length; i++) {
				if (v[i].length == 0)
					continue;
				else {
					hasNext = true;
					j = 0;
					
					break;
				}
			}
		}

		return result;
	}

	public boolean hasNext() {
		return hasNext;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2 }, { 3 }, { 4 } };
		_251_Flatten_2D_Vector iterator = new _251_Flatten_2D_Vector(arr);

		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());

	}
}
