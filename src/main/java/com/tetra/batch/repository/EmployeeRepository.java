/**
 * 
 */
package com.tetra.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tetra.batch.entity.Employee;

/**
 * @author KVBhaskar
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
