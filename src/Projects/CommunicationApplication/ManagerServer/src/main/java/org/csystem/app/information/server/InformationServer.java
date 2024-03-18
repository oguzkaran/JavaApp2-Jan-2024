package org.csystem.app.information.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;
import org.csystem.app.information.server.communication.client.InformationServerInfo;
import org.csystem.app.information.server.communication.global.Global;
import org.csystem.net.tcp.server.ConcurrentServer;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.time.format.DateTimeFormatter;

public class InformationServer implements Closeable {
    private static final int SOCKET_TIMEOUT = 1000;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss-n");
    private final ConcurrentServer m_server;

    private int connectToInformationServerCallback(Socket socket, String id)
    {
        TcpUtil.sendLine(socket, String.format("%s", id));
        var status = TcpUtil.receiveLine(socket);

        if (status.equals("SUC"))
            return Integer.parseInt(TcpUtil.receiveLine(socket));

        return 0;
    }

    private int connectToInformationServer(String id, String name, InformationServerInfo informationServerInfo)
    {
        var port = -1;

        //Döngü aslında bir critical section'dır. Bunu ileride ele alacağız
        for (var ci : Global.INFORMATION_SERVER_INFO) {
            try (var socket = new Socket(ci.getHost(), ci.getPort())) {
                port = connectToInformationServerCallback(socket, id);

                if (port != 0) {
                    informationServerInfo.setHost(ci.getHost());
                    break;
                }
            }
            catch (IOException ignore) {
                //...
            }
        }

        return port;
    }

    private void handleClient(Socket socket)
    {
        try (socket) {
            socket.setSoTimeout(SOCKET_TIMEOUT);
            var id = TcpUtil.receiveLine(socket);
            var name = TcpUtil.receiveLine(socket);
            InformationServerInfo info = new InformationServerInfo();

            var port = connectToInformationServer(id, name, info);

            if (port > 0) {
                TcpUtil.sendLine(socket, "SUC_INFO");
                TcpUtil.sendLine(socket, String.format("%s:%d", info.getHost(), port));
            }
            else if (port == 0) {
                TcpUtil.sendLine(socket, "ERR_INVALID_ID");
            }
            else
                TcpUtil.sendLine(socket, "ERR_INTERNAL");
        }
        catch (IOException ex) {
            Console.Error.writeLine("GrayScaleImageServer:IO Exception Occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("GrayScaleImageServer:Exception Occurred:%s", ex.getMessage());
        }
    }

    public InformationServer(int port, int backlog) throws IOException
    {
        m_server = ConcurrentServer.builder()
                .setPort(port)
                .setBacklog(backlog)
                //.setInitRunnable(() -> {})
                .setBeforeAcceptRunnable(() -> Console.writeLine("Information server is waiting for a client on port:%d", port))
                .setClientSocketConsumer(this::handleClient)
                //.setServerExceptionConsumer(ex -> Console.Error.writeLine("Exception Occurred:%s", ex.getMessage()))
                .build();
    }

    public void run()
    {
        m_server.start();
    }

    public void close()
    {
        m_server.stop();
    }
}
