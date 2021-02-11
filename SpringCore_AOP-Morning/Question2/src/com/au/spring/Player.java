package com.au.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//import org.springframework.beans.factory.DisposableBean;
//InitializingBean is a marker for spring to call method of bean after initiliazation of bean
//import org.springframework.beans.factory.InitializingBean;


public class Player { //implements InitializingBean , DisposableBean 
	@Autowired
	@Qualifier("Game1")
	private Game Game1;
	
	@Autowired
	@Qualifier("Game2")
	private Game Game2;
	
	@Autowired
	@Qualifier("Game3")
	private Game Game3;
	

//	public Point getPointA() {
//		return PointA;
//	}
//	
//	public void setPointA(Point PointA) {
//		this.PointA = PointA;
//	}
//
//	
//	public Point getPointB() {
//		return PointB;
//	}
// 
//	
//	public void setPointB(Point pointB) {
//		this.PointB = pointB;
//	}
//
//	public Point getPointC() {
//		return PointC;
//	}
//
//	public void setPointC(Point pointC) {
//		this.PointC = pointC;
//	}  
//	
//	public void draw() {
//		System.out.println("PointA"+getPointA().getX()+"PointA"+getPointA().getY());
//		System.out.println("PointB"+getPointB().getX()+"PointB"+getPointB().getY());
//		System.out.println("PointC"+getPointC().getX()+"PointC"+getPointC().getY());
//	}

	public Game getGame1() {
		return Game1;
	}

	public void setGame1(Game game1) {
		Game1 = game1;
	}

	public Game getGame2() {
		return Game2;
	}

	public void setGame2(Game game2) {
		Game2 = game2;
	}

	public Game getGame3() {
		return Game3;
	}

	public void setGame3(Game game3) {
		Game3 = game3;
	}
	public void getGameDetails() {
		System.out.println("Game Id: "+getGame1().getId()+" Game Name: "+getGame1().getName()+" Game PublishedOn: "+getGame1().getPublishedYear());
		System.out.println("Game Id: "+getGame2().getId()+" Game Name: "+getGame2().getName()+" Game PublishedOn: "+getGame2().getPublishedYear());
		System.out.println("Game Id: "+getGame3().getId()+" Game Name: "+getGame3().getName()+" Game PublishedOn: "+getGame3().getPublishedYear());
	}
	
	/*@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Triangle bean initialized");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Triangle bean destroyed");
		
	}*/

	//when we dont want to implement interfaces specific to spring, write own menthods and refer from xml
	public void onInit() {
		System.out.println("GameCollection bean initialized");
	}
	
	public void onCleanup() {
		System.out.println("GameCollection bean destroyed");
	}

}
