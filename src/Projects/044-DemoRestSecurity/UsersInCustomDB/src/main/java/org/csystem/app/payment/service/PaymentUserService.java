package org.csystem.app.payment.service;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.repository.helper.PaymentServiceHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
@Accessors(prefix = "m_")
public class PaymentUserService {
    private final PaymentServiceHelper m_paymentServiceHelper;

    //...

    public UserDto addUser(UserDto userDto)
    {
        return m_paymentServiceHelper.addUser(userDto);
    }

    public Optional<UserDto> findByUsername(String username)
    {
        return m_paymentServiceHelper.finedByUsername(username);
    }

    public UserDto register(UserDto registerDto)
    {
        //...
        return m_paymentServiceHelper.registerUser(registerDto);
    }

    public void updateUser(UserDto userDto)
    {
        //...
        m_paymentServiceHelper.updateUser(userDto);
    }

    public boolean updatePassword(UserDto userDto)
    {
        //...
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Username : {}", username);

        userDto.setUsername(username);

        return m_paymentServiceHelper.updatePassword(userDto);
    }

    //...
}
