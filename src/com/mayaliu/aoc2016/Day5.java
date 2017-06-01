package com.mayaliu.aoc2016;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Day5 {

	public static void main(String[] args) {
		String input = args[0];
		
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			StringBuilder password = new StringBuilder();
			
			// For part 2
			HashMap<Integer, Character> passwordMap = new HashMap<Integer, Character>();
			
			for (int i = 0; ; i++) {
				// Part 1
//				if (password.length() < 8) {
//					StringBuilder inputWithIndex = new StringBuilder();
//					inputWithIndex.append(input);
//					inputWithIndex.append(i);
//					
//					byte[] bytesOfMessage = inputWithIndex.toString().getBytes("UTF-8");
//					String hex = Day5.toHexString(digest.digest(bytesOfMessage));
//					if (hex.substring(0, 5).equals("00000")) {
//						password.append(hex.charAt(5));
//					}
//				} else {
//					break;
//				}
				
				// Part 2
				if (passwordMap.size() < 8) {
					StringBuilder inputWithIndex = new StringBuilder();
					inputWithIndex.append(input);
					inputWithIndex.append(i);
					
					byte[] bytesOfMessage = inputWithIndex.toString().getBytes("UTF-8");
					String hex = Day5.toHexString(digest.digest(bytesOfMessage));
					if (hex.substring(0, 5).equals("00000")) {
						char index = hex.charAt(5);
						if (Character.getType(index) != Character.DECIMAL_DIGIT_NUMBER) {
							continue;
						} else {
							int indexInteger = Integer.parseInt("" + index);
							if (indexInteger < 8 && !passwordMap.containsKey(indexInteger)) {
								passwordMap.put(indexInteger, hex.charAt(6));
							}
						}
					}
				} else {
					break;
				}
			}
			// Part 1
//			System.out.println("The password is " + password.toString());		
			// Part 2
			for (int i = 0; i < 8; i++) {
				password.append(passwordMap.get(Integer.valueOf(i)));
			}
			System.out.println("The password is " + password.toString());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static String toHexString(byte[] bytes) {
	    StringBuilder hexString = new StringBuilder();

	    for (int i = 0; i < bytes.length; i++) {
	        String hex = Integer.toHexString(0xFF & bytes[i]);
	        if (hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }

	    return hexString.toString();
	}

}

