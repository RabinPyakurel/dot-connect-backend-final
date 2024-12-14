package com.codefestnepal.dotconnect.configuration;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;
@Component
public class CustomCorsConfiguration implements CorsConfigurationSource {

    private @Value("${cors-origins}") String corsOrigins;

    @Override
    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        var list = List.of(corsOrigins.split(","));
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(list);
        config.setAllowedMethods(List.of("*"));

        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);
        return config;
    }
}