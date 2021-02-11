package com.spring.au;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Rectangle {
	private String type; 
	  
	 @Autowired
	 @Qualifier("point1")
	 private Point point1;
	 
	 @Autowired
	 @Qualifier("point2")
	 private Point point2;
	 
	 @Autowired
	 @Qualifier("point3")
	 private Point point3;
	 
	 @Autowired
	 @Qualifier("point4")
	 private Point point4;
	   	  
	 public Rectangle(String type) 
	 {
		 this.type = type;
	 } 
	   
	 public String getType()
	 {
		 return type; 
	 }
	  
	 public void setType(String type)
	 {
		 this.type = type; 
	 }

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public Point getPoint3() {
		return point3;
	}

	public void setPoint3(Point point3) {
		this.point3 = point3;
	}

	public Point getPoint4() {
		return point4;
	}

	public void setPoint4(Point point4) {
		this.point4 = point4;
	}
	
	  public void getPointsDetails() {
		  System.out.println("Rectangle Type: "+getType());
		  System.out.println("Points Details are: ");
		  System.out.println("Point1(X): "+getPoint1().getX()+"\t Point1(Y): "+getPoint1().getY());
		  System.out.println("Point2(X): "+getPoint2().getX()+"\t Point2(Y): "+getPoint2().getY());
		  System.out.println("Point3(X): "+getPoint3().getX()+"\t Point3(Y): "+getPoint3().getY());
		  System.out.println("Point4(X): "+getPoint4().getX()+"\t Point4(Y): "+getPoint4().getY());
	  }

}
