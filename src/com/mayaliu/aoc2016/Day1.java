package com.mayaliu.aoc2016;

import java.util.Hashtable;

public class Day1 {
	private static final int NORTH = 0;
	private static final int EAST = 90;
	private static final int SOUTH = 180;
	private static final int WEST = 270;
	
	public static void main (String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("Please enter at least one navigation instruction.");
			return;
		}
		
		int currentDegree = 0;
		Coordinate coor = new Coordinate(0, 0);
		
		for (String instruction : args) {
			if (instruction.charAt(instruction.length()-1) == ',') {
				instruction = instruction.substring(0, instruction.length()-1);
			}
			
			String direction = Character.toString(instruction.charAt(0));
			int distance = Integer.parseInt(instruction.substring(1, instruction.length()));
					
			if (direction.equalsIgnoreCase("L")) {
				currentDegree = (currentDegree - 90)%360;
			} else if (direction.equalsIgnoreCase("R")) {
				currentDegree = (currentDegree + 90)%360;
			} else {
				String message = String.format("Invalid direction '%s' given", direction);
				throw new Exception(message);
			}
			
			if (currentDegree < 0) {
				// Converting from negative to positive degrees.
				currentDegree += 360;
			}
			
			try {
				switch (currentDegree) {
					case NORTH:
						coor.goNorth(distance);
						break;
					case SOUTH:
						coor.goSouth(distance);
						break;
					case EAST:
						coor.goEast(distance);
						break;
					case WEST:
						coor.goWest(distance);
				}
			} catch (AlreadyVisitedException e) {
				System.out.println("The first location visited twice is " + coor.getVisitedBefore());
				break;
			}	
		}
		
		int distanceFromOrigin = coor.getDistanceFromOrigin();
		
		System.out.printf("The HQ is %d blocks away", distanceFromOrigin);
	}
}

class Coordinate {
	private int x, y;
	private Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
	private Coordinate firstToBeVisitedTwice;
	
	public Coordinate(int x, int y) throws AlreadyVisitedException {
		this.x = x;
		this.y = y;
	}
	
	public void goNorth(int distance) throws AlreadyVisitedException {
		for (int i = 0; i < distance; i++) {
			this.y += 1;
			this.logVisit();
		}
	}
	
	public void goSouth(int distance) throws AlreadyVisitedException {
		for (int i = 0; i < distance; i++) {
			this.y -= 1;
			this.logVisit();
		}
	}
	
	public void goEast(int distance) throws AlreadyVisitedException {
		for (int i = 0; i < distance; i++) {
			this.x += 1;
			this.logVisit();
		}
	}
	
	public void goWest(int distance) throws AlreadyVisitedException {
		for (int i = 0; i < distance; i++) {
			this.x -= 1;
			this.logVisit();
		}
	}
	
	public int getDistanceFromOrigin() {
		return Math.abs(this.x) + Math.abs(this.y);
	}
	
	public String toString() {
		return("(" + this.x + "," + this.y + ")");
	}
	
	private void logVisit() throws AlreadyVisitedException {
		String key = this.toString();
		int value = 0;
		
		if (hash.containsKey(key)) {
			this.firstToBeVisitedTwice = this;
			throw new AlreadyVisitedException();
		}
		hash.put(this.toString(), value + 1);
	}
	
	public Coordinate getVisitedBefore() {
		return firstToBeVisitedTwice;
	}
}

class AlreadyVisitedException extends Exception {}
