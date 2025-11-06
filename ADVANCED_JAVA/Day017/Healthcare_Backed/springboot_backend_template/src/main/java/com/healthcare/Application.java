package com.healthcare;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper(); // default
		mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull()) // only not null properties allow
				.setMatchingStrategy(MatchingStrategies.STRICT);

		return mapper;
	}

}
