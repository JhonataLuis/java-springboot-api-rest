package study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Initializr
 * Os seguintes módulos foram selecionados:
 * Spring Data JPA
 * Spring Web
 * PostgreSQL Database
 * OpenFeign
 * 
 * @author Jhonata
 */

@EnableFeignClients
@SpringBootApplication
public class JavaSpringbootApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringbootApiRestApplication.class, args);
	}

}
