package org.csystem.app.payment.repository;

import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.dto.user.UserUpdateDto;

public interface IUserRepository {
    UserDto save(UserDto userDto);
    void update(UserUpdateDto userUpdateDto);
    //...
}
