package com.spring.au;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(name="rectObj")
	public Rectangle getRectangle() {
		return new Rectangle("Quadrilateral");
	}
	
	@Bean(name="point1")
	public Point getPoint1() {
		return new Point(0,20);
	}
	
	@Bean(name="point2")
	public Point getPoint2() {
		return new Point(80,20);
	}
	
	@Bean(name="point3")
	public Point getPoint3() {
		return new Point(80,-20);
	}
	
	@Bean(name="point4")
	public Point getPoint4() {
		return new Point(0,-20);
	}

}
