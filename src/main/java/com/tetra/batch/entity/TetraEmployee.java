/**
 * 
 */
package com.tetra.batch.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author KVBhaskar
 *
 */
@XmlRootElement(name = "EmployeeDetails")
public class TetraEmployee {

	private String empId;

	private String empName;

	private int empAge;

	@XmlElement(name = "empId")
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@XmlElement(name = "empName")
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@XmlElement(name = "empAge")
	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	@Override
	public String toString() {
		return "TetraEmployees [EmpName = " + empName + ", EmpID = " + empId + ", EmpAge = " + empAge + "]";
	}

}
