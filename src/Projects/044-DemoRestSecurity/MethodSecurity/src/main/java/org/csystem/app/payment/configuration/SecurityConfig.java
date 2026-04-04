package org.csystem.app.payment.configuration;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

@AllArgsConstructor
@Accessors(prefix = "m_")
@Slf4j
public class SecurityConfig {
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";
    private static final String ROLE_VIEWER = "VIEWER";

    private final PasswordEncoder m_passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(a -> a.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService()
    {
        var admin = User.builder()
                .username("admin")
                .password(m_passwordEncoder.encode("admin"))
                .roles(ROLE_ADMIN)
                .build();

        var payUser = User.builder()
                .username("alican")
                .password(m_passwordEncoder.encode("csd1993"))
                .roles(ROLE_USER)
                .build();

        var payViewer = User.builder()
                .username("bora")
                .password(m_passwordEncoder.encode("csystem1993"))
                .roles(ROLE_VIEWER)
                .build();

        return new InMemoryUserDetailsManager(admin, payUser, payViewer);
    }
}
