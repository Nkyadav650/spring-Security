package com.Employee.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Entity.Employee;
import com.Employee.Entity.ShiftTime;
import com.Employee.Repo.EmployeeRepo;
import com.Employee.Repo.ShiftTimeRepo;

@Service
public class EmpServiceImp implements EmpService {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private ShiftTimeRepo shiftRepo;

	// for save employee details  $
	@Override
	public Employee saveEmpShift(Employee emp) {
		Employee employee=empRepo.save(emp);
		return employee;
	}
// for get employee Details with shift Details	$
	@Override
	public Employee getEmp(Integer empId) {	
		Employee employee=empRepo.findById(empId).get();
		
		return employee;
		}
// //for Update Employee ShiftDetails by shiftyID And EmpId		$
	@Override
	public Employee updateEmp(Integer  empId,Integer shiftId) {
		List<ShiftTime> shiftList=new ArrayList<>();
		Employee employee=empRepo.findById(empId).get();
		String status=employee.getStatus();
		
		if(status.equalsIgnoreCase("Active")) {
			ShiftTime shift=shiftRepo.findById(shiftId).get();
		ShiftTime shiftTime=new ShiftTime();
		shiftTime.setStartDate(shift.getStartDate());
		shiftTime.setEndDate(shift.getEndDate());
		shiftTime.setModifyBy(empId);
		shiftTime.setShiftStartTime(shift.getShiftEndTime());
		shiftTime.setShiftEndTime(shift.getShiftEndTime());
		shiftTime.setWeekOff(shift.getWeekOff());
		
		shiftList.add(shiftTime);
		employee.setShift(shiftList);
		return empRepo.save( employee);
	}
		return null;
	}
	
// for Remove Employee		$
	@Override
	public void deleteEmp(Integer empId) {
		Employee employee=empRepo.findById(empId).get();
		Employee emp=new Employee();
		String status=employee.getStatus();
		if(status.equalsIgnoreCase("active")) {
		emp.setEmpId(employee.getEmpId());
		emp.setEmpName(employee.getEmpName());
		emp.setDoj(	employee.getDoj(), empId, false, null, null);
		emp.setNumber(employee.getNumber());
		emp.setAbout(employee.getAbout());
		emp.setDelete(true);
		emp.setStatus("Inactive");
		empRepo.save(emp);
		}
		
	}
// for All Active Employee		$
	@Override
	public List<Employee> getAllEmp() {
		List<Employee> employee= empRepo.findAll();
		return employee;
		
	}

	@Override
	public Map<Employee,ShiftTime> getEmpShift(Integer empId, Integer shiftId) {
		Employee employee=empRepo.findById(empId).get();
		String status=employee.getStatus();
		Map<Employee,ShiftTime>empShift= new HashMap<>();
		if(status.equalsIgnoreCase("Active")) {
		ShiftTime shiftTime=shiftRepo.findById(shiftId).get();
		
		empShift.put(employee, shiftTime);
		}
		return empShift;
		
	}
	
// 		For All Deleted Employee Data 	$
	
	@Override
	public List<Employee> getAllDelete() {
		List<Employee> employee1= empRepo.findAll();
		List<Employee> empList=new ArrayList<>();
		for(Employee employee:employee1) {
		String status=employee.getStatus();
		if(!status.equalsIgnoreCase("Active")) {
			
			empList.add(employee);
			
		}
		}
		return empList;
	}
	
	// For Retrive Latest Shift Details by empId	$
	@Override
	public ShiftTime getLatestShiftByEmpId(Integer empId) {
       
        return shiftRepo.findLatestShiftTimeByEmpId(empId);
    }
    
	


	

	
}
