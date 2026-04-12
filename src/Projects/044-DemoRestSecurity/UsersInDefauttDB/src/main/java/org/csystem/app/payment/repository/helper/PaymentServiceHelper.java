package org.csystem.app.payment.repository.helper;

import lombok.AllArgsConstructor;
import org.csystem.app.payment.dto.UserDto;
import org.csystem.app.payment.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceHelper {
    private final IUserRepository m_userRepository;

    //...

    public UserDto addUser(UserDto userDto)
    {
        return m_userRepository.saveUser(userDto);
    }
}
