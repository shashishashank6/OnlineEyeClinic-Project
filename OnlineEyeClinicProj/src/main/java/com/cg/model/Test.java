package com.cg.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Test {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="test_seq")
	@SequenceGenerator(name="test_seq",sequenceName="test_seq",allocationSize=1)
	@Column(name="test_Id")
int testId;
	@Column(name="test_Name")
private String testName;
	@Column(name="test_Cost")
private double testCost;
	@Column(name="test_Description")
private String testDescription;
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="doctor_Id")
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name="doctor_Id")
private Doctor doctor;
	
	public Doctor getDoctor() {
		return doctor;
				}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public double getTestCost() {
		return testCost;
	}
	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}
	public String getTestDescription() {
		return testDescription;
	}
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	public Test(int testId, String testName, double testCost, String testDescription,Doctor doctor) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testCost = testCost;
		this.testDescription = testDescription;
		this.doctor=doctor;
	}
public Test() {
	
}
}
