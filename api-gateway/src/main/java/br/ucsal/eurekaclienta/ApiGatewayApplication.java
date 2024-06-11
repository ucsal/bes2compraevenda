package br.ucsal.eurekaclienta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("order_service", r -> r.path("/order/**")
						.uri("lb://EUREKA-CLIENT-A"))
				.route("payment_service", r -> r.path("/payment/**")
						.uri("lb://EUREKA-CLIENT-B"))
				.route("shipping_service", r -> r.path("/shipping/**")
						.uri("lb://EUREKA-CLIENT-C"))
				.build();
	}
}
