package com.spoors.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spoors.bean.Person;

public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Person.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		if (person.getId() <= 0)
			errors.reject("id", "error.id");
		if (person.getFirstName().equals("") || person.getFirstName() == null)
			errors.reject("firstName", "error.firstName");
		if (person.getLastName().equals("") || person.getLastName() == null)
			errors.reject("lastName", "error.lastName");

	}
}

/*
 * @Override public boolean supports(Class<?> clazz) { return
 * Person.class.isAssignableFrom(Person.class); }
 * 
 * @Override public void validate(Object target, Errors errors) { Person person
 * = (Person) target; Long id = person.getId(); String firstName =
 * person.getFirstName(); String lastName = person.getLastName();
 * ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "error.id");
 * ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
 * "error.firstName"); ValidationUtils.rejectIfEmptyOrWhitespace(errors,
 * "lastName", "error.lastName");
 * 
 * if (id.equals(1)) { errors.rejectValue("id", "error.id"); } if
 * (firstName.equals("pradeep")) { errors.rejectValue("firstName",
 * "error.firstName"); } if (lastName.equals("pradeep")) {
 * errors.rejectValue("lastName", "error.lastName"); }
 * 
 * 
 * }
 */
