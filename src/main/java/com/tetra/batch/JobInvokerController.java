package com.tetra.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobInvokerController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	@Qualifier("userJob")
	Job accountKeeperJob;
	
	@Autowired
	@Qualifier("empJob")
	Job employeeJob;

	@RequestMapping("/run-batch-job1")
	public String batchJob1() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder()
				.addString("userJob", "User Job1")
				.toJobParameters();
		jobLauncher.run(accountKeeperJob, jobParameters);

		return "Batch job has been invoked";
	}
	
	@RequestMapping("/run-batch-job2")
	public String batchJob2() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder()
				.addString("employeeJob", "Emp Job1")
				.toJobParameters();
		jobLauncher.run(employeeJob, jobParameters);

		return "Batch job has been invoked";
	}
}