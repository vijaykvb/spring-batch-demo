/**
 * 
 */
package com.tetra.batch.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.tetra.batch.entity.Employee;
import com.tetra.batch.entity.Users;

/**
 * @author KVBhaskar
 *
 */
public class EmployeeReader extends FlatFileItemReader<Employee> {

	public EmployeeReader(Resource resource) {
		super();
		setResource(resource);

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "empId", "empName", "empAddress", "empDesignation", "empSalary" });
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);

		BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Employee.class);

		DefaultLineMapper<Employee> defaultLineMapper = new DefaultLineMapper<>();
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		setLineMapper(defaultLineMapper);
	}

}
