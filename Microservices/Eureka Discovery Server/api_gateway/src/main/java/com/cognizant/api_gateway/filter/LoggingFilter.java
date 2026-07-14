package com.cognizant.api_gateway.filter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    @Override
    public org.springframework.web.server.ServerWebExchange filter(
            org.springframework.web.server.ServerWebExchange exchange,
            org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {

        System.out.println("Incoming Request: "
                + exchange.getRequest().getMethod()
                + " "
                + exchange.getRequest().getURI());

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
