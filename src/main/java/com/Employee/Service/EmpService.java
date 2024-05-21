package com.Employee.Service;

import java.util.List;
import java.util.Map;


import com.Employee.Entity.Employee;
import com.Employee.Entity.ShiftTime;

public interface EmpService {
public Employee saveEmpShift(Employee emp);
public Employee getEmp(Integer empId);

public void deleteEmp(Integer empId);
public List<Employee> getAllDelete();
public List<Employee> getAllEmp();
public Employee updateEmp(Integer empId, Integer shiftId);
public Map<Employee,ShiftTime> getEmpShift(Integer empId, Integer shiftId);
public ShiftTime getLatestShiftByEmpId(Integer empId);
 

}
