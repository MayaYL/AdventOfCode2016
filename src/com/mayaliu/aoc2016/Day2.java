package com.mayaliu.aoc2016;

public class Day2 {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please enter at least one line of instructions.");
			return;
		}
		
		Key current = Key.FIVE;
		
		for (String line : args) {
			for (char c : line.toCharArray()) {
				current = Key.getKey(current.getNext(c));
			}
			System.out.print(current.getValue());
		}
	}
}

enum Key {
	ONE ('1', '1', '3', '1', '1'), 
	TWO ('2', '2', '6', '2', '3'), 
	THREE ('3', '1', '7', '2', '4'), 
	FOUR ('4', '4', '8', '3', '4'), 
	FIVE ('5', '5', '5', '5', '6'), 
	SIX ('6', '2', 'A', '5', '7'), 
	SEVEN ('7', '3', 'B', '6', '8'), 
	EIGHT ('8', '4', 'C', '7', '9'), 
	NINE ('9', '9', '9', '8', '9'),
	A ('A', '6', 'A', 'A', 'B'),
	B ('B', '7', 'D', 'A', 'C'),
	C ('C', '8', 'C', 'B', 'C'),
	D ('D', 'B', 'D', 'D', 'D');
	
	private char up, down, left, right;
	private char value;
	Key(char value, char up, char down, char left, char right) {
		this.value = value;
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	
	char getNext(char direction) {
		switch (direction) {
			case 'L':
				return this.left;
			case 'R':
				return this.right;
			case 'U':
				return this.up;
			case 'D':
				return this.down;
			default:
				return this.value;
		}
	}
	
	char getValue() {
		return this.value;
	}
	
	static Key getKey(char c) {
		switch(c) {
			case '1':
			default:
				return ONE;
			case '2':
				return TWO;
			case '3':
				return THREE;
			case '4': 
				return FOUR;
			case '5':
				return FIVE;
			case '6':
				return SIX;
			case '7':
				return SEVEN;
			case '8':
				return EIGHT;
			case '9':
				return NINE;
			case 'A':
				return A;
			case 'B':
				return B;
			case 'C':
				return C;
			case 'D':
				return D;
		}
	}
}
