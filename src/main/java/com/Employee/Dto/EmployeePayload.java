package com.Employee.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeePayload {

	private int empId;
	private String empName;
	private Date doj;
	private long number;
	private boolean isDelete;
	private String status;
	private String about;
}
