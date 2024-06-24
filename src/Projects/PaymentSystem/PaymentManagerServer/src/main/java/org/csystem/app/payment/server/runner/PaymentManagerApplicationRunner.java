package org.csystem.app.payment.server.runner;

import org.csystem.app.payment.server.Server;
import org.csystem.app.payment.server.manager.manage.PaymentServerInfoServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
public class PaymentManagerApplicationRunner implements ApplicationRunner {
    private final Server m_server;
    private final PaymentServerInfoServer m_paymentServerInfoServer;
    private final ExecutorService m_executorService;

    public PaymentManagerApplicationRunner(Server server, PaymentServerInfoServer paymentServerInfoServer, ExecutorService executorService)
    {
        m_server = server;
        m_paymentServerInfoServer = paymentServerInfoServer;
        m_executorService = executorService;
    }

    @Override
    public void run(ApplicationArguments args)
    {
        m_executorService.execute(m_server::run);
        m_executorService.execute(m_paymentServerInfoServer::run);
    }
}
