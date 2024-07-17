package org.csystem.payment.server.data.repository;

import org.csystem.payment.server.data.entity.Connection;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Lazy
public class ConnectionRepository implements IConnectionRepository {
    private static final String UPDATE_DISCONNECT_TIME_SQL = "update connections set disconnect_time = current_timestamp where connection_id = :id and disconnect_time is not null";
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    public ConnectionRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public <S extends Connection> S save(S entity)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public boolean updateDisconnectTime(String serverId)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void deleteAllById(Iterable<? extends Long> longs)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteById(Long aLong)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public boolean existsById(Long aLong)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<Connection> findAllById(Iterable<Long> id)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Optional<Connection> findById(Long aLong)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public long count()
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void delete(Connection entity)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll(Iterable<? extends Connection> entities)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<Connection> findAll()
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }



    @Override
    public <S extends Connection> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }
}
