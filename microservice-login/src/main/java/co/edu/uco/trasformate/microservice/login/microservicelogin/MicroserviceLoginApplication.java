package co.edu.uco.trasformate.microservice.login.microservicelogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceLoginApplication.class, args);
	}

}
