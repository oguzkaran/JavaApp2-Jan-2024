package org.csystem.app.payment.repository;

import lombok.AllArgsConstructor;
import org.csystem.app.payment.dto.user.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepository implements IUserRepository {
    private static final String SAVE_USER_SQL = "insert into members (member_name, email, birth_date, password) values (?, ?, ?, ?)";
    private static final String FIND_BY_USERNAME_SQL = "select m.member_name, m.email, m.birth_date, m.password, mr.role from members m inner join member_roles mr on m.member_name = mr.member_name where m.member_name = ?";
    private static final String SAVE_AUTHORITY_SQL = "insert into member_roles (member_name, role) values (?, ?)";
    private static final String UPDATE_PASSWORD_SQL = "update members set password=? where member_name = ?";
    private static final String UPDATE_USER_SQL = "update members set email = ?, birth_date = ?, password = ? where member_name = ?";
    private static final String UPDATE_AUTHORITY_SQL = "update member_roles set role = ? where member_name = ?";

    private final JdbcTemplate m_jdbcTemplate;
    private final PasswordEncoder m_passwordEncoder;

    @Override
    @Transactional
    public UserDto save(UserDto userDto)
    {
        m_jdbcTemplate.update(SAVE_USER_SQL, userDto.getUsername(), userDto.getEmail(), LocalDate.parse(userDto.getBirthDate()), m_passwordEncoder.encode(userDto.getPassword()));
        m_jdbcTemplate.update(SAVE_AUTHORITY_SQL, userDto.getUsername(), userDto.getRole());

        return userDto;
    }

    @Override
    public Optional<UserDto> findByUsername(String username)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional
    public UserDto register(UserDto userDto)
    {
        m_jdbcTemplate.update(SAVE_USER_SQL, userDto.getUsername(), userDto.getEmail(), LocalDate.parse(userDto.getBirthDate()), m_passwordEncoder.encode(userDto.getPassword()));
        m_jdbcTemplate.update(SAVE_AUTHORITY_SQL, userDto.getUsername(), "ROLE_USER");

        return userDto;
    }

    @Override
    public void update(UserDto userDto)
    {
        m_jdbcTemplate.update(UPDATE_USER_SQL, userDto.getEmail(), LocalDate.parse(userDto.getBirthDate()), m_passwordEncoder.encode(userDto.getPassword()),  userDto.getUsername());
        m_jdbcTemplate.update(UPDATE_AUTHORITY_SQL, userDto.getRole(), userDto.getUsername());
    }

    @Override
    public boolean updatePassword(UserDto userDto)
    {
        return m_jdbcTemplate.update(UPDATE_PASSWORD_SQL, m_passwordEncoder.encode(userDto.getPassword()), userDto.getUsername()) != 0;
    }
}
