/**
 * 
 */
package com.anupam.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author ab0055518
 *
 */
//@Controller
public class MyController implements Controller {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@RequestMapping("/hello")
	public ModelAndView greeting(){
		String message = "Hello World, Spring 3.0!"+name;
        return new ModelAndView("hello", "message", message);
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String message = "Hello World, Spring 3.0!"+name;
        return new ModelAndView("hello", "message", message);
	}
}
