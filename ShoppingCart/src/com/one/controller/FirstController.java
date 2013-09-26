package com.one.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

public class FirstController extends AbstractWizardFormController {
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		System.out.println("Getting produc list.");
		Map<String, Product> productList = new HashMap<String, Product>();
		for(int i=0;i<10;i++){
			productList.put("Product "+i,new Product("Product "+i, i*(i+5)));
		}
		return new Cataloague(productList);
	}

	@Override
	protected ModelAndView processFinish(HttpServletRequest req,
			HttpServletResponse res, Object command, BindException ex)
			throws Exception {
		System.out.println("FirstController.processFinish():start");
		Product product = (Product) command;
		ModelAndView model = new ModelAndView("resultPage");
		model.addObject("product", product);
		return model;

	}
	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		System.out.println("FirstController.processCancel()");

		// where is the cancel page?
		return new ModelAndView("firstPage");
	}

}
