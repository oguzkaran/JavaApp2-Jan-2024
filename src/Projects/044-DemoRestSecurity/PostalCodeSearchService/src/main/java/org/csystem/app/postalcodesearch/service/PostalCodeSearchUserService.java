package org.csystem.app.postalcodesearch.service;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.postalcodesearch.dto.user.UserDto;
import org.csystem.app.postalcodesearch.repository.helper.PostalCodeSearchServiceHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
@Accessors(prefix = "m_")
public class PostalCodeSearchUserService {
    private final PostalCodeSearchServiceHelper m_postalCodeSearchServiceHelper;

    //...

    public UserDto addUser(UserDto userDto)
    {
        return m_postalCodeSearchServiceHelper.addUser(userDto);
    }

    public Optional<UserDto> findByUsername(String username)
    {
        return m_postalCodeSearchServiceHelper.finedByUsername(username);
    }

    public UserDto register(UserDto registerDto)
    {
        //...
        return m_postalCodeSearchServiceHelper.registerUser(registerDto);
    }

    public void updateUser(UserDto userDto)
    {
        //...
        m_postalCodeSearchServiceHelper.updateUser(userDto);
    }

    public boolean updatePassword(UserDto userDto)
    {
        //...
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Username : {}", username);

        userDto.setUsername(username);

        return m_postalCodeSearchServiceHelper.updatePassword(userDto);
    }

    //...
}
