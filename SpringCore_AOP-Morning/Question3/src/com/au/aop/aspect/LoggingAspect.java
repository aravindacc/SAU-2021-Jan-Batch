package com.au.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//multiple advices inside aspect
@Aspect
public class LoggingAspect {
	
	//to write specifically for circle class write om.au.aop.model.Circle.getName()
//	@Before("execution(public String getName())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//	}
	
	//Apply before all methods start with get
	//execution(public * get*(*) - with parameter
	//execution(public * get*(..) - with any number of parameters
	//execution(* com.au.aop.model.*.get*()) - all get functions for class under model
//	@Before("execution(public * get*())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//		
//	}
//	
//	@Before("allGetters()")
//	public void SecondAdvice() {
//		System.out.println("Second Advice");
//		
//	}
//	
//	//Define pointcut expression
//	@Pointcut("execution(public * get*(..))")
//	public void allGetters() { 
//		/* this is a dummy method for holding pointcut expressions, so they can be referenced later in annotations @Before etc */
//	}
	
	@Around("execution(* com.au.aop.model.Circle.getName(..))")
	public void aroundAdvice() { 
		/* this is a dummy method for holding pointcut expressions, so they can be referenced later in annotations @Before etc */
		System.out.println("Around Advice");
	}
	
	@After("execution(* com.au.aop.model.Game.getId())")
	public void afterAdvice() {
		System.out.println("After Advice");
		
	}
	
	@AfterReturning(pointcut = "execution(* com.au.aop.model.Triangle.getName(..))" , returning = "name")
	public void afterReturningAdvice(String name ){
		System.out.println("After Return Advice with Name: "+name);
		
	}

	@AfterThrowing(pointcut = "execution(* com.au.aop.model.Game.getPublishedYear(..))" , throwing = "error")
	public void afterThrowingAdvice( Throwable error ) {
		System.out.println("After Throwing Advice"+error);
		
	}
}
