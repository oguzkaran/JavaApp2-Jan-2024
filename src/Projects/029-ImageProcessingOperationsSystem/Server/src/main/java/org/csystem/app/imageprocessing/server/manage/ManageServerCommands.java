package org.csystem.app.imageprocessing.server.manage;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandprompt.annotation.Command;
import org.csystem.app.imageprocessing.server.BinaryImageServer;
import org.csystem.app.imageprocessing.server.GrayscaleImageServer;

import java.util.concurrent.ExecutorService;

public class ManageServerCommands {
    private final GrayscaleImageServer m_grayscaleImageServer;
    private final BinaryImageServer m_binaryImageServer;
    private final ExecutorService m_executorService;

    @Command("startgs")
    private void startGrayscaleServer()
    {
        m_executorService.execute(m_grayscaleImageServer::run);
    }

    @Command("startbs")
    private void startBinaryServer()
    {
        m_executorService.execute(m_binaryImageServer::run);
    }

    @Command("stopgs")
    private void stopGrayscaleServer()
    {
        m_executorService.execute(m_grayscaleImageServer::close);
    }

    @Command("stopbs")
    private void stopBinaryServer()
    {
        m_executorService.execute(m_binaryImageServer::close);
    }

    @Command("startall")
    private void startAll()
    {
        startGrayscaleServer();
        startBinaryServer();
    }

    @Command("stopall")
    private void stopAll()
    {
        stopGrayscaleServer();
        stopBinaryServer();
    }

    @Command("quit")
    @Command
    private void exit()
    {
        Console.writeLine("Thanks");
        System.exit(0);
    }

    public ManageServerCommands(GrayscaleImageServer grayscaleImageServer, BinaryImageServer binaryImageServer, ExecutorService executorService)
    {
        m_grayscaleImageServer = grayscaleImageServer;
        m_binaryImageServer = binaryImageServer;
        m_executorService = executorService;
    }
}
