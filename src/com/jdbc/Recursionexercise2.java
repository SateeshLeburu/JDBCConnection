package com.jdbc;

public class Recursionexercise2 {
	
	static int count = 0;
	int num;
	
	Recursionexercise2(int num){
		this.num = num;
	}
	
	void display() {
		count++;
		if(count<=num) {			
			System.out.println("Tyler Lockwood "+count);
			display();
		}

	}
}