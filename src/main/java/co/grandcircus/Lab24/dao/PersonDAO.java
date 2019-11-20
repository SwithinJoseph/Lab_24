package co.grandcircus.Lab24.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addPerson(String firstName, String lastName, String email, String phoneNumber, String password) {
		String addQuery = "insert into users (first_name, last_name, email, phone_number, password) values(?,?,?,?,?)";
		return jdbcTemplate.update(addQuery, firstName, lastName, email, phoneNumber, password);
	}
}
