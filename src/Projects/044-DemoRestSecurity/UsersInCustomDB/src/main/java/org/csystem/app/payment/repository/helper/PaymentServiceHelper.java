package org.csystem.app.payment.repository.helper;

import lombok.AllArgsConstructor;
import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceHelper {
    private final IUserRepository m_userRepository;
    //...

    public UserDto addUser(UserDto userDto)
    {
        return m_userRepository.save(userDto);
    }

    public UserDto registerUser(UserDto userDto)
    {
        return m_userRepository.register(userDto);
    }

    public void updateUser(UserDto userDto)
    {
        m_userRepository.update(userDto);
    }

    public boolean updatePassword(UserDto userDto)
    {
        return m_userRepository.updatePassword(userDto);
    }
}
