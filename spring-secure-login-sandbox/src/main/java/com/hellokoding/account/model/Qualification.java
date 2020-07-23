package com.hellokoding.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qualification")
public class Qualification {  

	private long id;  	
	private long employeeId;  
	private String name;  
	private int level;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getQualification() {
		return name;
	}
	public void setQualification(String qualification) {
		this.name = qualification;
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
				name, level);
	}
  
}  