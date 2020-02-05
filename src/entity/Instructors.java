package entity;

public class Instructors {
	
	private int instructor_ID;
	private String instructor_FN;
	private String instructor_LN;
	private String classes_taught;
	private double pay_rate;
	

	public Instructors(int instructor_ID, String instructor_FN, String instructor_LN, String classes_taught,
			double pay_rate) {
		super();
		this.instructor_ID = instructor_ID;
		this.instructor_FN = instructor_FN;
		this.instructor_LN = instructor_LN;
		this.classes_taught = classes_taught;
		this.pay_rate = pay_rate;
	}
	
	
	public int getInstructor_ID() {
		return instructor_ID;
	}
	public void setInstructor_ID(int instructor_ID) {
		this.instructor_ID = instructor_ID;
	}
	public String getInstructor_FN() {
		return instructor_FN;
	}
	public void setInstructor_FN(String instructor_FN) {
		this.instructor_FN = instructor_FN;
	}
	public String getInstructor_LN() {
		return instructor_LN;
	}
	public void setInstructor_LN(String instructor_LN) {
		this.instructor_LN = instructor_LN;
	}
	public String getClasses_taught() {
		return classes_taught;
	}
	public void setClasses_taught(String classes_taught) {
		this.classes_taught = classes_taught;
	}
	public double getPay_rate() {
		return pay_rate;
	}
	public void setPay_rate(double pay_rate) {
		this.pay_rate = pay_rate;
	}
	

}
