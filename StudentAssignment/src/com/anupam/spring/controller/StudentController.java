package com.anupam.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController implements ServletContextAware {
	private ServletContext context;

	@RequestMapping("/sendhere")
	public ModelAndView showContacts(
			@RequestParam(value = "rollNo") String rollNo) {
		System.out.println(rollNo);
		Map<String, Student> studentList = (HashMap<String, Student>) this.context.getAttribute("studentList");
		return new ModelAndView("studentInfo", "student", studentList.get(rollNo));
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
		if (this.context.getAttribute("studentList") == null) {
			Map<String, Student> studentList = new HashMap<String, Student>();
			for (int i = 0; i < 10; i++) {
				Student student = new Student("Student " + (i + 1), i + 1,
						"Pass");
				studentList.put((i+1)+"",student);
			}
			this.context.setAttribute("studentList", studentList);
		}
	}
}
