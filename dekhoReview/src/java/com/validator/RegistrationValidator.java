package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.user.*;

public class RegistrationValidator implements Validator {

	@Override
	public boolean supports(Class<?> c) {
		System.out.println("supports");
		return User.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object command, Errors errors) {
		System.out.println("Validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"field.userName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passWord",
				"field.passWord.empty");

	}
}
