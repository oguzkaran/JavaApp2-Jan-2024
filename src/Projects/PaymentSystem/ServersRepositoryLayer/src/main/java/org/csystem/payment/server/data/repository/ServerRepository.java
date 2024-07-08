package org.csystem.payment.server.data.repository;

import org.csystem.payment.server.data.entity.ServerInfo;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Repository
public class ServerRepository implements IServerInfoRepository {
    private static final String FIND_BY_ID_SQL = "SELECT * FROM server_info WHERE id = :id";

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    private void fillServerInfoWithAll(ResultSet rs, ArrayList<ServerInfo> serverInfoList) throws SQLException
    {
        do {
            var id = rs.getString(1);
            var comInfo = rs.getString(2);
            var conInfo = rs.getString(3);
            var regDateTime = rs.getTimestamp(4).toLocalDateTime();

            serverInfoList.add(new ServerInfo(id, comInfo, conInfo, regDateTime));
        } while (rs.next());
    }

    public ServerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<ServerInfo> findById(String id)
    {
        var paramMap = new HashMap<String, Object>();
        var serverInfoList = new ArrayList<ServerInfo>();

        paramMap.put("id", id);

        m_namedParameterJdbcTemplate.query(FIND_BY_ID_SQL, paramMap, (ResultSet rs) -> fillServerInfoWithAll(rs, serverInfoList));

        return serverInfoList.isEmpty() ? Optional.empty() : Optional.of(serverInfoList.get(0));
    }



    ////////////////////////////////////////////////////////////////////////////////

    @Override
    public void deleteAllById(Iterable<? extends String> strings)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteById(String s)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public boolean existsById(String s)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<ServerInfo> findAllById(Iterable<String> id)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }



    @Override
    public long count()
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void delete(ServerInfo entity)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll(Iterable<? extends ServerInfo> entities)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<ServerInfo> findAll()
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends ServerInfo> S save(S entity)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends ServerInfo> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }
}
