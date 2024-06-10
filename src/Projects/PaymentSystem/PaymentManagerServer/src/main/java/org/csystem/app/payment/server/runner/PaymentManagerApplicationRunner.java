package org.csystem.app.payment.server.runner;

import com.karandev.io.util.console.CommandPrompt;
import org.csystem.app.payment.server.Server;
import org.csystem.app.payment.server.manager.manage.PaymentManagerServerCommands;
import org.csystem.app.payment.server.manager.manage.PaymentServerInfoServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

@Component
public class PaymentManagerApplicationRunner implements ApplicationRunner {
    private final PaymentServerInfoServer m_paymentServerInfoServer;
    private final Server m_server;

    public PaymentManagerApplicationRunner(PaymentServerInfoServer paymentServerInfoServer, Server server)
    {
        m_paymentServerInfoServer = paymentServerInfoServer;
        m_server = server;
    }

    @Override
    public void run(ApplicationArguments args)
    {
        CommandPrompt.builder()
                .prompt("payment-manager")
                .build()
                .registerObject(new PaymentManagerServerCommands(m_server, m_paymentServerInfoServer, Executors.newCachedThreadPool()))
                .run();
    }
}
