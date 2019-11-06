package com.spoors.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spoors.bean.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	private static final String Insert_Query = "insert into persons(name,gender,addrs,imgLoc) values(?,?,?,?)";
	private static final String Get_all_Persons = "select * from persons";
	@Autowired
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int save(Person person) {
		int result = template.update(Insert_Query, person.getName(), person.getGender(), person.getAddrs(),
				person.getImgLoc());
		return result;
	}

	@Override
	public List<Person> findAll() {
		return template.query(Get_all_Persons, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setGender(rs.getString(3));
				person.setAddrs(rs.getString(4));
				person.setImgLoc(rs.getString(5));

				return person;
			}
		});

	}

}
