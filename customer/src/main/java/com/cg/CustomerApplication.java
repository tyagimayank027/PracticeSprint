package com.cg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.ui.CustomerMain;


@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(CustomerApplication.class, args);
		CustomerMain c= context.getBean(CustomerMain.class);
		c.start();
	}

}
