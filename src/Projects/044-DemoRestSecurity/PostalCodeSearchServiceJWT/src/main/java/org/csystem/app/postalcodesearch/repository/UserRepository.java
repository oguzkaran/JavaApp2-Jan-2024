package org.csystem.app.postalcodesearch.repository;

import lombok.RequiredArgsConstructor;
import org.csystem.app.postalcodesearch.dto.user.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements IUserRepository {
    private static final String SAVE_USER_WITH_AUTHORITY_SQL = "call sp_insert_user_with_authority(?, ?, ?, ?, ?)";
    private static final String SAVE_USER_SQL = "call sp_insert_user(?, ?, ?, ?)";
    private static final String FIND_BY_USERNAME_SQL = "select * from find_user_by_username(?)";
    private static final String FIND_ROLES_BY_USERNAME_SQL = "select * from find_authorities_by_username(?)";
    private static final String UPDATE_PASSWORD_SQL = "call sp_update_password(?, ?)";
    private static final String UPDATE_USER_SQL = "call sp_update_user(?, ?, ?)";
    private static final String UPSERT_AUTHORITY_SQL = "call sp_upsert_authority(?, ?)";

    private final JdbcTemplate m_jdbcTemplate;
    private final PasswordEncoder m_passwordEncoder;

    private void findByUsernameCallback(ResultSet rs, ArrayList<UserDto> users) throws SQLException
    {
        var user = UserDto.builder()
                .username(rs.getString(1))
                .email(rs.getString(2))
                .birthDate(rs.getDate(3).toLocalDate().format(DateTimeFormatter.ISO_DATE))
                .build();

        users.add(user);
    }

    private void findUserDetailsByUsernameCallback(ResultSet rs, ArrayList<UserDto> users) throws SQLException
    {
        var user = UserDto.builder()
                .username(rs.getString(1))
                .password(rs.getString(4))
                .build();

        users.add(user);
    }


    private void findRolesByUsernameCallback(ResultSet rs, UserDto userDto) throws SQLException
    {
        var roles = userDto.getRoles();

        do
            roles.add(rs.getString(1));
        while (rs.next());
    }

    @Override
    @Transactional
    public UserDto save(UserDto userDto)
    {
        m_jdbcTemplate.update(SAVE_USER_SQL, userDto.getUsername(), userDto.getEmail(), LocalDate.parse(userDto.getBirthDate()), m_passwordEncoder.encode(userDto.getPassword()));
        userDto.getRoles().forEach(r -> m_jdbcTemplate.update(UPSERT_AUTHORITY_SQL, userDto.getUsername(), r));

        return userDto;
    }

    @Override
    @Transactional
    public Optional<UserDto> findByUsername(String username)
    {
        var list = new ArrayList<UserDto>();

        m_jdbcTemplate.query(FIND_BY_USERNAME_SQL, (ResultSet rs) -> findByUsernameCallback(rs, list), username);

        if (!list.isEmpty())
            m_jdbcTemplate.query(FIND_ROLES_BY_USERNAME_SQL, (ResultSet rs) -> findRolesByUsernameCallback(rs,list.get(0)), username);

        return list.stream().findFirst();
    }


    @Override
    public Optional<UserDto> findUserDetailsByUsername(String username)
    {
        var list = new ArrayList<UserDto>();

        m_jdbcTemplate.query(FIND_BY_USERNAME_SQL, (ResultSet rs) -> findUserDetailsByUsernameCallback(rs, list), username);

        return list.stream().findFirst();
    }

    @Override
    public Optional<UserDto> findByUsernameAndPassword(String username, String password)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public UserDto register(UserDto userDto)
    {
        m_jdbcTemplate.update(SAVE_USER_WITH_AUTHORITY_SQL, userDto.getUsername(), userDto.getEmail(), LocalDate.parse(userDto.getBirthDate()), m_passwordEncoder.encode(userDto.getPassword()), "ROLE_USER");

        return userDto;
    }

    @Override
    @Transactional
    public void update(UserDto userDto)
    {
        m_jdbcTemplate.update(UPDATE_USER_SQL, userDto.getUsername(), userDto.getEmail(), LocalDate.parse(userDto.getBirthDate()));
        userDto.getRoles().forEach(r -> m_jdbcTemplate.update(UPSERT_AUTHORITY_SQL, userDto.getUsername(), r));
    }

    @Override
    public boolean updatePassword(UserDto userDto)
    {
        return m_jdbcTemplate.update(UPDATE_PASSWORD_SQL, userDto.getUsername(), m_passwordEncoder.encode(userDto.getPassword())) != 0;
    }
}
