package com.mayaliu.aoc2016;

import java.util.TreeMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Day4 {

	public static void main(String[] args) {
		int idSum = 0;
		
		for (String line : args) {
			char[] characters = line.toCharArray();
			TreeSet<Letter> sortedSet = new TreeSet<Letter>(); 
			StringBuilder id = new StringBuilder();
			StringBuilder checksum = new StringBuilder();
			Boolean beginChecksum = false;
			HashMap<Character, Letter> letterMap = new HashMap<Character, Letter>();
			
			for (char c : characters) {
				Boolean isDigit = Character.getType(c) == Character.DECIMAL_DIGIT_NUMBER;
				Boolean isLowerCaseLetter = Character.getType(c) == Character.LOWERCASE_LETTER;
				Letter l;
				
				if ((isDigit || isLowerCaseLetter) && !beginChecksum) {
					if (isDigit) {
						id.append(c);
					} else if (isLowerCaseLetter) {
						Character character = Character.valueOf(c);
						if (letterMap.containsKey(character)) {
							l = letterMap.get(character);
							l.increaseCount();
//							letterMap.get(character).increaseCount();
						} else {
							l = new Letter(c);
						}

						letterMap.put(character, l);
//						Boolean found = false;
//						
//						for (Letter l : sortedSet) {
//							if (l.getValue() == c) {
//								l.increaseCount();
//								found = true;
//								break;
//							}
//						} 
//						if (!found) {
//							sortedSet.add(new Letter(c));
//						}
					}
				} else if (c == '[') {
					beginChecksum = true;
				} else if (isLowerCaseLetter) {
					checksum.append(c);
				}
			}
			
			for (Letter l : letterMap.values()) {
				sortedSet.add(l);
			}
			
//			Set<Character> keys = map.keySet();
//			for (Letter l : sortedSet) {
//				System.out.print(l.getValue() + "=>" + l.getCount() + "; ");
//			}
//			System.out.print("\n ID:" + id.toString() + "; ");
//			System.out.print("checksum: " + checksum.toString() + "\n");
			
			// If the checksum is the same as the first 5 of the sortedSet, keep track of the ID.
			StringBuilder mostCommonLetters = new StringBuilder();
			for (int i = 0; i < 5; i++) {
				mostCommonLetters.append(sortedSet.pollFirst().getValue());
			}
			
//			System.out.println("*** " + mostCommonLetters.toString());
//			System.out.println("common: " + mostCommonLetters + ", " + "checksum: " + checksum);
			if (mostCommonLetters.toString().equals(checksum.toString())) {
				int shift = (Integer.parseInt(id.toString()) - 'a')%26;
				StringBuilder actualRoomBuilder = new StringBuilder();
				for (char c : characters) {
					if (Character.getType(c) == Character.DECIMAL_DIGIT_NUMBER) {
						break;
					}
					if (c == '-') {
						actualRoomBuilder.append(' ');
					} else {
						int actualShift = (c + shift < 'z') ? shift : c + shift - 26;
						actualRoomBuilder.append((char) (c + actualShift));
					}
				}
				System.out.println("shift: " + shift);
				
				if (actualRoomBuilder.toString().indexOf("north pole") > -1) {
					
				}

				System.out.println("actual room: " + actualRoomBuilder.toString());
//				idSum += Integer.parseInt(id.toString());
			}
		}
		
//		System.out.println("The sum is " + idSum);
	}

}

class Letter implements Comparable<Letter> {
	private char value;
	private int count = 1;
	
	public Letter(char value) {
		this.value = value;
	}

	public void increaseCount() {
		this.count++;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public char getValue() {
		return this.value;
	}
	
	@Override
	public int compareTo(Letter o) {
		int otherCount = o.getCount();
		
		if (this.count > otherCount){
			return -1;
		} else if (this.count < otherCount) {
			return 1;
		} else {
			// This is the equal case; compare the char.
			if (this.value < o.getValue()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
}