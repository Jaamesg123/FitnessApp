package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Clients;

public class ClientsDao {

	private Connection connection;
	private final String GET_CLIENTS_QUERY = "SELECT * FROM clients";
	
	
	public ClientsDao() {
		connection = DBConnector.getConnection();
	}
	
	public List<Clients> getClients() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_CLIENTS_QUERY).executeQuery();
		List<Clients> clients = new ArrayList<Clients>();
		
		while (rs.next() ) {
			clients.add(populateClients(rs.getInt(1), rs.getString(2)), rs.getString(3), rs.getDate(4), rs.getInt(5));
		}
		
		return clients;
	}
	
	private Clients populateClients(int id, String fName, String lName, Date birthdate, int classId) {
		return new Clients (id, fName, lName, birthdate, classId);
	}
	
	
}
