package com.stefanmilojevic.myRealEstate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class MyRealEstateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRealEstateApplication.class, args);
	}

}
