package org.csystem.app.payment.repository;

import lombok.AllArgsConstructor;
import org.csystem.app.payment.dto.user.UserDto;
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
@AllArgsConstructor
public class UserRepository implements IUserRepository {
    private static final String SAVE_USER_SQL = "insert into members (member_name, email, birth_date, password) values (?, ?, ?, ?)";
    private static final String FIND_BY_USERNAME_SQL = "select m.member_name, m.email, m.birth_date from members m where m.member_name = ?";
    private static final String FIND_ROLES_BY_USERNAME_SQL = "select role from member_roles where member_name = ?";
    private static final String SAVE_AUTHORITY_SQL = "insert into member_roles (member_name, role) values (?, ?)";
    private static final String UPDATE_PASSWORD_SQL = "update members set password=? where member_name = ?";
    private static final String UPDATE_USER_SQL = "update members set email = ?, birth_date = ? where member_name = ?";
    private static final String UPDATE_AUTHORITY_SQL = "update member_roles set role = ? where member_name = ?";

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
        userDto.getRoles().forEach(r -> m_jdbcTemplate.update(SAVE_AUTHORITY_SQL, userDto.getUsername(), r));

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
    @Transactional
    public UserDto register(UserDto userDto)
    {
        m_jdbcTemplate.update(SAVE_USER_SQL, userDto.getUsername(), userDto.getEmail(), LocalDate.parse(userDto.getBirthDate()), m_passwordEncoder.encode(userDto.getPassword()));
        m_jdbcTemplate.update(SAVE_AUTHORITY_SQL, userDto.getUsername(), "ROLE_USER");

        return userDto;
    }

    @Override
    @Transactional
    public void update(UserDto userDto)
    {
        m_jdbcTemplate.update(UPDATE_USER_SQL, userDto.getEmail(), LocalDate.parse(userDto.getBirthDate()),  userDto.getUsername());
    }

    @Override
    public boolean updatePassword(UserDto userDto)
    {
        return m_jdbcTemplate.update(UPDATE_PASSWORD_SQL, m_passwordEncoder.encode(userDto.getPassword()), userDto.getUsername()) != 0;
    }
}
