package com.spoors.dao;

import com.spoors.bean.Person;

public interface PersonDao {
	public int save(Person person);
	public String getAllPersonDetails(int id);

}
