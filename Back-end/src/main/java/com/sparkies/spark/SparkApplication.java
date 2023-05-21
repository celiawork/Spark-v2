package com.sparkies.spark;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sparkies.spark.security.PasswordEncoder;

@SpringBootApplication
public class SparkApplication {


	public static void main(String[] args) throws IOException {
		SpringApplication.run(SparkApplication.class, args);

	}

}
