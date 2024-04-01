package org.csystem.app.imageprocessing.client;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.annotation.Command;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class CommandsInfo {
    private static final String ERR_N = "ERR_N";

    private static final String SUC_GS = "SUC_GS";

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
            TcpUtil.sendLine(socket, "gs");
            var cmd = TcpUtil.receiveLine(socket);

            if (cmd.equals("ERR_CMD"))
                return;

            TcpUtil.sendLine(socket, name);

            var statusStr = TcpUtil.receiveLine(socket);

            if (statusStr.equals(ERR_N)) {
                Console.writeLine("Message:%s", TcpUtil.receiveLine(socket));
                return;
            }

            TcpUtil.sendFile(socket, file, blockSize);

            if (TcpUtil.receiveLine(socket).equals(SUC_GS))
                TcpUtil.receiveFile(socket, "gs.png");
            else
                Console.writeLine("Message:%s", TcpUtil.receiveLine(socket));
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
        catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
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

        try (var socket = new Socket(m_host, m_port)) {
            var blockSize = Integer.parseInt(blockSizeStr);
            var threshold = Integer.parseInt(thresholdStr);

            TcpUtil.sendLine(socket, "bin");

            var cmd = TcpUtil.receiveLine(socket);

            if (cmd.equals("ERR_CMD"))
                return;

            TcpUtil.sendLine(socket, name);

            var statusStr = TcpUtil.receiveLine(socket);

            if (statusStr.equals(ERR_N)) {
                Console.writeLine("Message:%s", TcpUtil.receiveLine(socket));
                return;
            }

            TcpUtil.sendFile(socket, file, blockSize);
            TcpUtil.sendInt(socket, threshold);

            if (TcpUtil.receiveLine(socket).equals(SUC_BIN))
                TcpUtil.receiveFile(socket, "bin.png");
            else
                Console.writeLine("Message:%s", TcpUtil.receiveLine(socket));
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

    @Command("heq")
    private void makeHistogramEqualize(String name, String path, String blockSizeStr)
    {
        var file = new File(path);
        if (!file.exists()) {
            Console.Error.writeLine("Image not found");
            return;
        }

        try (var socket = new Socket(m_host, m_port)) {
            var blockSize = Integer.parseInt(blockSizeStr);
            TcpUtil.sendLine(socket, "heq");
            var cmd = TcpUtil.receiveLine(socket);

            if (cmd.equals("ERR_CMD")) {
                Console.writeLine("Error Message:%s", TcpUtil.receiveLine(socket));
                return;
            }

            TcpUtil.sendLine(socket, name);

            var statusStr = TcpUtil.receiveLine(socket);

            if (statusStr.equals(ERR_N)) {
                Console.writeLine("Message:%s", TcpUtil.receiveLine(socket));
                return;
            }

            TcpUtil.sendFile(socket, file, blockSize);

            if (TcpUtil.receiveLine(socket).equals(SUC_GS))
                TcpUtil.receiveFile(socket, "gs.png");
            else
                Console.writeLine("Message:%s", TcpUtil.receiveLine(socket));
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
