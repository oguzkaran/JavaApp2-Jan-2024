package org.csystem.payment.server.data.repository;

import org.csystem.payment.server.data.entity.ServerInfo;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Repository
public class ServerRepository implements IServerInfoRepository {
    private static final String SAVE_SQL = "INSERT INTO server_info (id, communication_info, connection_info, register_datetime) VALUES (:id, :communicationInfo, :connectionInfo, :registerDateTime)";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM server_info WHERE id = :id";
    private static final String FIND_ALL_SQL = "SELECT * FROM server_info";
    private static final String COUNT_SQL = "SELECt COUNT(*) FROM server_info";

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

    private void fillCount(ResultSet rs, ArrayList<Long> list) throws SQLException
    {
        list.add(rs.getLong(1));
    }

    public ServerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long count()
    {
        var list = new ArrayList<Long>();

        m_namedParameterJdbcTemplate.query(COUNT_SQL, rs -> {fillCount(rs, list);});

        return list.get(0);
    }

    @Override
    public Iterable<ServerInfo> findAll()
    {
        var serverInfoList = new ArrayList<ServerInfo>();

        m_namedParameterJdbcTemplate.query(FIND_ALL_SQL, rs -> {fillServerInfoWithAll(rs, serverInfoList);});

        return serverInfoList;
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

    @Override
    public <S extends ServerInfo> S save(S serverInfo)
    {
        var paramSource = new BeanPropertySqlParameterSource(serverInfo);

        paramSource.registerSqlType("registerDateTime", Types.TIMESTAMP);
        m_namedParameterJdbcTemplate.update(SAVE_SQL, paramSource);

        return serverInfo;
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
    public <S extends ServerInfo> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }
}
