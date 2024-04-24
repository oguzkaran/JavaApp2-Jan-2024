package org.csystem.app.generator.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.UdpUtil;
import com.karandev.util.net.exception.NetworkException;

import java.io.IOException;
import java.net.DatagramSocket;
import java.util.stream.IntStream;

public class InfoClient {
    private final String m_address;
    private final int m_generatorPort;
    private final int m_port;
    private final int m_tryCount;

    public InfoClient(String address, int generatorPort, int port, int tryCount)
    {
        m_address = address;
        m_generatorPort = generatorPort;
        m_port = port;
        m_tryCount = tryCount;
    }

    public void run()
    {
        try (var datagramSocket = new DatagramSocket()) {
            IntStream.range(0, m_tryCount)
                    .forEach(ignore -> UdpUtil.sendInt(datagramSocket, m_address, m_generatorPort, m_port));
            new Server(m_port).run();
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Network Error occurred while sending information:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Error occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
        }
    }
}
