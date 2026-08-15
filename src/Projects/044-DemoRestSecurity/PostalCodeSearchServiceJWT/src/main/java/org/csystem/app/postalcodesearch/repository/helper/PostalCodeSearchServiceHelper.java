package org.csystem.app.postalcodesearch.repository.helper;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import org.csystem.app.postalcodesearch.dto.security.token.RefreshTokenDto;
import org.csystem.app.postalcodesearch.dto.security.user.UserDto;
import org.csystem.app.postalcodesearch.repository.IRefreshTokenRepository;
import org.csystem.app.postalcodesearch.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Accessors(prefix = "m_")
public class PostalCodeSearchServiceHelper {
    private final IUserRepository m_userRepository;
    private final IRefreshTokenRepository m_refreshTokenRepository;

    public UserDto addUser(UserDto userDto)
    {
        return m_userRepository.save(userDto);
    }

    public Optional<UserDto> finedByUsername(String username)
    {
        //...
        return m_userRepository.findByUsername(username);
    }

    public UserDto registerUser(UserDto userDto)
    {
        //...
        return m_userRepository.register(userDto);
    }

    public void updateUser(UserDto userDto)
    {
        m_userRepository.update(userDto);
    }

    public boolean updatePassword(UserDto userDto)
    {
        return m_userRepository.updatePassword(userDto);
    }

    public RefreshTokenDto saveRefreshToken(RefreshTokenDto refreshTokenDto)
    {
        return m_refreshTokenRepository.save(refreshTokenDto);
    }

    public Optional<RefreshTokenDto> findRefreshTokenByUsername(String username)
    {
        return m_refreshTokenRepository.findByUsername(username);
    }

    public void deleteRefreshToken(RefreshTokenDto refreshTokenDto)
    {
        m_refreshTokenRepository.delete(refreshTokenDto);
    }
}
