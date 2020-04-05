package com.cg.thymeleaf.springthymeleafexample.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_EMPLOYEES")
public class EmployeeDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	 @Column(name="first_name")
	private String firstName;
	 @Column(name="last_name")
	private String lastName;
	 @Column(name="email", nullable=false, length=200)
	private String email;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + "]";
	}

	public EmployeeDTO(int empId, String firstName, String lastName, String email) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}
}
