package com.spoors.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {
	@NotEmpty(message="you entered an email")
	@Email
	private String Email;
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Pattern(regexp = "^[a-z,A-Z]+$", message = "dont enter numerics")
	private String name;
	@Size(min = 1, max = 7, message = "contains  1 to 7 integers/char ")
	private String pass;
	@Pattern(regexp = "^[a-z,A-Z]+$", message = "dont enter numerics")
	private String addrs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
}
