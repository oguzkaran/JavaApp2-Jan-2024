package org.csystem.app.payment.repository;

import org.csystem.app.payment.dto.UserDto;

public interface IUserRepository {
    UserDto saveUser(UserDto userDto);
}
