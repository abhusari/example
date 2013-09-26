package com.one.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.one.controller.Cataloague;

public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return Cataloague.class.isAssignableFrom(clazz);
	}
	public void validatePage1Form(Object target, Errors errors) {
	}
	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
