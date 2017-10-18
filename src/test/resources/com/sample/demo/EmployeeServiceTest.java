package com.sample.demo;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.demo.service.EmployeeService;
import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/META-INF/spring/app-context.xml"})
public class EmployeeServiceTest {
	
	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void testGetEmployees() {
		String opt = "name";
		String keyword = "Hong";
		
		List<Integer> depts = Arrays.asList(50, 60, 80, 90);
		List<String> jobs = Arrays.asList("AD_PRES", "AD_VP", "IT_PROG", "ST_CLERK");
		Long minSalary = new Long(3000);
		Long maxSalary = new Long(20000);
		String beginDate = "2005-07-01";
		String endDate = "2007-08-31";
		
		Criteria c1 = new Criteria();
		c1.setOpt(opt);
		c1.setKeyword(keyword);
		List<Employee> result = employeeService.getEmployees(c1);
		assertEquals(1, result.size());
		
		Criteria c2 = new Criteria();
		c2.setDepts(depts);
		assertEquals(87, employeeService.getEmployees(c2).size());
		
		Criteria c3 = new Criteria();
		c3.setJobs(jobs);
		assertEquals(28, employeeService.getEmployees(c3).size());
		
		Criteria c4 = new Criteria();
		c4.setMinSalary(minSalary);
		c4.setMaxSalary(maxSalary);
		assertEquals(101, employeeService.getEmployees(c4).size());
		
		Criteria c5 = new Criteria();
		c5.setBeginDate(beginDate);
		c5.setEndDate(endDate);
		assertEquals(52, employeeService.getEmployees(c5).size());
	}
}
