package com.ejercicios.configuracion;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. PRIMERO: Activamos la configuración de CORS que definimos abajo
            .cors(Customizer.withDefaults()) // <--- ESTO VA AQUÍ
            
            // 2. SEGUNDO: Desactivamos CSRF (necesario para que funcionen los POST desde Angular)
            .csrf(csrf -> csrf.disable()) 
            
            // 3. TERCERO: Definimos permisos de rutas
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/usuarios/**").permitAll() 
                .requestMatchers("/api/autoescuelas/**").permitAll()
                .anyRequest().authenticated()
            )
            
            // 4. CUARTO: Tipo de autenticación
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // ESTE MÉTODO VA FUERA DEL FILTERCHAIN, PERO DENTRO DE LA CLASE
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Permite que Angular (puerto 4200) se conecte
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        // Permite los métodos que usaremos
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        // Permite las cabeceras estándar y la de autorización
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));
        // Permite enviar cookies o credenciales si fuera necesario
        configuration.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplica a todas las rutas
        return source;
    }
}
