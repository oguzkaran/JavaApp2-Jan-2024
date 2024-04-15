package org.csystem.app.communication.client;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.annotation.Command;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;
import org.csystem.communication.library.common.CommunicationMessage;

import java.io.IOException;
import java.net.Socket;

public class CommandsInfo {
    private final String m_host;
    private final int m_port;

    @Command("join")
    @Command("jm")
    private void joinMeeting(String meetingId, String name)
    {
        try (var socket = new Socket(m_host, m_port)) {
            TcpUtil.sendStringViaLength(socket, meetingId);
            TcpUtil.sendStringViaLength(socket, name);

            var statusStr = TcpUtil.receiveStringViaLength(socket);
            Console.writeLine("Status Str:%s", statusStr);

            if (statusStr.equals(CommunicationMessage.SUCCESS_INFO))
                Console.writeLine("Communication Server:%s", TcpUtil.receiveStringViaLength(socket));
            else if (statusStr.equals(CommunicationMessage.ERROR_INVALID_ID))
                Console.writeLine("Invalid meeting id");
            else
                Console.writeLine("Internal server error");
        }
        catch (IOException ex) {
            Console.Error.writeLine("Socket problem occurred:%s", ex.getMessage());
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Network error occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
        }
    }


    @Command
    @Command("exit")
    private void quit()
    {
        System.exit(0);
    }

    public CommandsInfo(String host, int port)
    {
        m_host = host;
        m_port = port;
    }
}
