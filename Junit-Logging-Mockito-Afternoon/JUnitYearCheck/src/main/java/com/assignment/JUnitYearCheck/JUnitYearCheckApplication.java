package com.assignment.JUnitYearCheck;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JUnitYearCheckApplication {

	public static void main(String[] args) {
//		SpringApplication.run(JUnitYearCheckApplication.class, args);
		// Taking input from user and checking leap year.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Year to check: ");
		int year=scanner.nextInt();
		if(checkLeapYear(year)) {
			System.out.println(year+" is a Leap Year");
		}
		else {
			System.out.println(year+" is not a Leap Year");
		}
		
	}
	
	public static Boolean checkLeapYear(int year) {
		if(year<=0) return false;
		else if(((year%4==0) && (year%100!=0)) || (year%400==0)) {
			return true;
		}
		return false;
	}

}
