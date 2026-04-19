package org.csystem.app.payment.repository;

import org.csystem.app.payment.dto.user.RegisterDto;
import org.csystem.app.payment.dto.user.UpdatePasswordDto;
import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.dto.user.UserUpdateDto;

public interface IUserRepository {
    UserDto save(UserDto userDto);
    RegisterDto register(RegisterDto registerDto);
    void update(UserUpdateDto userUpdateDto);
    void update(UpdatePasswordDto updatePasswordDto);
    //...
}
