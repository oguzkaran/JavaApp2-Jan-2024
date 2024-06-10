package org.csystem.app.information.client;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InformationClient {
    private final int m_port;
    private final ExecutorService m_threadPool = Executors.newCachedThreadPool();

    private void startServerCallback()
    {
        //...
    }

    public InformationClient(int port)
    {
        m_port = port;
    }

    public void run(int id, String managerHost, int managerPort)
    {
        try (var socket = new Socket(managerHost, managerPort)) {
            socket.setSoTimeout(3000);
            TcpUtil.sendInt(socket, id);
            TcpUtil.sendStringViaLength(socket, "S;%d".formatted(m_port));
            var status = TcpUtil.receiveByte(socket);

            Console.writeLine("Status:%d", status);

            if (status == 1)
                m_threadPool.execute(this::startServerCallback);
            else
                Console.Error.writeLine("Cannot connect to manager server");
        }
        catch (IOException ex) {
            Console.Error.writeLine("Send information problem:%s", ex.getMessage());
        }
    }
}
