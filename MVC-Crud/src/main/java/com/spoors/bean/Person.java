package com.spoors.bean;

import javax.validation.constraints.Pattern;

public class Person {
@Pattern(regexp="^[0-9]+$",message="only numerics and +ve integers")
	private Long id;
@Pattern(regexp="^[a-zA-Z]+$",message="Only allows String")
	private String firstName;
@Pattern(regexp="^[a-zA-Z]+$",message="Only allows String")
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Person() {
		// System.out.println("Person.Person()::parametrized constructor");

	}

	/*
	 * public Person() { System.out.println("Person.Person()::0-param constructor");
	 * }
	 */
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
