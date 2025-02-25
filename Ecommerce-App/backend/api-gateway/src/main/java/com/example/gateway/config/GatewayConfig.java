package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("user-service", r -> r.path("/api/users/**")
                .uri("lb://USER-SERVICE"))
            .route("product-service", r -> r.path("/api/products/**")
                .uri("lb://PRODUCT-SERVICE"))
            .route("order-service", r -> r.path("/api/orders/**")
                .uri("lb://ORDER-SERVICE"))
            .route("payment-service", r -> r.path("/api/payments/**")
                .uri("lb://PAYMENT-SERVICE"))
            .build();
    }
}
