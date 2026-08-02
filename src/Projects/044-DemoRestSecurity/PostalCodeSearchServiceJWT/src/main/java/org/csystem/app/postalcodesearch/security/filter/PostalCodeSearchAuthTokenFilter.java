package org.csystem.app.postalcodesearch.security.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.postalcodesearch.security.helper.JwtHelper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
@Accessors(prefix = "m_")
public class PostalCodeSearchAuthTokenFilter extends OncePerRequestFilter {
    private final UserDetailsService m_userDetailsService;
    private final JwtHelper m_jwtHelper;

    private String fetchToken(HttpServletRequest request)
    {
        var authHeader = request.getHeader("Authorization");

        return authHeader != null && authHeader.startsWith("Bearer ") ? authHeader.substring(7) : null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        try {
            var token = fetchToken(request);

            if (token != null && m_jwtHelper.isValidToken(token)) {
                var username = m_jwtHelper.generateUsernameByToken(token);

                log.debug("Fetching username from token: {}", username);

                var userDetails = m_userDetailsService.loadUserByUsername(username);
                var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        catch (Exception e) {
            log.error("Error occurred in doFilterInternal:{}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
}
