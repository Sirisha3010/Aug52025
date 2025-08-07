package com.cg.eis.bean;

public class Employee {
	    private int id;
	    private String name;
	    private double salary;
	    private String designation;
	    private String insuranceScheme;

	    public Employee(int id, String name, double salary, String designation) {
	        this.id = id;
	        this.name = name;
	        this.salary = salary;
	        this.designation = designation;
	    }

	    // Getters and Setters
	    public int getId() { return id; }
	    public String getName() { return name; }
	    public double getSalary() { return salary; }
	    public String getDesignation() { return designation; }
	    public String getInsuranceScheme() { return insuranceScheme; }

	    public void setInsuranceScheme(String insuranceScheme) {
	        this.insuranceScheme = insuranceScheme;
	    }

	    @Override
	    public String toString() {
	        return "Employee Details:\n" +
	               "ID: " + id + "\n" +
	               "Name: " + name + "\n" +
	               "Salary: " + salary + "\n" +
	               "Designation: " + designation + "\n" +
	               "Insurance Scheme: " + insuranceScheme;
	    }
	}


