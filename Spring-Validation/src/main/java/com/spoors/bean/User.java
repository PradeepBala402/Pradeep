package com.spoors.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
	  
	@Size (min=1,max=10,message="inbetween 1 and 10")
	 @NotEmpty
	    @Email
	private String Email;
	@Size(min=2,max=8 ,message="your pasword must between 2 and 8 characters")
	private String password;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		
	}

}
