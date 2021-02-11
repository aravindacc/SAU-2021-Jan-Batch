package com.au.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.au.aop.service.ShapeService;

public class AopMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeservice", ShapeService.class);
		System.out.println(shapeService.getTriangle().getName());
		System.out.println(shapeService.getGame().getId());
		System.out.println(shapeService.getGame().getPublishedYear());
		System.out.println(shapeService.getCircle().getName());
	}

}
