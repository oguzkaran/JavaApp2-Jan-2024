package org.csystem.app.imageprocessing.server.manage;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandprompt.annotation.Command;
import org.csystem.app.imageprocessing.server.ImageProcessingServer;

import java.util.concurrent.ExecutorService;

public class ManageServerCommands {
    private final ImageProcessingServer m_imageProcessingServer;
    private final ExecutorService m_executorService;

    @Command("start")
    private void startGrayscaleServer() throws InterruptedException
    {
        m_executorService.execute(m_imageProcessingServer::run);
        Thread.sleep(250);
    }

    @Command("stop")
    private void stopGrayscaleServer() throws InterruptedException
    {
        m_executorService.execute(m_imageProcessingServer::close);
        Thread.sleep(1000);
    }

    @Command("quit")
    @Command
    private void exit()
    {
        Console.writeLine("Thanks");
        Console.writeLine("C and System Programmers Association");
        System.exit(0);
    }

    public ManageServerCommands(ImageProcessingServer imageProcessingServer, ExecutorService executorService)
    {
        m_imageProcessingServer = imageProcessingServer;
        m_executorService = executorService;
    }
}
