package org.csystem.app.postalcodesearch.repository;

import org.csystem.app.postalcodesearch.dto.user.UserDto;

import java.util.Optional;

public interface IUserRepository {
    UserDto save(UserDto userDto);
    Optional<UserDto> findByUsername(String username);
    Optional<UserDto> findUserDetailsByUsername(String username);
    Optional<UserDto> findByUsernameAndPassword(String username, String password);
    UserDto register(UserDto userDto);
    void update(UserDto userDto);
    boolean updatePassword(UserDto userDto);
    //...
}
