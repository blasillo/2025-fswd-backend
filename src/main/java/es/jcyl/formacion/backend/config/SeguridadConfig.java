package es.jcyl.formacion.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SeguridadConfig {




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Habilita autenticación mediante formulario
        http
            .csrf(csrf -> csrf.disable()) // Desactiva CSRF
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())) // Configura frameOptions
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/v1/actuator/**","/actuator/**").permitAll()
                    .requestMatchers("/api/v1/**","/tareas/**").permitAll()
                    .anyRequest().authenticated() // Todo lo demás requiere autenticación
            )
            .formLogin(AbstractAuthenticationFilterConfigurer::permitAll )// Permite acceso al formulario de login para todos
            .httpBasic(httpBasic -> {}); // Habilita autenticación HTTP Basic

        return http.build();

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin1234")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }



}
