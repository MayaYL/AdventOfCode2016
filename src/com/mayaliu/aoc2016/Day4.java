package com.mayaliu.aoc2016;

import java.util.HashMap;
import java.util.Set;

public class Day4 {

	public static void main(String[] args) {
		for (String line : args) {
			char[] characters = line.toCharArray();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			StringBuilder sb = new StringBuilder();
			
			for (char c : characters) {
				if (c != ('-')) {
					if (Character.getType(c) == Character.DECIMAL_DIGIT_NUMBER) {
						sb.append(c);
					} else if (Character.getType(c) == Character.LOWERCASE_LETTER) {
						Character character = Character.valueOf(c);
						if (map.containsKey(character)) {
							map.put(character, map.get(character) + 1);
						} else {
							map.put(character, 1);
						}
					}
				}
			}
			
			Set<Character> keys = map.keySet();
		}
	}

}
