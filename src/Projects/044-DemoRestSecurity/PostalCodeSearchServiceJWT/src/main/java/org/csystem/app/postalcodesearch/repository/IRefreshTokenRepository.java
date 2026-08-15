package org.csystem.app.postalcodesearch.repository;

import org.csystem.app.postalcodesearch.dto.security.token.RefreshTokenDto;

import java.util.Optional;

public interface IRefreshTokenRepository {
    RefreshTokenDto save(RefreshTokenDto refreshTokenDto);
    Optional<RefreshTokenDto> findByUsername(String username);
    void delete(RefreshTokenDto refreshTokenDto);
}
