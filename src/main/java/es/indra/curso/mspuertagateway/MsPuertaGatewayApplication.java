package es.indra.curso.mspuertagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsPuertaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPuertaGatewayApplication.class, args);
	}

}
