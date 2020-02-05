package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Client;
import utils.DBConnector;

public class ClientsDao {

	private Connection connection;
	private final String GET_CLIENTS_QUERY = "SELECT * FROM clients";
	private final String GET_CLIENTS_BY_CLASSID_QUERY = "SELECT * FROM clients WHERE class_id = ?";
	private final String UPDATE_CLIENT_CLASS_QUERY = "UPDATE clients SET class_id = ? WHERE id = ?";
	private final String DELETE_CLIENT_BY_ID_QUERY = "DELETE FROM clients WHERE id = ?";
	private final String CREATE_NEW_CLIENT_QUERY = "INSERT INTO clients(client_fn, client_ln, birthdate, class id) VALUES(????)";
	
	
	public ClientsDao() {
		connection = DBConnector.getConnection();
	}
	
	public List<Client> getClients() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_CLIENTS_QUERY).executeQuery();
		List<Client> clients = new ArrayList<Client>();
		
		while (rs.next() ) {
			clients.add(populateClient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5)));
		}
		
		return clients;
	}
	
	public List<Client> getClientsByClassID(int classID) throws SQLException {
		List<Client> clients = new ArrayList<Client>();
		PreparedStatement ps = connection.prepareStatement(GET_CLIENTS_BY_CLASSID_QUERY);
		ps.setInt(1, classID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			clients.add(populateClient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5)));
		}
		return clients;
	}
	
	public void updateClientClassById (int classId, int clientId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CLIENT_CLASS_QUERY);
		ps.setInt(1, classId);
		ps.setInt(2, clientId);
		ps.executeUpdate();
	}
	
	public void deleteClientById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CLIENT_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void createNewClient(String fName, String lName, Date birthdate, int classId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CLIENT_QUERY);
		ps.setString(1, fName);
		ps.setString(2, lName);
		ps.setDate(3, birthdate);
		ps.setInt(4, classId);
		ps.executeUpdate();
	}
	
	private Client populateClient(int id, String fName, String lName, Date birthdate, int classId) {
		return new Client (id, fName, lName, birthdate, classId);
	}
	
	
}
