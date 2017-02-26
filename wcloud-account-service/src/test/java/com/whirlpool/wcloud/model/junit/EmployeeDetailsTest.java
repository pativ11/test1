package com.whirlpool.wcloud.model.junit;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.whirlpool.wcloud.controller.EmpBusinessLogic;
import com.whirlpool.wcloud.model.EmployeeDetails;

public class EmployeeDetailsTest {
	   EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
	   EmployeeDetails employee = new EmployeeDetails();

	   @Test
	   public void testCalculateAppriasal() {
	      employee.setName("Rajeev");
	      employee.setAge(25);
	      employee.setMonthlySalary(8000);
			
	      double appraisal = empBusinessLogic.calculateAppraisal(employee);
	      assertEquals(5000, appraisal, 0.0);
	   }

	   // test to check yearly salary
	   @Test
	   public void testCalculateYearlySalary() {
	      employee.setName("Rajeev");
	      employee.setAge(25);
	      employee.setMonthlySalary(8000);
			
	      double salary = empBusinessLogic.calculateYearlySalary(employee);
	      assertEquals(960000, salary, 0.0);
	   }
}

