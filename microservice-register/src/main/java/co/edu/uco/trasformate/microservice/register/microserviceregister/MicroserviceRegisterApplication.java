package co.edu.uco.trasformate.microservice.register.microserviceregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRegisterApplication.class, args);
	}

}
