package com.naresh.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.naresh.task.ModelTrainer;

@ComponentScan({ "com.naresh" })
@EntityScan("com.naresh")
@EnableJpaRepositories("com.naresh")
@SpringBootApplication
@EnableScheduling
public class SchedulingSpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingSpringBootExampleApplication.class, args);
	}

}
