package dev.djmitrovic.spotifyrecommender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) throws Exception {
        return http.authorizeExchange(exchange -> exchange
                        .pathMatchers("/asd").permitAll()
                        .anyExchange().authenticated()
                ).oauth2Login(Customizer.withDefaults())
                .build();
    }
}
