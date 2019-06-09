/**
 * 
 */
package com.tetra.batch.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tetra.batch.entity.Employee;
import com.tetra.batch.repository.EmployeeRepository;

/**
 * @author KVBhaskar
 *
 */
@Component
public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee process(Employee employee) throws Exception {
		Optional<Employee> employeeFromDB = empRepo.findById(employee.getEmpId());
		if (employeeFromDB.isPresent()) {
			employee.setEmpSalary(employeeFromDB.get().getEmpSalary());
		}
		return employee;
	}

}
