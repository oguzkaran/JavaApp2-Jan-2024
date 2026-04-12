package org.csystem.app.payment.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.dto.UserDto;
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

    public UserDto updateUser(UserDto userDto)
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}
