package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Instructors;


public class InstructorsDao {

	private Connection connection = DBConnector.getConnection();
	private String GET_INSTRUCTORS = "SELECT * FROM instructors";
	
	
	public List<Instructors> getInstructors() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_INSTRUCTORS).executeQuery();
		List<Instructors> instructors = new ArrayList<Instructors>();
		
		while (rs.next() ) {
			instructors.add(populateInstructors(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
		}
		
		return instructors;
	}
	
	private  Instructors populateInstructors(int instructor_ID, String instructor_FN, String instructor_LN, String classes_taught, double pay_rate) {
		
		return populateInstructors(instructor_ID, instructor_FN, instructor_LN, classes_taught, pay_rate);
	}
}
