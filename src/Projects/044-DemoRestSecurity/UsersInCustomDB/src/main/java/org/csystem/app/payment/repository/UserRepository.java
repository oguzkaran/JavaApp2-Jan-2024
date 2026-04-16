package org.csystem.app.payment.repository;

import lombok.AllArgsConstructor;
import org.csystem.app.payment.dto.user.UserDto;
import org.csystem.app.payment.dto.user.UserUpdateDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class UserRepository implements IUserRepository {
    private static final String SAVE_USER_SQL = "insert into members (member_name, password) values (?, ?)";
    private static final String SAVE_AUTHORITY_SQL = "insert into member_roles (member_name, role) values (?, ?)";
    private final JdbcTemplate m_jdbcTemplate;
    private final PasswordEncoder m_passwordEncoder;

    @Override
    @Transactional
    public UserDto save(UserDto userDto)
    {
        m_jdbcTemplate.update(SAVE_USER_SQL, userDto.getUsername(), m_passwordEncoder.encode(userDto.getPassword()));
        m_jdbcTemplate.update(SAVE_AUTHORITY_SQL, userDto.getUsername(), userDto.getRole());

        return userDto;
    }

    @Override
    public void update(UserUpdateDto userUpdateDto)
    {
        throw new UnsupportedOperationException("TODO:");
    }
}
