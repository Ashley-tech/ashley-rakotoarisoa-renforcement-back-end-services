package com.example.oauth.component;

import static org.springframework.boot.http.client.ClientHttpRequestFactoryBuilder.reactor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

import com.example.oauth.service.JwtService;

@Component
public class AuthentificationFilter implements WebFilter {
    private final JwtService jwtService;

    public AuthentificationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        // Autoriser /auth/** sans authentification
        if (request.getURI().getPath().startsWith("/auth")) {
            return chain.filter(exchange);
        }

        // Vérifier la présence du header Authorization
        if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            return unauthorizedResponse(exchange);
        }

        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return unauthorizedResponse(exchange);
        }

        String token = authHeader.substring(7);
        if (!jwtService.validateToken(token)) {
            return unauthorizedResponse(exchange);
        }

        return chain.filter(exchange);
    }

    private Mono<Void> unauthorizedResponse(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }
}