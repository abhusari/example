package com.test.aop;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectLogging {
	@Before("execution(public String getName())")
	public void loggingAdvice(){
		System.out.println("@Before Advice run.Get method call.");
	}
	
	@Before("allGetters()")
	public void loggingAdviceAfter(){
		System.out.println("2nd Advice run.Get method call.");
	}
	
	@Pointcut("execution(public String getName())")
	public void allGetters(){
		
	}
}
