package org.csystem.app.payment.server.manager.manage;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.annotation.Command;
import org.csystem.app.payment.server.Server;

import java.util.concurrent.ExecutorService;

public class PaymentManagerServerCommands {
    private final Server m_server;
    private final PaymentServerInfoServer m_paymentServerInfoServer;
    private final ExecutorService m_executorService;

    @Command
    private void start() throws InterruptedException
    {
        m_executorService.execute(m_server::run);
        m_executorService.execute(m_paymentServerInfoServer::run);
        Thread.sleep(250);
    }

    @Command
    private void stop() throws InterruptedException
    {
        m_executorService.execute(m_server::close);
        m_executorService.execute(m_paymentServerInfoServer::close);
        Thread.sleep(1000);
    }

    @Command("quit")
    @Command
    private void exit()
    {
        Console.writeLine("C and System Programmers Association");
        Console.writeLine("Thanks");
        System.exit(0);
    }

    public PaymentManagerServerCommands(Server server, PaymentServerInfoServer paymentServerInfoServer, ExecutorService executorService)
    {
        m_server = server;
        m_paymentServerInfoServer = paymentServerInfoServer;
        m_executorService = executorService;
    }
}
