package org.csystem.app.payment.repository;

import lombok.AllArgsConstructor;
import org.csystem.app.payment.dto.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class UserRepository implements IUserRepository {
    private static final String SAVE_USER_SQL = "insert into users (username, password, enabled) values (?, ?, ?)";
    private static final String SAVE_AUTHORITY_SQL = "insert into authorities (username, authority) values (?, ?)";
    private final JdbcTemplate m_jdbcTemplate;
    private final PasswordEncoder m_passwordEncoder;

    @Override
    @Transactional
    public UserDto saveUser(UserDto userDto)
    {
        m_jdbcTemplate.update(SAVE_USER_SQL, userDto.getUsername(), m_passwordEncoder.encode(userDto.getPassword()), Short.parseShort(userDto.getEnabled()));
        m_jdbcTemplate.update(SAVE_AUTHORITY_SQL, userDto.getUsername(), userDto.getRole());

        return userDto;
    }
}
