package entity;

import java.util.List;

public class Classes {

	private int classId;
	private String classType;
	private String dateAndTime;
	private List<Clients> clients;
	
	public Classes(int classId, String classType, String dateAndTime, List<Clients> clients) {
		this.setClassId(classId);
		this.setClassType(classType);
		this.setDateAndTime(dateAndTime);
		this.setClients(clients);
		
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

	public List<Clients> getClients() {
		return clients;
	}

	public void setClients(List<Clients> clients) {
		this.clients = clients;
	}
	
	
}
