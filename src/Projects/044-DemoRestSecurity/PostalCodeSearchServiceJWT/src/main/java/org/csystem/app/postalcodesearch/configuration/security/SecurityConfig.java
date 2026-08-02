package org.csystem.app.postalcodesearch.configuration.security;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.postalcodesearch.security.filter.PostalCodeSearchAuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
@Accessors(prefix = "m_")
@Slf4j
public class SecurityConfig {
    private final PasswordEncoder m_passwordEncoder;
    private final DataSource m_datasource;
    private final PostalCodeSearchAuthTokenFilter m_postalCodeSearchAuthTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(a -> a.requestMatchers("/postalcodesearch/users/register").permitAll().anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        http.addFilterBefore(m_postalCodeSearchAuthTokenFilter, PostalCodeSearchAuthTokenFilter.class);

        //..

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
