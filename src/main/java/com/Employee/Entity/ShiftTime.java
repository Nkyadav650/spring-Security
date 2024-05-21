package com.Employee.Entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class ShiftTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int shiftId;
private LocalDate startDate;
private LocalDate endDate;
private Time shiftStartTime;
private Time shiftEndTime;
private int modifyBy;

private String weekOff;
@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Employee.class)
@JoinColumn(name="empId")
@JsonBackReference
public Employee employee;


public ShiftTime() {
	super();
}
public ShiftTime(int shiftId, LocalDate startDate, LocalDate endDate, Time shiftStartTime, Time shiftEndTime, int modifyBy,
		String weekOff, Employee employee) {
	super();
	this.shiftId = shiftId;
	this.startDate = startDate;
	this.endDate = endDate;
	this.shiftStartTime = shiftStartTime;
	this.shiftEndTime = shiftEndTime;
	this.modifyBy = modifyBy;
	this.weekOff = weekOff;
	this.employee = employee;
}
public int getShiftId() {
	return shiftId;
}
public void setShiftId(int shiftId) {
	this.shiftId = shiftId;
}
public LocalDate getStartDate() {
	return startDate;
}
public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}
public LocalDate getEndDate() {
	return endDate;
}
public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}
public Time getShiftStartTime() {
	return shiftStartTime;
}
public void setShiftStartTime(Time shiftStartTime) {
	this.shiftStartTime = shiftStartTime;
}
public Time getShiftEndTime() {
	return shiftEndTime;
}
public void setShiftEndTime(Time shiftEndTime) {
	this.shiftEndTime = shiftEndTime;
}
public int getModifyBy() {
	return modifyBy;
}
public void setModifyBy(int modifyBy) {
	this.modifyBy = modifyBy;
}
public String getWeekOff() {
	return weekOff;
}
public void setWeekOff(String weekOff) {
	this.weekOff = weekOff;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
@Override
public String toString() {
	return "ShiftTime [shiftId=" + shiftId + ", startDate=" + startDate + ", endDate=" + endDate + ", shiftStartTime="
			+ shiftStartTime + ", shiftEndTime=" + shiftEndTime + ", modifyBy=" + modifyBy + ", weekOff=" + weekOff
			+ ", employee=" + employee + "]";
}




}
