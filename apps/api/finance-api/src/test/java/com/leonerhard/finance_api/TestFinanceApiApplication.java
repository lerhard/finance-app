package com.leonerhard.finance_api;

import org.springframework.boot.SpringApplication;

public class TestFinanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(FinanceApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
