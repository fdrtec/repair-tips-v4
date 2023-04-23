package com.api.repairtips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "RepairTips API", version = "4.0", description = "Repair Information"))
public class RepairTipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepairTipsApplication.class, args);
	}

}
