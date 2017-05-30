package com.mayaliu.aoc2016;

import java.util.PriorityQueue;
public class Day3 {
	public static void main(String[] args) {
		int possibleTriangles = 0;

		for (int i = 0; i <= args.length - 9; i += 9) {
			PriorityQueue<Integer> sides = new PriorityQueue<Integer>();
			for (int j = 0; j < 3; j++ ) {
				for (int k = 0; k < 3; k++) {
					sides.add(Integer.valueOf(args[i + j + k * 3]));
				}
				
				int side1 = sides.poll().intValue();
				int side2 = sides.poll().intValue();
				int side3 = sides.poll().intValue();
				
				if (side1 + side2 > side3) {
					possibleTriangles++;
				}
				System.out.println(side1 + ", " + side2 + ", " + side3);
			}
		}
		System.out.println("There are " + possibleTriangles + " possible triangles");
	}
}
