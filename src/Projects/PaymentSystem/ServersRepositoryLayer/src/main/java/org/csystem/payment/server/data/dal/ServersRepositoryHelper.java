package org.csystem.payment.server.data.dal;

import com.karandev.util.data.repository.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.csystem.payment.server.data.entity.Connection;
import org.csystem.payment.server.data.entity.ServerInfo;
import org.csystem.payment.server.data.repository.IConnectionRepository;
import org.csystem.payment.server.data.repository.IServerInfoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Lazy
@Slf4j
public class ServersRepositoryHelper {
    private final IServerInfoRepository m_serverInfoRepository;
    private final IConnectionRepository m_connectionRepository;

    public ServersRepositoryHelper(IServerInfoRepository serverInfoRepository, IConnectionRepository connectionRepository)
    {
        m_serverInfoRepository = serverInfoRepository;
        m_connectionRepository = connectionRepository;
    }

    public Iterable<ServerInfo> findAll()
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    public Optional<ServerInfo> findServerById(String id)
    {
        try {
            log.info("ServersRepositoryHelper.findServerById:{}", id);

            return m_serverInfoRepository.findById(id);
        }
        catch (Throwable ex) {
            log.error("ServersRepositoryHelper.findServerById -> Error", ex);
            throw new RepositoryException("ServersRepositoryHelper.findServerById -> Error", ex);
        }
    }

    public boolean updateDisconnectTime(String serverId)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    public ServerInfo saveServerInfo(ServerInfo serverInfo)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }

    public Connection saveConnection(Connection connection)
    {
        throw new UnsupportedOperationException("Not yet implemented!...");
    }
}
