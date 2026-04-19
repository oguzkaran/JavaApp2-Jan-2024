package org.csystem.app.payment.repository.helper;

import lombok.AllArgsConstructor;
import org.csystem.app.payment.dto.user.RegisterDto;
import org.csystem.app.payment.dto.user.UpdatePasswordDto;
import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.dto.user.UserUpdateDto;
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

    public RegisterDto registerUser(RegisterDto registerDto)
    {
        return m_userRepository.register(registerDto);
    }

    public void updateUser(UserUpdateDto userUpdateDto)
    {
        m_userRepository.update(userUpdateDto);
    }

    public void updateUser(UpdatePasswordDto updatePasswordDto)
    {
        m_userRepository.update(updatePasswordDto);
    }
}
