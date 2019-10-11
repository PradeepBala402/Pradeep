package com.spoors.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spoors.bean.Employee;
@Component
public class EmployeeValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Employee emp = (Employee) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", " name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "error.pass", "Password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addrs", "error.addrs", "Address is required.");
	}

}
