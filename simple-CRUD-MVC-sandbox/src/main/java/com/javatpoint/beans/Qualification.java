package com.javatpoint.beans;  
  
public class Qualification {  
	private int id;  
	private int employeeId;  
	private String qualification;  
	private int level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return String.format("Qualification [id=%s, employeeId=%s, qualification=%s, level=%s]", id, employeeId,
				qualification, level);
	}
  
}  