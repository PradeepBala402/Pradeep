package com.spoors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoors.bean.Person;
import com.spoors.dao.PersonDao;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired(required = true)
	private PersonDao dao;

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Person findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void create(Person person) {
		 dao.create(person);
	}

	@Override
	public void update(Person person) {
	 dao.update(person);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
