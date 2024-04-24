package org.csystem.app.generator;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.UdpUtil;

import java.net.DatagramSocket;
import java.nio.ByteBuffer;

import static org.csystem.app.generator.global.ServerUtil.SERVERS;
import static org.csystem.app.generator.global.ServerUtil.SYNC_LOCK;

public class ServerReceiver {
    private final int m_port;
    private final int m_size;

    private void serverReceive(DatagramSocket datagramSocket)
    {
        var datagramPacket = UdpUtil.receiveDatagramPacket(datagramSocket, m_size);
        var host = datagramPacket.getAddress().getHostAddress();
        var port = ByteBuffer.wrap(datagramPacket.getData(), 0, 4).getInt();

        synchronized (SYNC_LOCK) {
            SERVERS.add(new ServerInfo(host, port));
        }
    }

    public ServerReceiver(int port, int size)
    {
        m_port = port;
        m_size = size;
    }

    public void run()
    {
        try (var datagramSocket = new DatagramSocket(m_port)) {
            Console.writeLine("Server Receiver is waiting for server on %d", m_port);
            while (true)
                serverReceive(datagramSocket);
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
            System.exit(1);
        }
    }
}
