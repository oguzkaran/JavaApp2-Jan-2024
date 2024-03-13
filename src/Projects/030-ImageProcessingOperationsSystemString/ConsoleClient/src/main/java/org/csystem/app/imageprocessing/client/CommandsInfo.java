package org.csystem.app.imageprocessing.client;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandprompt.annotation.Command;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class CommandsInfo {
    private static final String ERR_N = "ERR_N";
    private static final String SUC_N = "SUC_N";
    private static final String ERR_GS = "ERR_GS";
    private static final String SUC_GS = "SUC_GS";
    private static final String ERR_BIN = "ERR_BIN";
    private static final String SUC_BIN = "SUC_BIN";

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

            if (statusStr.equals(ERR_N)) {
                Console.writeLine("Message:%s", TcpUtil.receiveStringViaLength(socket));
                return;
            }

            TcpUtil.sendFile(socket, file, blockSize);

            if (TcpUtil.receiveString(socket, 6).equals(SUC_GS))
                TcpUtil.receiveFile(socket, "gs.png");
            else
                Console.writeLine("Message:%s", TcpUtil.receiveStringViaLength(socket));
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

            if (statusStr.equals(ERR_N)) {
                Console.writeLine("Message:%s", TcpUtil.receiveStringViaLength(socket));
                return;
            }

            TcpUtil.sendFile(socket, file, blockSize);
            TcpUtil.sendInt(socket, threshold);

            if (TcpUtil.receiveString(socket, 7).equals(SUC_BIN))
                TcpUtil.receiveFile(socket, "bin.png");
            else
                Console.writeLine("Message:%s", TcpUtil.receiveStringViaLength(socket));
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
