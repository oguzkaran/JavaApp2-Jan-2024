package org.csystem.app.information.server.manage;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.annotation.Command;
import org.csystem.app.information.server.SendInformationServer;

import java.util.concurrent.ExecutorService;

public class CommunicationServerCommands {
    private final SendInformationServer m_sendInformationServer;
    private final ExecutorService m_executorService;

    @Command
    private void start() throws InterruptedException
    {
        m_executorService.execute(m_sendInformationServer::run);
        Thread.sleep(250);
    }

    @Command
    private void stop() throws InterruptedException
    {
        m_executorService.execute(m_sendInformationServer::close);
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

    public CommunicationServerCommands(SendInformationServer sendInformationServer, ExecutorService executorService)
    {
        m_sendInformationServer = sendInformationServer;
        m_executorService = executorService;
    }
}
