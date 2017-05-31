package com.mayaliu.aoc2016;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day5 {

	public static void main(String[] args) {
		String input = args[0];
		
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			StringBuilder sb = new StringBuilder();
			
//			while (sb.length() < 5) {
				for (int i = 0; i < 5; i++) {
					StringBuilder inputWithIndex = new StringBuilder();
					sb.append(input);
					sb.append(i);
					
					byte[] bytesOfMessage = sb.toString().getBytes("UTF-8");
					byte[] hex = digest.digest(bytesOfMessage);
					System.out.println(hex);
				}
//			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
