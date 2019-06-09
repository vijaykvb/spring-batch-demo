package com.tetra.batch.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.tetra.batch.entity.Employee;
import com.tetra.batch.entity.Users;

@Component
public class AccountKeeperJob extends JobExecutionListenerSupport {

	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;

	@Value("${input.user.file}")
	Resource resource;
	
	@Value("${input.emp.file}")
	Resource empResource;
	

	@Autowired
	Processor processor;

	@Autowired
	Writer writer;
	
	@Autowired
	EmployeeWriter empWriter;
	
	@Autowired
	EmployeeProcessor empProcess;
	
	@Bean(name = "userJob")
	public Job userAccoundJob() {

		Step step = stepBuilderFactory.get("step-1").<Users, Users>chunk(1).reader(new Reader(resource))
				.processor(processor).writer(writer).build();

		/*
		 * Step step2 = stepBuilderFactory.get("step-2").<Users,
		 * Users>chunk(2).reader(new Reader(resource))
		 * .processor(processor).writer(writer).build();
		 * 
		 * Step stepLast = stepBuilderFactory.get("step-3").<Users,
		 * Users>chunk(3).reader(new Reader(resource))
		 * .processor(processor).writer(writer).build();
		 */

		Job job = jobBuilderFactory.get("accounting-job").incrementer(new RunIdIncrementer()).listener(this).start(step)
				/* .next(step2).next(stepLast) */.build();

		return job;
	}

	@Bean(name = "empJob")
	public Job employeerDBJob() {

		Step firstStep = stepBuilderFactory.get("step1").<Employee, Employee>chunk(1).reader(new EmployeeReader(empResource))
				.processor(empProcess).writer(empWriter).build();

		Job job = jobBuilderFactory.get("amount - job").incrementer(new RunIdIncrementer())
				.listener(this)
				.start(firstStep)
				.build();

		return job;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {
			System.out.println("BATCH JOB FAILED");
		}
	}

}
