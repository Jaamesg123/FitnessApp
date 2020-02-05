package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Classes;
import dao.ClientsDao;


public class ClassesDao {
	
	private Connection connection;
	private ClassesDao classesDao; 
	private final String GET_CLASSES_QUERY = "SELECT * FROM CLASSES";
	private final String UPDATE_CLASS_DATE_AND_TIME_QUERY = "UPDATE classes SET date_and_time = ? WHERE class_id = ?";
	private final String DELETE_CLASS_QUERY = "DELETE FROM classes WHERE class_id = ?";
	private final String CREATE_NEW_CLASS_QUERY = "INSERT INTO classes(type, date_and_time) VALUES(?,?)";
	
	public ClassesDao() {
		connection = DBConnector.getConnection();
		classesDao = new ClassesDao();
		
	}
	
	public List<Classes> getClasses() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_CLASSES_QUERY).executeQuery();
		List<Classes> classes = new ArrayList<Classes>();
		
		while (rs.next()) {
			classes.add(populateClasses(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return classes;
	}
	
	public void updateClassDateAndTimeById(int classId, String dateAndTime) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CLASS_DATE_AND_TIME_QUERY);
		ps.setInt(1, classId);
		ps.setString(2, dateAndTime);
		ps.executeUpdate();
	}
	
	public void deleteClassById(int classId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CLASS_QUERY);
		ps.setInt(1, classId);
		ps.executeUpdate();
	}
	
	public void createNewClassById(String classType, String dateAndTime) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CLASS_QUERY);
		ps.setString(1, classType);
		ps.setString(2, dateAndTime);
		ps.executeUpdate();
	}
	
	
	
	private Classes populateClasses(int classId, String classType, String dateAndTime) throws SQLException {
		return new Classes(classId, classType, dateAndTime, classesDao.getClientsByClassID(classId));

	}

public class ClassesDao {


}
