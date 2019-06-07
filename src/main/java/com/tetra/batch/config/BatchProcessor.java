package com.tetra.batch.config;

import org.springframework.batch.item.ItemProcessor;

import com.tetra.batch.model.Employee;

public class BatchProcessor implements ItemProcessor<Employee, Employee> {

	public Employee process(Employee employee) throws Exception {
		System.out.println("Inserting employee : " + employee);
		return employee;
	}
}
