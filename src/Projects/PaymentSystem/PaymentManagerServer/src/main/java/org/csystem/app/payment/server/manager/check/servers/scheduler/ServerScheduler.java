package org.csystem.app.payment.server.manager.check.servers.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.server.manager.client.PaymentServerInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class ServerScheduler {
    private final Map<Integer, PaymentServerInfo> m_servers;
    private final Object m_syncObject;

    public ServerScheduler(Map<Integer, PaymentServerInfo> servers,
                           @Qualifier("sync") Object syncObject)
    {
        m_servers = servers;
        m_syncObject = syncObject;
    }

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.SECONDS)
    public void schedule()
    {
        synchronized (m_syncObject) {
            log.info("check servers and delete if not running");
        }
    }
}
