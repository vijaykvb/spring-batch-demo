/**
 * 
 */
package com.tetra.batch.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Kvbhaskar
 *
 */
@Data
@Entity(name = "EMPLOYEE_TABLE")
public class Employee implements Serializable {

	/**
	 * serialVersionUID value;
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long empId;
	private String empName;
	private String empAddress;
	private String empDesignation;
	private String empSalary;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}
	
}
