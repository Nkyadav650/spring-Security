package com.Employee.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Employee.Entity.Employee;
import com.Employee.Entity.ShiftTime;
import com.Employee.Repo.EmployeeRepo;
import com.Employee.Repo.ShiftTimeRepo;

@Service
public class ShiftTimeServiceIme implements ShiftTimeService {

	@Autowired
	private ShiftTimeRepo shiftRepo;
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public ShiftTime getShift(Integer shiftId) {
		
		return shiftRepo.findById(shiftId).get();
	}
	@Override
	public void deleteShift(Integer empId) {
		
	}
	
	@Override
	public List<ShiftTime> getAllShift() {
		
		return null;
	}
	@Override
	public ShiftTime updateShift(ShiftTime shift) {
		// TODO Auto-generated method stub
		return null;
	}
	// it is for saving shift values based on empId
	@Override
	public Employee saveShift(ShiftTime shift,Integer empId) {
		List<ShiftTime> shiftList=new ArrayList<>();
		Employee employee=empRepo.findById(empId).get();
		String status=employee.getStatus();
		if(status.equalsIgnoreCase("Active")) {
		ShiftTime shiftTime=new ShiftTime();
		shiftTime.setStartDate(shift.getStartDate());
		shiftTime.setEndDate(shift.getEndDate());
		shiftTime.setModifyBy(empId);
		shiftTime.setShiftStartTime(shift.getShiftEndTime());
		shiftTime.setShiftEndTime(shift.getShiftEndTime());
		shiftTime.setWeekOff(shift.getWeekOff());
		shiftList.add(shiftTime);
		employee.setShift(shiftList);
		return empRepo.save(employee);
		}
		return null;
	}
	
	
	@Override
	public List<ShiftTime> getAllShiftByEmpId(Integer modifyBy,Integer empId) {
	  ShiftTime shift=shiftRepo.findById(modifyBy).get();
	  Employee employee=empRepo.findById(empId).get();
	  String status=employee.getStatus();
	  List<ShiftTime>shiftList=new ArrayList<>();
	  shiftList.add(shift);
	  List<ShiftTime>shiftl=  shiftList.stream().filter((statuss)->status.equalsIgnoreCase("Active")).collect(Collectors.toList()); 
	return shiftl;
	}
	 
	//for getting All "shift values" based on 'empId'
	@Override
	public List<ShiftTime> getAllShifts(Integer empId) {
		Employee employee=empRepo.findById(empId).get();
		String status=employee.getStatus();
		if(status.equalsIgnoreCase("Active")) {
		return shiftRepo.findByEmployeeEmpId(empId);
	}
		return null;
	}
	@Override
	public List<ShiftTime> getCurrentShiftDetails(Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * public List<ShiftTime> getCurrentShiftDetails(Integer empId) { LocalDate
	 * currentDate = LocalDate.now(); return shiftRepo.
	 * findByEmployee_IdAndStartDateLessThanEqualAndEndDateGreaterThanEqual( empId,
	 * currentDate, currentDate);     }
	 */
}
