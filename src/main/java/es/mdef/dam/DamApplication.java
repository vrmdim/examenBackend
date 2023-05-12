package es.mdef.dam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DamApplication {
	
	public static final Logger log = LoggerFactory.getLogger(DamApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DamApplication.class, args);
	}

}
