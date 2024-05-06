package org.csystem.app.payment.server.manage;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.annotation.Command;
import org.csystem.app.payment.server.Server;

import java.util.concurrent.ExecutorService;

public class PaymentManagerServerCommands {
    private final Server m_server;

    private final ExecutorService m_executorService;

    @Command
    private void start() throws InterruptedException
    {
        m_executorService.execute(m_server::run);
        Thread.sleep(250);
    }

    @Command
    private void stop() throws InterruptedException
    {
        m_executorService.execute(m_server::close);
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

    public PaymentManagerServerCommands(Server server, ExecutorService executorService)
    {
        m_server = server;
        m_executorService = executorService;
    }
}
