package dio.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dio.web.api"}) // Inclua todos os pacotes relevantes
public class FirstWebProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstWebProjectApplication.class, args);
	}

}
