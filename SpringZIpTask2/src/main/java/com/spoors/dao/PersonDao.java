package com.spoors.dao;

import java.util.List;

import com.spoors.bean.Person;

public interface PersonDao {
	public int save(Person person);
	List<Person> findAll();

}
