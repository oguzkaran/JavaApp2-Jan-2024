package org.csystem.payment.server.data.repository;


import com.karandev.util.data.repository.ICrudRepository;
import org.csystem.payment.server.data.entity.Connection;

public interface IConnectionRepository extends ICrudRepository<Connection, Long> {
    boolean updateDisconnectTime(String serverId);
}
