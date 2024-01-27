package kr.co.shield;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CoreApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CoreApiApplication.class, args);
	}
	
}
