package org.csystem.app.generator;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;
import org.csystem.app.generator.global.Servers;
import org.csystem.util.string.StringUtil;

import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.random.RandomGenerator;

public class TextGenerator {
    private final RandomGenerator m_randomGenerator = new Random();

    private void sendTextCallback(ServerInfo serverInfo, String text)
    {
        try (var socket = new Socket(serverInfo.getHost(), serverInfo.getPort())) {
            TcpUtil.sendLine(socket, text);
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Network Error occurred:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Error occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
        }
    }

    public void run()
    {
        var text = StringUtil.getRandomTextEN(m_randomGenerator, m_randomGenerator.nextInt(5, 15));

        Console.writeLine("Generated text:%s", text);

        synchronized (Servers.SYNC_LOCK) {
            Servers.SERVERS.forEach(si -> sendTextCallback(si, text));
        }
    }
}
