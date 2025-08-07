package com.cg.eis.pl;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService1;


	public class EmployeeServiceImpl implements EmployeeService1 {

	    public String findInsuranceScheme(double salary, String designation) {
	        if (salary > 50000 && designation.equalsIgnoreCase("Manager")) {
	            return "Platinum";
	        } else if (salary > 30000 && designation.equalsIgnoreCase("Lead")) {
	            return "Gold";
	        } else if (salary > 20000 && designation.equalsIgnoreCase("Developer")) {
	            return "Silver";
	        } else {
	            return "No Scheme";
	        }
	    }
	

	public String findInsuranceScheme1(double salary, String designation) {
		// TODO Auto-generated method stub
		return null;
	}

	}

