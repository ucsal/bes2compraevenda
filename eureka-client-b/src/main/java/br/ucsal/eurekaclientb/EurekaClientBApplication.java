package br.ucsal.eurekaclientb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientBApplication {

	// payment service aqq

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientBApplication.class, args);
	}

}
