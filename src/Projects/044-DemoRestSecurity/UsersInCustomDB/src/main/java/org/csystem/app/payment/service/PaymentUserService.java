package org.csystem.app.payment.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.dto.user.UserUpdateDto;
import org.csystem.app.payment.repository.helper.PaymentServiceHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class PaymentUserService {
    private final PaymentServiceHelper paymentServiceHelper;

    public UserDto addUser(UserDto userDto)
    {
        return paymentServiceHelper.addUser(userDto);
    }

    public void updateUser(UserUpdateDto userUpdateDto)
    {
        paymentServiceHelper.updateUser(userUpdateDto);
    }
}
