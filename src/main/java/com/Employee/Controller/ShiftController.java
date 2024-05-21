package com.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Entity.Employee;
import com.Employee.Entity.ShiftTime;
import com.Employee.Repo.EmployeeRepo;
import com.Employee.Repo.ShiftTimeRepo;
import com.Employee.Service.ShiftTimeService;

@RestController
public class ShiftController {
	@Autowired
	private ShiftTimeService stService;

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private ShiftTimeRepo shiftRepo;

	//Create shift based on empId
	
	@PostMapping("saveShift/{empId}")
	public ShiftTime saveShift(@RequestBody ShiftTime shift, @PathVariable Integer empId) throws Exception {
		Employee employee = empRepo.findById(empId).orElseThrow(() -> new Exception("Employee not found"));
		
		String status=employee.getStatus();
		if(status.equalsIgnoreCase("active")) {
		shift.setEmployee(employee);
		shift.setModifyBy(empId);
		ShiftTime shift1 = shiftRepo.save(shift);
		return shift1;
		}
		return null;
	}

	//for All  shift details based on shiftId
	@GetMapping("/getShift/{shiftId}")
	public ShiftTime getShift(@PathVariable Integer shiftId) {
		return stService.getShift(shiftId);
	}
	// for All  shift details based on empid
	@GetMapping("/{empId}")
	public List<ShiftTime>  getShifts( @PathVariable Integer empId) throws Exception {
		return stService.getAllShifts(empId);
		
	}
	
	//for current Shift details
		
	
	
	
	/*
	 * @GetMapping("/current/{empId}") public List<ShiftTime>
	 * getCurrentShiftDetails(@PathVariable Integer empId) {
	 * List<ShiftTime>shiftList= stService.getCurrentShiftDetails(empId); return
	 * shiftList ;;;     }
	 */

	
}
