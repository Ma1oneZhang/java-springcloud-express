package com.express.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzy
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        List<String> allowAccessPattern = new ArrayList<>();
        allowAccessPattern.add("*");
        corsConfiguration.setAllowedOriginPatterns(allowAccessPattern);
        // 1. configure the cors
        corsConfiguration.addAllowedHeader("*");
        // 2. configure access method
        corsConfiguration.addAllowedMethod("*");
        // 3. configure can we access backend with cookie
        corsConfiguration.setAllowCredentials(true);
        // 4. apply settings to all url
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }
}
