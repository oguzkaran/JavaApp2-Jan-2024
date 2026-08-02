package org.csystem.app.postalcodesearch.service.security;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.postalcodesearch.repository.IUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Accessors(prefix = "m_")
@Slf4j
public class PostalCodeSearchUserDetailsService implements UserDetailsService {
    private final IUserRepository m_userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        var userOpt = m_userRepository.findUserDetailsByUsername(username);
        var userDto = userOpt.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(userDto.getUsername(), userDto.getPassword(), Collections.emptyList());
    }
}
