package org.csystem.app.payment.service;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.dto.user.RegisterDto;
import org.csystem.app.payment.dto.user.UpdatePasswordDto;
import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.dto.user.UserUpdateDto;
import org.csystem.app.payment.repository.helper.PaymentServiceHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

    public RegisterDto register(RegisterDto registerDto)
    {
        //...
        return m_paymentServiceHelper.registerUser(registerDto);
    }

    public void updateUser(UserUpdateDto userUpdateDto)
    {
        //...
        m_paymentServiceHelper.updateUser(userUpdateDto);
    }

    public boolean updatePassword(UpdatePasswordDto updatePasswordDto)
    {
        //...
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Username : {}", username);

        updatePasswordDto.setUsername(username);

        return m_paymentServiceHelper.updatePassword(updatePasswordDto);
    }

    //...
}
