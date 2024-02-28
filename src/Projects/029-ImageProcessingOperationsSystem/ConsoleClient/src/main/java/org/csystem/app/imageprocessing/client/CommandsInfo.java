package org.csystem.app.imageprocessing.client;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandprompt.annotation.Command;

import java.io.*;
import java.net.Socket;

public class CommandsInfo {
    private final String m_host;
    private final int m_port;

    @Command("gs")
    private void makeGrayScale(String path)
    {
        var file = new File(path);
        if (!file.exists()) {
            Console.Error.writeLine("Image not found");
            return;
        }

        try (var socket = new Socket(m_host, m_port);  var fis = new FileInputStream(file)) {
            var os = socket.getOutputStream();
            var is = socket.getInputStream();
            var dos = new DataOutputStream(os);

            dos.writeLong(file.length());

            int b;

            while ((b = fis.read()) != -1)
                os.write(b);

            var result = is.read();

            if (result == 1) {
                Console.writeLine("Sent!...");
            }
            else {
                Console.writeLine("Not sent!...");
            }
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO exception occurred:%s", ex.getMessage());
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
