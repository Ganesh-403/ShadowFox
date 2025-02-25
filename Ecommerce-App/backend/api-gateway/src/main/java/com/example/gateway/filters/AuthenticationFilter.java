package com.example.gateway.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        // Example: Check if Authorization header is present
        if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }
}
