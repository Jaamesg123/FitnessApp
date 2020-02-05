package entity;

import java.sql.Date;

public class Client {
	
	private int id;
	private String fName;
	private String lName;
	private Date birthdate;
	private int classId;
	
	
	public Client (int id, String fName, String lName, Date birthdate, int classId) {
		this.setId(id);
		this.setfName(fName);
		this.setlName(lName);
		this.setBirthdate(birthdate);
		this.setClassId(classId);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public int getClassId() {
		return classId;
	}


	public void setClassId(int classId) {
		this.classId = classId;
	}
	

}
