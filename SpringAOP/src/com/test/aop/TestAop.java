package com.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.aop.domain.ShapeService;

public class TestAop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = (ShapeService) ctx.getBean("shapeservice");
		System.out.println(shapeService.getTriangle().getName());
	}

}
