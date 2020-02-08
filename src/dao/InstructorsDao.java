package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Instructor;
import utils.DBConnector;


public class InstructorsDao {

	private Connection connection = DBConnector.getConnection();

<<<<<<< HEAD
	
	
	

=======
	private String GET_INSTRUCTORS = "SELECT * FROM instructors";
>>>>>>> 6cd25c223037272f8411fafccded9dd4b3442cd3
	private final  String NEW_INSTRUCTOR = "Insert into food(instructor_FN, instructor_LN, classes_taught, pay_rate)" +
			"values(?,?,?,?)";
	private String UPDATE_PAY = "update instructors set pay_rate = ? where instructor_ID = ?";
	private String REMOVE_INSTRUCTOR = "delete from instructors where instructor_ID = ?";
	
	//NEW INSTRUCTOR 
	public void newInstructor(String instructor_FN, String instructor_LN, String classes_taught, double pay_rate) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(NEW_INSTRUCTOR);
		ps.setString(1, instructor_FN);
		ps.setString(2, instructor_LN);
		ps.setString(3, classes_taught);
		ps.setDouble(4, pay_rate);
		ps.executeUpdate();
	}
	
	//GET ALL INSTRUCTORS
	public List<Instructor> getInstructors() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_INSTRUCTORS).executeQuery();
		List<Instructor> instructors = new ArrayList<Instructor>();
		
		while (rs.next() ) {
			instructors.add(populateInstructor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
		}
		
		return instructors;
	}
	
	private  Instructor populateInstructor(int instructor_ID, String instructor_FN, String instructor_LN, String classes_taught, double pay_rate) {
		
		return populateInstructor(instructor_ID, instructor_FN, instructor_LN, classes_taught, pay_rate);
	}

<<<<<<< HEAD


=======
>>>>>>> 6cd25c223037272f8411fafccded9dd4b3442cd3
	
	public void updatePay(int instructor_ID, double pay_rate) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_PAY);
		ps.setDouble(1, pay_rate);
		ps.setInt(2, instructor_ID);
		ps.executeUpdate();
	}
	
	public  void removeInstructor(int instructor_ID) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(REMOVE_INSTRUCTOR);
		ps.setInt(1, instructor_ID);
		ps.executeUpdate();
	}
}


