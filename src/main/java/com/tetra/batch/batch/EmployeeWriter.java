/**
 * 
 */
package com.tetra.batch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tetra.batch.entity.Employee;
import com.tetra.batch.repository.EmployeeRepository;

/**
 * @author KVBhaskar
 *
 */
@Component
public class EmployeeWriter implements ItemWriter<Employee> {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void write(List<? extends Employee> employee) throws Exception {
		repo.saveAll(employee);
	}

}
