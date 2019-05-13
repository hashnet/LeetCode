package com.hashnet.leetcode.problemsetall;

public class _780_Reaching_Points {
	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		while(true) {
			if(sx == tx && sy == ty) return true;
			else if(tx == ty) break;
			else if(tx < sx) break;
			else if(ty < sy) break;
			
			if(tx > ty) {
				int px = tx;
				tx %= ty;
				tx = ((sx - tx) / ty * ty) + tx;
				if(px == tx) break;
			}
			else if(tx < ty) {
				int py = ty;
				ty %= tx;
				ty = ((sy - ty) / tx * tx) + ty;
				if(py == ty) break;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		_780_Reaching_Points solution = new _780_Reaching_Points();
		
		System.out.println(solution.reachingPoints(3, 7, 3, 4));
		System.out.println(solution.reachingPoints(1, 5, 19, 5));
		System.out.println(solution.reachingPoints(4, 3, 10, 3));
		System.out.println(solution.reachingPoints(5, 3, 10, 3));
		System.out.println(solution.reachingPoints(2, 7, 9, 16));
		System.out.println(solution.reachingPoints(1, 1, 7, 4));
		System.out.println(solution.reachingPoints(1, 1, 7, 4));
		System.out.println(solution.reachingPoints(1, 1, 11, 21));
		System.out.println(solution.reachingPoints(1, 1, 2, 2));
	}
}
