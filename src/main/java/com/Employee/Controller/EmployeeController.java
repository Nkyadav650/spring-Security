package com.Employee.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Dto.EmployeePayload;
import com.Employee.Entity.Employee;
import com.Employee.Entity.ShiftTime;
import com.Employee.Service.EmpService;

@RestController
public class EmployeeController {

	@Autowired
	private EmpService empService;

	// Employee save Controller 	$
	@PostMapping("/saveEmp")
	public Employee saveEmp(@RequestBody Employee emp) {
		Employee employee = empService.saveEmpShift(emp);
		return employee;
	}

	//for find the Employee details Based on empId		$
	@GetMapping("/getEmpShift/{empId}")
	public Employee getEmpShift(@PathVariable Integer empId) {
		Employee employee = empService.getEmp(empId);
		String status=employee.getStatus();
		if(status.equalsIgnoreCase("active")) {
		return employee;
	}else {
		String message="Employee InActive";
		System.out.println(message);
	}
		return null;
	}
	
	//for only employee  $
	@GetMapping("/getEmp/{empId}")
	public EmployeePayload getEmp(@PathVariable Integer empId) {
		Employee employee = empService.getEmp(empId);
		String status=employee.getStatus();
		if(status.equalsIgnoreCase("active")) {
			EmployeePayload emp=new EmployeePayload();
			emp.setEmpId(employee.getEmpId());
			emp.setEmpName(employee.getEmpName());
			emp.setDoj(	employee.getDoj());
			emp.setDelete(employee.isDelete());
			emp.setNumber(employee.getNumber());
			emp.setStatus(status);
			emp.setAbout(employee.getAbout());
		
		return emp;
	}
		return null;
	}
	
	//for Update Employee ShiftDetails by shiftyID And EmpId	$
	
	@PutMapping("/updateShift/{empId}/{shiftId}")
	public ResponseEntity<Employee> updateEmp(@PathVariable Integer empId,@PathVariable Integer shiftId){
		Employee employee=empService.updateEmp( empId, shiftId);
		
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	
//	for delete Employee Details based on empId  $
	
	@DeleteMapping("delete/{empId}")
	public String deleteEmp(@PathVariable Integer empId) {
		Employee employee = empService.getEmp(empId);
		String status=employee.getStatus();
		if(status.equalsIgnoreCase("active")) {
		empService.deleteEmp(empId);
		return "Data Deleted successfully";
		}
		return "Data not available";
	}
	
// for find All deleted Employee Details	$
	@GetMapping("/getAllDelete")
	public List<EmployeePayload> getAllDelete(){
		List<Employee> employee1= empService.getAllDelete();
		List<EmployeePayload> empList= new ArrayList<>();
		for(Employee employee:employee1) {
			EmployeePayload emp=new EmployeePayload();
			emp.setEmpId(employee.getEmpId());
			emp.setEmpName(employee.getEmpName());
			emp.setDoj(	employee.getDoj());
			emp.setDelete(employee.isDelete());
			emp.setNumber(employee.getNumber());
			emp.setStatus(employee.getStatus());
			emp.setAbout(employee.getAbout());
		empList.add(emp);
		}
		return empList;
	}
	
// 	for Retrieve All active  Employee   $
	
	@GetMapping("/allEmployee")
	public List<EmployeePayload> getAllEmp() {
		List<Employee> employee1 = empService.getAllEmp();
		
		
		List<EmployeePayload>epList=new ArrayList<>();
		
		for(Employee employee:employee1) {
			EmployeePayload emp=new EmployeePayload();
			String status=employee.getStatus();
		if(status.equalsIgnoreCase("active")) {
			
			emp.setEmpId(employee.getEmpId());
			emp.setEmpName(employee.getEmpName());
			emp.setDoj(	employee.getDoj());
			emp.setDelete(employee.isDelete());
			emp.setNumber(employee.getNumber());
			emp.setStatus(status);
			emp.setAbout(employee.getAbout());
		epList.add(emp);
		
	}
		}
		return epList;
	}
	
	//for finding latest shiftId	$
	
	@GetMapping("/getLatestShift/{empId}")
    public ResponseEntity<ShiftTime> getLatestShift(@PathVariable Integer empId) {
        ShiftTime latestShift = empService.getLatestShiftByEmpId(empId);
        
        if (latestShift != null) {
            return ResponseEntity.ok(latestShift);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
}
