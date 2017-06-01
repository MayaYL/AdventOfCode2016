package com.mayaliu.aoc2016;

import java.util.HashMap;
import java.util.TreeSet;

public class Day6 {

	public static void main(String[] args) {
		StringBuilder part1 = new StringBuilder();
		StringBuilder part2 = new StringBuilder();
		
		for (int i = 0; i < 8; i++) {
			TreeSet<Letter> sortedSet = new TreeSet<Letter>(); 
			HashMap<Character, Letter> letterMap = new HashMap<Character, Letter>();
			
			for (String line : args) {
				Character c = line.charAt(i);
				if (letterMap.containsKey(c)) {
					Letter l = letterMap.get(c);
					l.increaseCount();
					letterMap.put(c, l);
				} else {
					letterMap.put(c, new Letter(c));
				}
			}
			
			for (Letter l : letterMap.values()) {
				sortedSet.add(l);
			}
			// Part 1
			part1.append(sortedSet.pollFirst().getValue());
			// Part 2
			part2.append(sortedSet.pollLast().getValue());
		}
		
		System.out.println("Part 1: " + part1.toString());
		System.out.println("Part 2: " + part2.toString());
	}

}

