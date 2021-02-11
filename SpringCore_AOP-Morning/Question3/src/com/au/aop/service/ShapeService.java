package com.au.aop.service;

import com.au.aop.model.Circle;
import com.au.aop.model.Game;
import com.au.aop.model.Triangle;

public class ShapeService {
	
	private Circle circle;
	private Triangle triangle;
	private Game game;
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
