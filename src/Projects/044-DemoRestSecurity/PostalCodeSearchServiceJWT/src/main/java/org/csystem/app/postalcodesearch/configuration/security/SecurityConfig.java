package org.csystem.app.postalcodesearch.configuration.security;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.postalcodesearch.security.entrypoint.PostalCodeSearchAuthEntryPoint;
import org.csystem.app.postalcodesearch.security.filter.PostalCodeSearchAuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
@Accessors(prefix = "m_")
@Slf4j
public class SecurityConfig {
    private final PasswordEncoder m_passwordEncoder;
    private final DataSource m_datasource;
    private final PostalCodeSearchAuthTokenFilter m_postalCodeSearchAuthTokenFilter;
    private final PostalCodeSearchAuthEntryPoint m_postalCodeSearchAuthEntryPoint;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable)
                .exceptionHandling(eh -> eh.authenticationEntryPoint(m_postalCodeSearchAuthEntryPoint))
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(a -> a.requestMatchers("/postalcodesearch/users/login", "/postalcodesearch/users/register").permitAll()
                        .anyRequest().authenticated());

        http.addFilterBefore(m_postalCodeSearchAuthTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.jdbcAuthentication()
                .dataSource(m_datasource)
                .usersByUsernameQuery("select * from find_user_by_username_for_auth(?)")
                .authoritiesByUsernameQuery("select * from find_authorities_by_username_for_auth(?)");
    }
}
