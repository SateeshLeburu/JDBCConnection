package com.jdbc;

public class Recursiontest {
	
	public static void main(String args[]) {
		
		Recursionexercise2 obj = new Recursionexercise2(5);		
		obj.display();
	    
		System.out.println();
		
	    Recursionexercise objfact = new Recursionexercise();
	    System.out.println("Factorial of 5 is: "+objfact.factorial(5));    	 
	    
	}
}