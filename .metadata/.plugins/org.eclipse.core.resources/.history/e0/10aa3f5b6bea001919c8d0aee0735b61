package com.spoors.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spoors.bean.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	@Autowired
	private JdbcTemplate jt;
	private static final String Get_All_Persons = "select id,first_name,last_name from person";
	private static final String Find_By_Id = "select first_name,last_name from person where id=?";
	private static final String Insert_Qry = "insert into person(id,first_name,last_name) values(?,?,?)";
	private static final String Update_Qry = "update person set first_name = ?, last_name = ? where id = ?";
	private static final String Delete_Qry = "delete from person where id = ?";

	@Override
	public List<Person> findAll() {

		return jt.query(Get_All_Persons, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(rs.getLong("id"));
				person.setFirstName(rs.getString("first_name"));
				person.setLastName(rs.getString("last_name"));
				return person;
			}
		});

	}

	@Override
	public Person findById(Long id) {
		return jt.queryForObject(Find_By_Id, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(id);
				person.setFirstName(rs.getString("first_name"));
				person.setLastName(rs.getString("last_name"));
				return person;
			}
		}, id);

	}

	@Override
	public int create(Person person) {

		/*
		 * KeyHolder keyHolder = new GeneratedKeyHolder(); jt.update(new
		 * PreparedStatementCreator() {
		 * 
		 * @Override public PreparedStatement createPreparedStatement(Connection con)
		 * throws SQLException { PreparedStatement stmt =
		 * con.prepareStatement(Insert_Qry); stmt.setLong(1, person.getId());
		 * stmt.setString(2, person.getFirstName()); stmt.setString(3,
		 * person.getLastName()); return stmt; } }, keyHolder);
		 * person.setId(keyHolder.getKey().longValue());
		 */
		
		 int cnt = jt.update(Insert_Qry, person.getId(),person.getFirstName(), person.getLastName());
		 return cnt;
		
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		jt.update(Update_Qry, person.getFirstName(), person.getLastName(), person.getId());

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		jt.update(Delete_Qry, id);

	}

}
