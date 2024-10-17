package com.programming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy  // This annotation enables supports for handling the components marked with @Aspect annotation.
public class SpringBootTransactionPropagationsAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionPropagationsAopApplication.class, args);
	}

}
