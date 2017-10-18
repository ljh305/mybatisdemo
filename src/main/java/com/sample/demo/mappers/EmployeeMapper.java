package com.sample.demo.mappers;

import java.util.List;

import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

public interface EmployeeMapper {
	
	List<Employee> getEmployees(Criteria c);
}
