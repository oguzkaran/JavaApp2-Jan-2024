package org.csystem.app.information.client;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;

import java.io.IOException;
import java.net.Socket;

import static org.csystem.communication.library.common.CommunicationMessage.ERROR_INVALID_PORT;

public class InformationClient {
    private final int m_port;
    
    public InformationClient(int port)
    {
        m_port = port;
    }

    public void run(String name, String managerHost, int managerPort) throws IOException
    {
        try (var socket = new Socket(managerHost, managerPort)) {
            TcpUtil.sendStringViaLength(socket, name);
            TcpUtil.sendInt(socket, m_port);
            var replyMessage = TcpUtil.receiveStringViaLength(socket);

            Console.writeLine("Reply:%s", replyMessage);

            if (replyMessage.equals(ERROR_INVALID_PORT))
                throw new IOException("Invalid port");
        }
    }
}
