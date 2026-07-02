package org.csystem.app.postalcodesearch.security.helper;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Accessors(prefix = "m_")
@Slf4j
public class JwtHelper {
    private final SecretKey m_secretKey;

    @Value("${jwt.expiration}")
    private long m_expirationInMillis;

    public String generateToken(String username)
    {
        var now = new Date();

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + m_expirationInMillis))
                .signWith(m_secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateUsernameByToken(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(m_secretKey).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String generateUsernameByClaims(Jws<Claims> jwsClaims)
    {
        return jwsClaims.getBody().getSubject();
    }

    public boolean isValidToken(String token)
    {
        return parseClaimsJws(token).isPresent();
    }

    public Optional<Jws<Claims>> parseClaimsJws(String token)
    {
        try {
            return Optional.of(Jwts.parserBuilder().setSigningKey(m_secretKey).build().parseClaimsJws(token));
        }
        catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
               | SignatureException | IllegalArgumentException e) {
            log.debug("Invalid JWT token:{}", token);
        }

        return Optional.empty();
    }

    //...
}
