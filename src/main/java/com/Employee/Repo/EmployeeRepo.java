package com.Employee.Repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.Entity.Employee;
import com.Employee.Entity.ShiftTime;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	



}
