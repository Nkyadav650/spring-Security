package com.Employee.Service;

import java.util.List;

import com.Employee.Entity.Employee;
import com.Employee.Entity.ShiftTime;

public interface ShiftTimeService {
	
	public Employee saveShift(ShiftTime shift,Integer empId);
public List<ShiftTime> getAllShiftByEmpId(Integer modifyBy,Integer empId);
public ShiftTime getShift(Integer shiftId);
public void deleteShift(Integer empId);
public List<ShiftTime> getAllShift();
public ShiftTime updateShift(ShiftTime shift);
public List<ShiftTime> getAllShifts(Integer empId);
public List<ShiftTime> getCurrentShiftDetails(Integer empId);
}
