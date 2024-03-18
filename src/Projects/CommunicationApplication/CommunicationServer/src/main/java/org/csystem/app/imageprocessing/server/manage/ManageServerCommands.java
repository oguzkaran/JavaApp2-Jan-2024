package org.csystem.app.imageprocessing.server.manage;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandprompt.annotation.Command;
import org.csystem.app.imageprocessing.server.InformationServer;

import java.util.concurrent.ExecutorService;

public class ManageServerCommands {
    private final InformationServer m_informationServer;
    private final ExecutorService m_executorService;

    @Command
    private void start() throws InterruptedException
    {
        m_executorService.execute(m_informationServer::run);
        Thread.sleep(250);
    }

    @Command
    private void stop() throws InterruptedException
    {
        m_executorService.execute(m_informationServer::close);
        Thread.sleep(1000);
    }

    @Command("quit")
    @Command
    private void exit()
    {
        Console.writeLine("Thanks");
        System.exit(0);
    }

    public ManageServerCommands(InformationServer informationServer, ExecutorService executorService)
    {
        m_informationServer = informationServer;
        m_executorService = executorService;
    }
}
