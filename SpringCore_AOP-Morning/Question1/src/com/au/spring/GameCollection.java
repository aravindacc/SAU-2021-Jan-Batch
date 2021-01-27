package com.au.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class GameCollection {

	public static void main(String[] args) {

		ApplicationContext factory = new FileSystemXmlApplicationContext("/Question1/spring.xml");
		Player player = (Player)factory.getBean("player");
		// MAP
		player.getGamesAndLaunch();
		//SET
		player.getGamesSet();
		
	}

}
