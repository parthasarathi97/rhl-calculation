package RHL.calculation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class CorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        final org.springframework.web.cors.CorsConfiguration corsConfig = new org.springframework.web.cors.CorsConfiguration();
        corsConfig.setAllowedOrigins(List.of("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST"));
        corsConfig.addAllowedHeader("*");
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return new CorsWebFilter(source);
    }

    @Bean
    public WebFilter securityHeadersWebFilter() {
        return (ServerWebExchange exchange, WebFilterChain chain) -> {
            exchange.getResponse().getHeaders().add("X-XSS-Protection", "1; mode=block");
            exchange.getResponse().getHeaders().add("Cache-Control", "no-store");
            exchange.getResponse().getHeaders().add("Pragma", "no-cache");
            return chain.filter(exchange);
        };
    }
}
