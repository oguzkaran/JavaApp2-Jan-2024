package org.csystem.app.postalcodesearch.repository;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.csystem.app.postalcodesearch.dto.security.token.RefreshTokenDto;
import org.csystem.app.postalcodesearch.dto.security.user.UserDto;
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
@Accessors(prefix = "m_")
public class RefreshTokenRepository implements IRefreshTokenRepository {
    private static final String SAVE_SQL = "call sp_insert_refresh_token(?, ?, ?)";
    private static final String FIND_BY_USERNAME_SQL = "select * from find_refresh_token_by_username(?)";
    private static final String DELETE_SQL = "call sp_delete_refresh_token(?)";

    private final JdbcTemplate m_jdbcTemplate;

    @Override
    public RefreshTokenDto save(RefreshTokenDto refreshTokenDto)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<RefreshTokenDto> findByUsername(String username)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(RefreshTokenDto refreshTokenDto)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
