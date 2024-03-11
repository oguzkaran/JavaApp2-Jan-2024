package org.csystem.app.imageprocessing.client;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandprompt.annotation.Command;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class CommandsInfo {
    private final String m_host;
    private final int m_port;

    @Command("gs")
    private void makeGrayScale(String name, String path, String blockSizeStr)
    {
        var file = new File(path);
        if (!file.exists()) {
            Console.Error.writeLine("Image not found");
            return;
        }

        try (var socket = new Socket(m_host, m_port)) {
            var blockSize = Integer.parseInt(blockSizeStr);

            TcpUtil.sendStringViaLength(socket, name);

            var statusStr = TcpUtil.receiveString(socket, 5);

            if (statusStr.equals("ERR_N")) {
                Console.writeLine("invalid name");
                return;
            }

            TcpUtil.sendFile(socket, file, blockSize);

            if (TcpUtil.receiveInt(socket) == 1)
                TcpUtil.receiveFile(socket, "gs.png");
            else
                Console.writeLine("Not sent!...");
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid block size value!...");
        }
        catch (IOException ex) {
            Console.Error.writeLine("Socket problem occurred:%s", ex.getMessage());
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Network error occurred:%s", ex.getMessage());
        }
    }

    @Command("bin")
    private void makeBinary(String name, String path, String blockSizeStr, String thresholdStr)
    {
        var file = new File(path);
        if (!file.exists()) {
            Console.Error.writeLine("Image not found");
            return;
        }

        try (var socket = new Socket(m_host, m_port + 1)) {
            var blockSize = Integer.parseInt(blockSizeStr);
            var threshold = Integer.parseInt(thresholdStr);

            TcpUtil.sendStringViaLength(socket, name);

            var statusStr = TcpUtil.receiveString(socket, 5);

            if (statusStr.equals("ERR_N")) {
                Console.writeLine("invalid name");
                return;
            }

            TcpUtil.sendFile(socket, file, blockSize);
            TcpUtil.sendInt(socket, threshold);

            if (TcpUtil.receiveInt(socket) == 1)
                TcpUtil.receiveFile(socket, "bin.png");
            else
                Console.writeLine("Not sent!...");
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid block size value!...");
        }
        catch (IOException ex) {
            Console.Error.writeLine("Socket problem occurred:%s", ex.getMessage());
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Network error occurred:%s", ex.getMessage());
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
