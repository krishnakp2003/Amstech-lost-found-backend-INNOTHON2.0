package com.lost.found.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSFilter {
	    @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**") // allow all routes
	                        .allowedOrigins("http://localhost:4200") // allow Angular
	                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")

	                        .allowedHeaders("*")
	                        .allowCredentials(true);
	            }
	        };
	    }

	}

