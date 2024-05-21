package com.Employee.Entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Emp_Shift")

public class Employee {
	@Id
	private int empId;
	private String empName;
	private Date doj;
	private long number;
	private boolean isDelete;
	private String status;
	private String about;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = ShiftTime.class,cascade = CascadeType.ALL)
	@JoinColumn(name="empId",referencedColumnName = "empId")
	@JsonManagedReference
	private List<ShiftTime> shift;

	public Employee() {
		super();
	}

	public Employee(int empId, String empName, Date doj, long number, boolean isDelete, String status, String about,
			List<ShiftTime> shift) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.doj = doj;
		this.number = number;
		this.isDelete = isDelete;
		this.status = status;
		this.about = about;
		this.shift = shift;
	}

	public Employee(int empId2, String empName2, Date doj2, long number2, boolean delete, String status2,
			String about2) {
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj, long l, boolean b, String string, String string2) {
		this.doj = doj;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<ShiftTime> getShift() {
		return shift;
	}

	public void setShift(List<ShiftTime> shift) {
		this.shift = shift;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", doj=" + doj + ", number=" + number
				+ ", isDelete=" + isDelete + ", status=" + status + ", about=" + about + ", shift=" + shift + "]";
	}

	
	

}
