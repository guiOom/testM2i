package com.barbet.gauthier.main;

import com.barbet.gauthier.models.T;

public abstract class Display {

	public static void display (T o) {
		System.out.println(o);
	}
	
	public static void display (String s) {
		System.out.println(s);
	}
	
	public static void lineJump () {
		System.out.println();
	}
	
	public static void changeObject (T o) {
		
	}
}
