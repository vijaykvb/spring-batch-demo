/**
 * 
 */
package com.tetra.batch.batch;

import org.springframework.batch.item.ItemProcessor;

import com.tetra.batch.entity.TetraEmployee;

/**
 * @author KVBhaskar
 *
 */
public class TetraEmpXMLProcessor implements ItemProcessor<TetraEmployee, TetraEmployee> {

	@Override
	public TetraEmployee process(TetraEmployee tetraEmp) throws Exception {
		System.out.println("Processing starts : " + tetraEmp);

		// Only return employee who are having more than 30 years of age.
		if (tetraEmp.getEmpAge() > 30 ) {
			return tetraEmp;
		}
		return null;
	}

}
