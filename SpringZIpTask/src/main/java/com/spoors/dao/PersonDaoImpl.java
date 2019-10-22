package com.spoors.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spoors.bean.Person;
@Repository
public class PersonDaoImpl implements PersonDao {
	private static final String Insert_Query = "insert into persons(name,gender,addrs,imgLoc) values(?,?,?,?)";
	@Autowired
	private JdbcTemplate template;
		public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

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
}
