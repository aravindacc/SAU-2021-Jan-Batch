package com.assignment.runTimeLogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.apache.log4j.*;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class RunTimeLoggerApplication {
	public static void main(String[] args) {
		//SpringApplication.run(RunTimeLoggerApplication.class, args);
		//Logger logger = (Logger) LogManager.getRootLogger();
		BasicConfigurator.configure();
		final Logger logger = Logger.getLogger(RunTimeLoggerApplication.class);
		Scanner scanner = new Scanner(System.in);
		Map<String, String> mapA = new HashMap<>();
		mapA.put("1", "All");
		mapA.put("2", "Debug");
		mapA.put("3", "Info");
		mapA.put("4", "Warn");
		mapA.put("5", "Error");
		mapA.put("6", "Fatal");
		mapA.put("7", "Off"); 
		System.out.println("Enter number between 1 and 7: ");
		int choice = scanner.nextInt();
		String index=mapA.get(Integer.toString(choice));
		System.out.println(index);
		switch(index) {
			case "All":
				logger.setLevel(Level.ALL);
		        break;
			case "Debug":
				logger.setLevel(Level.DEBUG);
				break;
			case "Info":
				logger.setLevel(Level.INFO);
				break;
			case "Warn":
				logger.setLevel(Level.WARN);
				break;
			case "Error":
				logger.setLevel(Level.ERROR);
				break;
			case "Fatal":
				logger.setLevel(Level.FATAL);
				break;
			case "Off":
				logger.setLevel(Level.OFF);
				break;
		}
		logger.trace("Trace Invoked");
		logger.debug("Debug Invoked");
		logger.info("Info Invoked");
		logger.warn("Warn Invoked");
		logger.error("Error Invoked");
		logger.fatal("Fatal Invoked");
	}
}




