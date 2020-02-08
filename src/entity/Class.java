package entity;


import java.util.List;

public class Class {

	private int classId;
	private String classType;

	private String dateAndTime;
	private List<Client> clients;
	
	public Class(int classId, String classType, String dateAndTime, List<Client> clients) {
		this.setClassId(classId);
		this.setClassType(classType);
		this.setDateAndTime(dateAndTime);
		
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}



	
	public Class(int classId, String clssType, List<Client> clients) {
		this.classId = classId;
		this.classType = classType;
		this.setClients(clients);
		

	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
}
