package com.thinkgem.jeesite.test;

import java.util.Random;

public class Test {
	private static final String[] wins = { "10.3.6.28" };
	private static final String[] macs = { "DST61858","DST61857","DST61859", };
	
	public static void main(String[] args) {
		
		Random ran = new Random();
		System.out.println(ran.nextInt(wins.length));
		
	}
}
