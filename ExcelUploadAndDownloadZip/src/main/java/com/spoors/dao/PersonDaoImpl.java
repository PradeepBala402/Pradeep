package com.spoors.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spoors.bean.Person;
@Repository
public class PersonDaoImpl implements PersonDao {
	private static final String Insert_Query = "insert into persons values(?,?,?,?)";
	@Autowired
	private JdbcTemplate template;
		public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
		Person person;

	@Override
	public int save(Person person) {
		int result = template.update(Insert_Query,person.getName(),person.getGender(),person.getAddrs(),person.getImgLoc());
		return result;
	}

	@Override
	public String getAllPersonDetails(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveFileDataInDB(List<Person> personList) {
		int result = template.update(Insert_Query,person.getName(),person.getGender(),person.getAddrs(),person.getImgLoc());
		return result;
	}
}
