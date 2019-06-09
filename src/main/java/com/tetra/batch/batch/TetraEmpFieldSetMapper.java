/**
 * 
 */
package com.tetra.batch.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.tetra.batch.entity.TetraEmployee;

/**
 * @author KVBhaskar
 *
 */
public class TetraEmpFieldSetMapper implements FieldSetMapper<TetraEmployee> {

	@Override
	public TetraEmployee mapFieldSet(FieldSet fieldSet) throws BindException {
		TetraEmployee tetraEmp = new TetraEmployee();
		tetraEmp.setEmpId(fieldSet.readString(0));
		tetraEmp.setEmpName(fieldSet.readString(1));
		tetraEmp.setEmpAge(fieldSet.readInt(2));
		return tetraEmp;
	}

}
