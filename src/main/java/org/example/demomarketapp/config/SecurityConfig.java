package org.example.demomarketapp.config;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import org.example.demomarketapp.util.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig {

  public static final String ACTUATOR_PATH = "/actuator/**";
  public static final String AUTH_PATH = "/auth/**";
  public static final String SWAGGER_UI_PATH = "/market/v3/swagger-ui/**";
  public static final String SWAGGER_UI_HTML_PATH = "/market/v3/swagger-ui.html";
  public static final String V_3_API_DOCS_PATH = "/market/v3/api-docs/**";
  public static final String V_3_API_DOCS_YAML_PATH = "/market/v3/api-docs.yaml";
  public static final String ERROR = "/error";


  @Bean
  public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http,
      JwtRequestFilter jwtRequestFilter)
      throws Exception {

    List<String> permitAllMatchers = new ArrayList<>(
        asList(ACTUATOR_PATH, AUTH_PATH, SWAGGER_UI_PATH, V_3_API_DOCS_PATH, V_3_API_DOCS_YAML_PATH,
            ERROR, SWAGGER_UI_HTML_PATH));

    return http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(permitAllMatchers.toArray(new String[0]))
            .permitAll()
            .requestMatchers("/market/admin/**")
            .hasAnyRole("ADMIN", "SUPERADMIN")
            .anyRequest()
            .authenticated())
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf(AbstractHttpConfigurer::disable)
        .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(
      AuthenticationConfiguration authenticationConfiguration)
      throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }
}
