package com.au.spring;

import java.util.HashMap;
import java.util.HashSet;
//import java.util.List;

public class Player {
	HashMap<Integer , Game> gameAndLaunch ; 
	HashSet<Game> games ;
	public HashMap<Integer, Game> getGameAndLaunch() {
		return gameAndLaunch;
	}

	public void setGameAndLaunch(HashMap<Integer, Game> gameAndLaunch) {
		this.gameAndLaunch = gameAndLaunch;
	}

	public HashSet<Game> getGames() {
		return games;
	}

	public void setGames(HashSet<Game> games) {
		this.games = games;
	}
	public void getGamesSet() {
		System.out.println("==========Implementation of Set===========");
		for(Game game: games) {
			System.out.println("Game Id: " +game.getId()+" and Name is: "+game.getName());
		}
	}
	public void getGamesAndLaunch() {
		System.out.println("===========Implementation of Map==========");
		for(int year : gameAndLaunch.keySet())
		{
			System.out.println("Game Name :" + gameAndLaunch.get(year).getName());
		}
	}
}
