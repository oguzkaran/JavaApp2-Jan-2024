package org.csystem.app.information.server.manage;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.annotation.Command;
import org.csystem.app.information.server.CommunicationServerInfoServer;
import org.csystem.app.information.server.JoinMeetingInformationServer;

import java.util.concurrent.ExecutorService;

public class MeetingManagerServerCommands {
    private final JoinMeetingInformationServer m_joinMeetingInformationServer;
    private final CommunicationServerInfoServer m_communicationServerInfoServer;

    private final ExecutorService m_executorService;

    @Command
    private void start() throws InterruptedException
    {
        m_executorService.execute(m_joinMeetingInformationServer::run);
        m_executorService.execute(m_communicationServerInfoServer::run);
        Thread.sleep(250);
    }

    @Command
    private void stop() throws InterruptedException
    {
        m_executorService.execute(m_joinMeetingInformationServer::close);
        m_executorService.execute(m_communicationServerInfoServer::close);
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

    public MeetingManagerServerCommands(JoinMeetingInformationServer joinMeetingInformationServer, CommunicationServerInfoServer communicationServerInfoServer, ExecutorService executorService)
    {
        m_joinMeetingInformationServer = joinMeetingInformationServer;
        m_communicationServerInfoServer = communicationServerInfoServer;
        m_executorService = executorService;
    }
}
